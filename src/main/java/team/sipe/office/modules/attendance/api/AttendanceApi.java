package team.sipe.office.modules.attendance.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.sipe.office.modules.attendance.api.dto.view.AttendanceCriteriaView;
import team.sipe.office.modules.attendance.application.AttendanceReadService;
import team.sipe.office.modules.attendance.application.command.AttendanceCriteriaReadCommand;
import team.sipe.office.modules.attendance.domain.AttendanceCriteria;

import java.util.Optional;

@Tag(name = "출석")
@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceApi {

    private final AttendanceReadService attendanceService;

    @GetMapping("/criteria")
    public ResponseEntity<AttendanceCriteriaView> findCriteria(@RequestParam("term") Integer term,
                                                               @RequestParam("phase") Integer phase) {
        Optional<AttendanceCriteria> criteria = attendanceService.findCriteria(new AttendanceCriteriaReadCommand(term, phase));

        return ResponseEntity.ok().body(AttendanceCriteriaView.from(criteria));
    }
}
