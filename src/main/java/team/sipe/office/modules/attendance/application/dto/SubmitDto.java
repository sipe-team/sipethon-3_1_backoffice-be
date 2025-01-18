package team.sipe.office.modules.attendance.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.sipe.office.modules.attendance.domain.point.PointType;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(staticName = "of")
public class SubmitDto {
    private PointType pointType;
    private LocalDateTime submitTime;
}
