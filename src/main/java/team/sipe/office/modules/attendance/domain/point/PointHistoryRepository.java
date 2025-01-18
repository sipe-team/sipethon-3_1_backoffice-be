package team.sipe.office.modules.attendance.domain.point;

import java.util.List;

public interface PointHistoryRepository {

    List<PointHistory> findByTermAndMemberId(Integer term, Long memberId);

    void save(PointHistory pointHistory);
}
