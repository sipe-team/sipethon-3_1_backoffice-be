package team.sipe.office.modules.attendance.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
}
