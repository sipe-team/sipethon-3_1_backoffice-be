package team.sipe.office.modules.attendance.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.sipe.office.modules.attendance.domain.AttendanceCriteria;
import team.sipe.office.modules.attendance.domain.AttendanceCriteriaRepository;
import team.sipe.office.modules.attendance.infrastructure.mapper.AttendanceCriteriaEntityMapper;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaEntity;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaEntityRepository;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaId;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AttendanceCriteriaRepositoryAdaptor implements AttendanceCriteriaRepository {

    private final AttendanceCriteriaEntityMapper attendanceCriteriaEntityMapper;
    private final AttendanceCriteriaEntityRepository attendanceCriteriaEntityRepository;

    @Override
    public Optional<AttendanceCriteria> findById(AttendanceCriteriaId id) {
        return attendanceCriteriaEntityRepository.findById(id).map(attendanceCriteriaEntityMapper::toDomain);
    }

    @Override
    public AttendanceCriteria updateCriteria(AttendanceCriteria criteria) {
        AttendanceCriteriaEntity save = attendanceCriteriaEntityRepository.save(attendanceCriteriaEntityMapper.toEntity(criteria));

        return attendanceCriteriaEntityMapper.toDomain(save);
    }
}
