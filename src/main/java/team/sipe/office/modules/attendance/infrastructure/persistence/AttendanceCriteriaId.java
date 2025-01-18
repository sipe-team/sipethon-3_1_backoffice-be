package team.sipe.office.modules.attendance.infrastructure.persistence;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class AttendanceCriteriaId implements Serializable {
    private Long term;
    private Long phase;
}
