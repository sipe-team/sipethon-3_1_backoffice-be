package team.sipe.office.modules.attendance.api.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.sipe.office.modules.attendance.application.dto.PointHistoryDto;
import team.sipe.office.modules.attendance.domain.point.PointType;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(staticName = "of")
public class PointHistoryView {
    private final Integer phase;
    private final LocalDate date;
    private final PointType type;
    private final Integer point;
    private final String reason;

    public static PointHistoryView from(PointHistoryDto dto) {
        return PointHistoryView.of(dto.getPhase(), dto.getDate(), dto.getPointType(), dto.getPoint(), dto.getReason());
    }
}
