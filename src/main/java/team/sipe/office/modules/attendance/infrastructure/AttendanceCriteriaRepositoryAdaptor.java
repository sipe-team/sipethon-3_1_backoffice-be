package team.sipe.office.modules.attendance.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.sipe.office.modules.attendance.domain.AttendanceCriteriaRepository;
import team.sipe.office.modules.attendance.infrastructure.mapper.AttendanceCriteriaEntityMapper;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaEntityRepository;

@Component
@RequiredArgsConstructor
public class AttendanceCriteriaRepositoryAdaptor implements AttendanceCriteriaRepository {

    private final AttendanceCriteriaEntityMapper attendanceCriteriaEntityMapper;
    private final AttendanceCriteriaEntityRepository attendanceCriteriaEntityRepository;

}
