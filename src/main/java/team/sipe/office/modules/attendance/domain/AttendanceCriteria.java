package team.sipe.office.modules.attendance.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import team.sipe.office.global.jpa.BaseTimeEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC, staticName = "of")
public class AttendanceCriteria extends BaseTimeEntity {
    private int term;
    private int phase;
    private LocalDateTime startTime;
    private LocalDateTime lateTime;
    private LocalDateTime absenceTime;
}
