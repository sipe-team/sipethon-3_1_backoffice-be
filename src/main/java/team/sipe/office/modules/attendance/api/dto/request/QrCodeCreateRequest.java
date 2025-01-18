package team.sipe.office.modules.attendance.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import team.sipe.office.modules.attendance.application.command.AttendanceCriteriaUpdateCommand;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Schema(description = "Qrcode 생성 api request")
@Getter
public class QrCodeCreateRequest {

    @Schema(description = "기수", example = "1")
    private int term;
    @Schema(description = "회차", example = "1")
    private int phase;
    @Schema(description = "시작 시간", example = "2025.01.18 09:00")
    private String startTime;
    @Schema(description = "지각 시간", example = "2025.01.19 09:00")
    private String lateTime;
    @Schema(description = "결석 시간", example = "2025.01.20 09:00")
    private String absenceTime;

    public AttendanceCriteriaUpdateCommand toCommand() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime lateDateTime = LocalDateTime.parse(lateTime, formatter);
        LocalDateTime absenceDateTime = LocalDateTime.parse(absenceTime, formatter);

        return new AttendanceCriteriaUpdateCommand(
                term,
                phase,
                startDateTime,
                lateDateTime,
                absenceDateTime
        );
    }
}
