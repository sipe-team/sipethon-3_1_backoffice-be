package team.sipe.office.modules.attendance.domain.point;

import lombok.Getter;

@Getter
public enum PointType {
    ATTENDANCE("출석", 10),
    LATE("지각", 5),
    ABSENCE("결석", 0)
    ;

    private final String name;
    private final int point; //차감포인트;

    PointType(final String name, final int point) {
        this.name = name;
        this.point = point;
    }
}
