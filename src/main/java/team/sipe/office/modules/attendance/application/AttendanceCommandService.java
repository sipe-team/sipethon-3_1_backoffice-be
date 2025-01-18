package team.sipe.office.modules.attendance.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.sipe.office.modules.attendance.application.command.AttendanceCreateCommand;
import team.sipe.office.modules.attendance.domain.Attendance;
import team.sipe.office.modules.attendance.domain.AttendanceCriteria;
import team.sipe.office.modules.attendance.domain.AttendanceCriteriaRepository;
import team.sipe.office.modules.attendance.domain.AttendanceRepository;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaId;
import team.sipe.office.modules.member.domain.Member;
import team.sipe.office.modules.member.domain.MemberRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class AttendanceCommandService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceCriteriaRepository attendanceCriteriaRepository;
    private final MemberRepository memberRepository;

    public LocalDateTime saveAttendance(AttendanceCreateCommand cmd) {
        Member member = memberRepository.findByNameAndPhone(cmd.name(), cmd.phone())
                .orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));

        AttendanceCriteria criteria = attendanceCriteriaRepository.findById(AttendanceCriteriaId.of(cmd.term(), cmd.phase()))
                .orElseThrow(() -> new RuntimeException("출석 기준을 찾을 수 없습니다."));

        return attendanceRepository.save(Attendance.of(cmd.term(), cmd.phase(), member.getId(), LocalDateTime.now())).getAttendanceTime();
    }
}
