package team.sipe.office.modules.attendance.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.sipe.office.global.jpa.BaseTimeEntity;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AttendanceCriteria extends BaseTimeEntity {
    private Long term;
    private Long phase;
    private LocalDateTime startTime;
    private int lateMinute;
    private int absenceMinute;
}
