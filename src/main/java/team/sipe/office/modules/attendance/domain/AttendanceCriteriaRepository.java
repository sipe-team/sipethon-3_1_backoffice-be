package team.sipe.office.modules.attendance.domain;

import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaId;

import java.util.Optional;

public interface AttendanceCriteriaRepository {
    Optional<AttendanceCriteria> findById(AttendanceCriteriaId id);
}
