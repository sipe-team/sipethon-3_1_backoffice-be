package team.sipe.office.modules.attendance.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.sipe.office.modules.attendance.domain.point.PointHistory;
import team.sipe.office.modules.attendance.domain.point.PointHistoryRepository;
import team.sipe.office.modules.attendance.infrastructure.mapper.PointHistoryEntityMapper;
import team.sipe.office.modules.attendance.infrastructure.persistence.point.PointHistoryEntityRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PointHistoryRepositoryAdaptor implements PointHistoryRepository {

    private final PointHistoryEntityRepository pointHistoryEntityRepository;
    private final PointHistoryEntityMapper pointHistoryEntityMapper;


    @Override
    public List<PointHistory> findByTermAndMemberId(Integer term, Long memberId) {
        return List.of();
    }

    @Override
    public void save(PointHistory pointHistory) {
        pointHistoryEntityRepository.save(pointHistoryEntityMapper.toEntity(pointHistory));
    }
}
