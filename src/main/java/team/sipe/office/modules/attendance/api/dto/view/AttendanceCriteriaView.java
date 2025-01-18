package team.sipe.office.modules.attendance.api.dto.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import team.sipe.office.modules.attendance.domain.AttendanceCriteria;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Schema(description = "출석 QR 코드 생성 팝업 view")
@AllArgsConstructor
public class AttendanceCriteriaView {

    @Schema(description = "기수")
    private final Integer term;

    @Schema(description = "회차")
    private final Integer phase;

    @Schema(description = "시작 시간")
    private final LocalDateTime startTime;

    @Schema(description = "지각 기준")
    private final Integer lateMinutes;

    @Schema(description = "결석 기준")
    private final Integer absenceMinutes;

    public static AttendanceCriteriaView from(Optional<AttendanceCriteria> attendanceCriteria) {
        return attendanceCriteria.map(criteria -> new AttendanceCriteriaView(
                criteria.getTerm(),
                criteria.getPhase(),
                criteria.getStartTime(),
                criteria.getLateMinute(),
                criteria.getAbsenceMinute()
        )).orElse(AttendanceCriteriaView.empty());
    }

    public static AttendanceCriteriaView empty() {
        return new AttendanceCriteriaView(null, null, null, null, null);
    }
}
