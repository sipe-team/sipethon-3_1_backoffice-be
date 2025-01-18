package team.sipe.office.modules.attendance.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceCriteriaEntityRepository extends JpaRepository<AttendanceCriteriaEntity, AttendanceCriteriaId> {
}
