package team.sipe.office.modules.attendance.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.sipe.office.modules.attendance.application.command.AttendanceCriteriaReadCommand;
import team.sipe.office.modules.attendance.domain.AttendanceCriteria;
import team.sipe.office.modules.attendance.domain.AttendanceCriteriaRepository;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaId;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceReadService {

    private final AttendanceCriteriaRepository attendanceCriteriaRepository;

    public Optional<AttendanceCriteria> findCriteria(AttendanceCriteriaReadCommand cmd) {
        return attendanceCriteriaRepository.findById(AttendanceCriteriaId.of(cmd.term(), cmd.phase()));
    }
}
