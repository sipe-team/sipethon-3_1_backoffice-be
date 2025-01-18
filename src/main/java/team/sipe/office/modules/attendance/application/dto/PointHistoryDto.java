package team.sipe.office.modules.attendance.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.sipe.office.modules.attendance.domain.point.PointHistory;
import team.sipe.office.modules.attendance.domain.point.PointType;

import java.time.LocalDate;


@Getter
@AllArgsConstructor(staticName = "of")
public class PointHistoryDto {
    private Integer phase;
    private LocalDate date;
    private PointType pointType;
    private Integer point;
    private String reason;

    public static PointHistoryDto from(PointHistory pointHistory, String date) {
        return PointHistoryDto.of(
                pointHistory.getPhase(),
                date != null ? LocalDate.parse(date) : null,
                pointHistory.getPointType(),
                pointHistory.getPoint(),
                pointHistory.getReason()
        );
    }
}
