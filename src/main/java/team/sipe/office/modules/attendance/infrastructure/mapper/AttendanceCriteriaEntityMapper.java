package team.sipe.office.modules.attendance.infrastructure.mapper;

import org.springframework.stereotype.Component;
import team.sipe.office.global.mapper.DomainEntityMapper;
import team.sipe.office.modules.attendance.domain.AttendanceCriteria;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaEntity;

@Component
public class AttendanceCriteriaEntityMapper implements DomainEntityMapper<AttendanceCriteria, AttendanceCriteriaEntity> {
    @Override
    public AttendanceCriteria toDomain(final AttendanceCriteriaEntity attendanceCriteriaEntity) {
        return AttendanceCriteria.of(
                attendanceCriteriaEntity.getTerm(),
                attendanceCriteriaEntity.getPhase(),
                attendanceCriteriaEntity.getStartTime(),
                attendanceCriteriaEntity.getLateTime(),
                attendanceCriteriaEntity.getAbsenceTime()
        );
    }

    @Override
    public AttendanceCriteriaEntity toEntity(final AttendanceCriteria attendanceCriteria) {
        return new AttendanceCriteriaEntity(
          attendanceCriteria.getTerm(),
          attendanceCriteria.getPhase(),
          attendanceCriteria.getStartTime(),
          attendanceCriteria.getLateTime(),
          attendanceCriteria.getAbsenceTime()
        );
    }
}
