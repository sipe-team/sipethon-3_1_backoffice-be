package team.sipe.office.global.error;

public record ApiExceptionResponse(
        String errorCode,
        String message
) {
}
