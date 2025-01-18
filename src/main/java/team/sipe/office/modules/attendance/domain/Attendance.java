package team.sipe.office.modules.attendance.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC, staticName = "of")
public class Attendance {
    private Integer term;
    private Integer phase;
    private Long memberId;
    private LocalDateTime attendanceTime;
}
