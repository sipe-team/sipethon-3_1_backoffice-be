package team.sipe.office.modules.attendance.api.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class PointsReadView {

    private final Integer points;
    private final Integer maxPoints;
    private final List<PointHistoryView> pointHistories;

}
