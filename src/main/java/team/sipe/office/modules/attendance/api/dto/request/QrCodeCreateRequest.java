package team.sipe.office.modules.attendance.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import team.sipe.office.modules.attendance.application.command.AttendanceCriteriaUpdateCommand;

import java.time.LocalDateTime;

@Schema(description = "Qrcode 생성 api request")
@Getter
public class QrCodeCreateRequest {

    @Schema(description = "기수", example = "3")
    private int term;
    @Schema(description = "회차", example = "1")
    private int phase;
    @Schema(description = "시작 시간", example = "2021-09-01T09:00:00")
    private LocalDateTime startTime;
    @Schema(description = "지각 시간", example = "2021-09-01T09:10:00")
    private LocalDateTime lateTime;
    @Schema(description = "결석 시간", example = "2021-09-01T09:20:00")
    private LocalDateTime absenceTime;

    public AttendanceCriteriaUpdateCommand toCommand() {
        return new AttendanceCriteriaUpdateCommand(term, phase, startTime, lateTime, absenceTime);
    }
}
