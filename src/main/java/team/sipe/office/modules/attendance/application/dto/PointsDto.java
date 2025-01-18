package team.sipe.office.modules.attendance.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class PointsDto {
    private Integer points;
    private Integer maxPoints;
    private List<PointHistoryDto> pointHistories;
}
