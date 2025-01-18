package team.sipe.office.modules.attendance.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.sipe.office.modules.attendance.domain.Attendance;
import team.sipe.office.modules.attendance.domain.AttendanceRepository;
import team.sipe.office.modules.attendance.infrastructure.mapper.AttendanceEntityMapper;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceEntityRepository;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceId;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AttendanceRepositoryAdaptor implements AttendanceRepository {

    private final AttendanceEntityMapper attendanceEntityMapper;
    private final AttendanceEntityRepository attendanceEntityRepository;


    @Override
    public Optional<Attendance> findById(AttendanceId id) {
        return attendanceEntityRepository.findById(id).map(attendanceEntityMapper::toDomain);
    }

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceEntityMapper.toDomain(attendanceEntityRepository.save(attendanceEntityMapper.toEntity(attendance)));
    }
}
