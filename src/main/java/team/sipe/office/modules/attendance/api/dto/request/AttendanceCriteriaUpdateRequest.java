package team.sipe.office.modules.attendance.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import team.sipe.office.modules.attendance.application.command.AttendanceCriteriaUpdateCommand;

import java.time.LocalDateTime;

@Schema(description = "Qrcode 생성 api request")
@Getter
public class AttendanceCriteriaUpdateRequest {

    @Schema(description = "기수")
    private int term;
    @Schema(description = "회차")
    private int phase;
    @Schema(description = "시작 시간")
    private LocalDateTime startTime;
    @Schema(description = "지각 시간")
    private LocalDateTime lateTime;
    @Schema(description = "결석 시간")
    private LocalDateTime absenceTime;

    public AttendanceCriteriaUpdateCommand toCommand() {
        return new AttendanceCriteriaUpdateCommand(term, phase, startTime, lateTime, absenceTime);
    }
}
