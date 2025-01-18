package team.sipe.office.global.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team.sipe.office.global.error.exception.ErrorCode;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionResponse> handleException(Exception e) {
        final ErrorCode errorCode = switch (e) {
            case AuthenticationException ignored -> ErrorCode.ADMIN_AUTHENTICATION_FAILED;
            default -> ErrorCode.INTERNAL_SERVER_ERROR;
        };
        return ResponseEntity.status(errorCode.statusCode()).body(response(errorCode));
    }

    private ApiExceptionResponse response(final ErrorCode errorCode) {
        return new ApiExceptionResponse(
                errorCode.errorCode(),
                errorCode.message());
    }
}
