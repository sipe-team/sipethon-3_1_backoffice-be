package team.sipe.office.modules.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.sipe.office.modules.attendance.application.command.PhaseReadCommand;
import team.sipe.office.modules.attendance.application.dto.PhaseDto;
import team.sipe.office.modules.attendance.domain.AttendanceCriteriaRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceReadService {

    private final AttendanceCriteriaRepository attendanceCriteriaRepository;

    public List<PhaseDto> findPhases(PhaseReadCommand cmd) {
        return List.of(
                new PhaseDto(1, LocalDate.now().minusWeeks(1)),
                new PhaseDto(2, LocalDate.now()),
                new PhaseDto(3, LocalDate.now().plusWeeks(1))
        );
    }
}
