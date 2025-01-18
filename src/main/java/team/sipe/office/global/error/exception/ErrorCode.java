package team.sipe.office.global.error.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    // Common
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C0001", "서버 내부 오류입니다."),

    // Admin
    ADMIN_AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "A0001", "관리자 인증 확인에 실패했습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;

    ErrorCode(final HttpStatus httpStatus, final String errorCode, final String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    public int statusCode() {
        return httpStatus.value();
    }

    public String errorCode() {
        return errorCode;
    }

    public String message() {
        return message;
    }
}
