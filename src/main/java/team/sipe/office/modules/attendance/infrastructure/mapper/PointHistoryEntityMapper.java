package team.sipe.office.modules.attendance.infrastructure.mapper;

import org.springframework.stereotype.Component;
import team.sipe.office.global.mapper.DomainEntityMapper;
import team.sipe.office.modules.attendance.domain.point.PointHistory;
import team.sipe.office.modules.attendance.infrastructure.persistence.point.PointHistoryEntity;

@Component
public class PointHistoryEntityMapper implements DomainEntityMapper<PointHistory, PointHistoryEntity> {
    @Override
    public PointHistory toDomain(final PointHistoryEntity pointHistoryEntity) {
        return PointHistory.of(
                pointHistoryEntity.getTerm(),
                pointHistoryEntity.getPhase(),
                pointHistoryEntity.getMemberId(),
                pointHistoryEntity.getPointType(),
                pointHistoryEntity.getPoint(),
                pointHistoryEntity.getReason()
        );
    }

    @Override
    public PointHistoryEntity toEntity(final PointHistory pointHistory) {
        return PointHistoryEntity.of(
          pointHistory.getTerm(),
          pointHistory.getPhase(),
          pointHistory.getMemberId(),
          pointHistory.getPointType(),
          pointHistory.getPoint(),
          pointHistory.getReason()
        );
    }

}
