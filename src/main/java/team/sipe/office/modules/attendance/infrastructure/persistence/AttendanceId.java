package team.sipe.office.modules.attendance.infrastructure.persistence;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class AttendanceId implements Serializable {
    private Integer term;
    private Integer phase;
    private Long memberId;
}
