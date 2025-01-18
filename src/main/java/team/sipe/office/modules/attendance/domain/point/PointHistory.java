package team.sipe.office.modules.attendance.domain.point;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC, staticName = "of")
public class PointHistory {
    private Integer term;
    private Integer phase;
    private Long memberId;
    private PointType pointType;
    private Integer point;
    private String reason;
}
