package team.sipe.office.modules.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.sipe.office.modules.activity.api.dto.view.ActivityView;
import team.sipe.office.modules.activity.infrastructure.ActivityDao;
import team.sipe.office.modules.attendance.application.command.PhaseReadCommand;
import team.sipe.office.modules.attendance.application.dto.PhaseDto;
import team.sipe.office.modules.attendance.application.dto.PointHistoryDto;
import team.sipe.office.modules.attendance.application.dto.PointsDto;
import team.sipe.office.modules.attendance.domain.AttendanceCriteriaRepository;
import team.sipe.office.modules.attendance.domain.point.PointHistory;
import team.sipe.office.modules.attendance.domain.point.PointHistoryRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceReadService {

    private final AttendanceCriteriaRepository attendanceCriteriaRepository;
    private final PointHistoryRepository pointHistoryRepository;
    private final ActivityDao activityDao;

    public List<PhaseDto> findPhases(PhaseReadCommand cmd) {
        return List.of(
                new PhaseDto(1, LocalDate.now()),
                new PhaseDto(2, LocalDate.now()),
                new PhaseDto(3, LocalDate.now())
        );
    }

    public PointsDto readPoints(Long memberId, Integer term) {

        List<PointHistory> pointHistories = pointHistoryRepository.findByTermAndMemberId(term, memberId);

        Integer pointSum = pointHistories.stream().map(history -> history.getPointType().getPoint()).reduce(Integer::sum).orElse(0);

        List<ActivityView> activityList = activityDao.getActivityList(term);
        int maxPoints = activityList.size() * 10;

        Map<Integer, String> datesByPhase = activityList.stream().collect(Collectors.toMap(ActivityView::getPhase, ActivityView::getDate));

        return PointsDto.of(pointSum,
                maxPoints,
                pointHistories.stream().map(history -> PointHistoryDto.from(history, datesByPhase.getOrDefault(history.getPhase(),""))).toList()
        );
    }
}
