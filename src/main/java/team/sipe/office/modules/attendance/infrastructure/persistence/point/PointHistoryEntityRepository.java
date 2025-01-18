package team.sipe.office.modules.attendance.infrastructure.persistence.point;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PointHistoryEntityRepository extends JpaRepository<PointHistoryEntity, PointHistoryId> {
}
