package team.sipe.office.modules.attendance.infrastructure.mapper;

import org.springframework.stereotype.Component;
import team.sipe.office.global.mapper.DomainEntityMapper;
import team.sipe.office.modules.attendance.domain.Attendance;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceEntity;

@Component
public class AttendanceEntityMapper implements DomainEntityMapper<Attendance, AttendanceEntity> {
    @Override
    public Attendance toDomain(final AttendanceEntity attendanceEntity) {
        return Attendance.of(
                attendanceEntity.getTerm(),
                attendanceEntity.getPhase(),
                attendanceEntity.getMemberId(),
                attendanceEntity.getAttendanceTime()
        );
    }

    @Override
    public AttendanceEntity toEntity(final Attendance attendance) {
        return new AttendanceEntity(
          attendance.getTerm(),
            attendance.getPhase(),
          attendance.getMemberId(),
          attendance.getAttendanceTime()
        );
    }
}
