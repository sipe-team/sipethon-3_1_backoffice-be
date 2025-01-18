package team.sipe.office.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.sipe.office.global.error.ApiExceptionResponse;
import team.sipe.office.global.error.exception.AuthenticationException;
import team.sipe.office.global.error.exception.ErrorCode;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Configuration
public class MvcConfig {

    private final ObjectMapper objectMapper;

    public MvcConfig(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Bean
    public FilterRegistrationBean<ErrorHandlingFilter> errorHandlingFilter() {
        FilterRegistrationBean<ErrorHandlingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ErrorHandlingFilter(objectMapper));
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter() {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);
        return registrationBean;
    }
}

class ErrorHandlingFilter implements Filter {

    private final ObjectMapper objectMapper;

    public ErrorHandlingFilter(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            final ErrorCode errorCode = errorCode(e);
            final ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                    errorCode.errorCode(),
                    errorCode.message());
            final HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setStatus(errorCode.statusCode());
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=UTF-8");
            httpResponse.getWriter().write(objectMapper.writeValueAsString(apiExceptionResponse));
        }
    }

    private ErrorCode errorCode(final Exception e) {
        return switch (e) {
            case AuthenticationException ignored -> ErrorCode.ADMIN_AUTHENTICATION_FAILED;
            default -> ErrorCode.INTERNAL_SERVER_ERROR;
        };
    }
}


class AuthenticationFilter implements Filter {

    private static final List<String> ALLOWED_API_PATHS = List.of(
            "/api/admin/auth/login",
            "/swagger-ui/",
            "/v3/api-docs/",
            "/view"
    );

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (ALLOWED_API_PATHS.stream().anyMatch(request.getRequestURI()::contains)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        Optional.ofNullable(request.getSession())
                .map(session -> session.getAttribute("id"))
                .orElseThrow(AuthenticationException::new);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
