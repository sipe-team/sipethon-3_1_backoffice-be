package team.sipe.office.global.error.exception;

public class AuthenticationException extends RuntimeException {

    private static final String MESSAGE = "인증에 실패했습니다. 로그인 정보를 확인 부탁드립니다.";

    public AuthenticationException() {
        super(MESSAGE);
    }
}
