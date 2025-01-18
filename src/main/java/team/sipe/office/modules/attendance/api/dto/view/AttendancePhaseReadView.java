package team.sipe.office.modules.attendance.api.dto.view;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Schema(description = "회차 조회 api 응답")
@AllArgsConstructor
public class AttendancePhaseReadView {

    @Schema(description = "회차", example = "1")
    private final Integer phase;

    @Schema(description = "날짜", example = "2021-09-01")
    private final LocalDate date;

    public static AttendancePhaseReadView from(Integer phase, LocalDate date) {
        return new AttendancePhaseReadView(phase, date);
    }

}
