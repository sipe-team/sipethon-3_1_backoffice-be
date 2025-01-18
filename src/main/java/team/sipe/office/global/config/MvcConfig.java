package team.sipe.office.global.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Configuration
public class MvcConfig {

    @Bean
    public Filter servletGatewayFilter() {
        return new ServletGatewayFilter();
    }
}

class ServletGatewayFilter implements Filter {

    private static final List<String> ALLOWED_API_PATHS = List.of(
            "/api/admin/auth/login"
    );

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (ALLOWED_API_PATHS.contains(request.getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        Optional.ofNullable(request.getSession())
                .map(session -> session.getAttribute("id"))
                .orElseThrow(() -> new RuntimeException("로그인이 필요합니다."));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
