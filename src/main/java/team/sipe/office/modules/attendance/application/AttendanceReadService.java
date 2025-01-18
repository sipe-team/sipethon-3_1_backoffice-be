package team.sipe.office.modules.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.sipe.office.modules.attendance.api.dto.view.PointsReadView;
import team.sipe.office.modules.attendance.application.command.PhaseReadCommand;
import team.sipe.office.modules.attendance.application.dto.PhaseDto;
import team.sipe.office.modules.attendance.application.dto.PointHistoryDto;
import team.sipe.office.modules.attendance.application.dto.PointsDto;
import team.sipe.office.modules.attendance.domain.AttendanceCriteriaRepository;
import team.sipe.office.modules.attendance.domain.point.PointType;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceReadService {

    private final AttendanceCriteriaRepository attendanceCriteriaRepository;

    public List<PhaseDto> findPhases(PhaseReadCommand cmd) {
        return List.of(
                new PhaseDto(1, LocalDate.now()),
                new PhaseDto(2, LocalDate.now()),
                new PhaseDto(3, LocalDate.now())
        );
    }

    public PointsDto readPoints(Long memberId, Integer term) {
        PointType attendance = PointType.ATTENDANCE;

        return PointsDto.of(10,
                100,
                List.of(PointHistoryDto.of(1, LocalDate.now(), attendance, attendance.getPoint(), "") )
        );
    }
}
