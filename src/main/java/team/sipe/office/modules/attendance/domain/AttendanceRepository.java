package team.sipe.office.modules.attendance.domain;

import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceId;

import java.util.Optional;

public interface AttendanceRepository {

    Optional<Attendance> findById(AttendanceId id);

    Attendance save(Attendance attendance);
}
