package team.sipe.office.modules.attendance.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.sipe.office.modules.attendance.api.dto.request.AttendanceCriteriaUpdateRequest;
import team.sipe.office.modules.attendance.api.dto.view.AttendancePhaseReadView;
import team.sipe.office.modules.attendance.application.AttendanceReadService;
import team.sipe.office.modules.attendance.application.QrCodeGenerateService;
import team.sipe.office.modules.attendance.application.command.PhaseReadCommand;
import team.sipe.office.modules.attendance.application.dto.PhaseDto;
import team.sipe.office.modules.attendance.domain.AttendanceCriteria;

import java.util.List;
import java.util.Optional;

@Tag(name = "출석")
@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceApi {

    private final AttendanceReadService attendanceReadService;
    private final QrCodeGenerateService qrCodeGenerateService;

    @GetMapping("/phases")
    public ResponseEntity<List<AttendancePhaseReadView>> findCriteria(@RequestParam("term") Integer term) {
        List<PhaseDto> dto = attendanceReadService.findPhases(new PhaseReadCommand(term));

        return ResponseEntity.ok().body(dto.stream().map(phase -> AttendancePhaseReadView.from(phase.phase(), phase.date())).toList());
    }

    @PutMapping("/qrCode")
    public ResponseEntity<byte[]> updateQrCode(@RequestBody AttendanceCriteriaUpdateRequest rq) {
        return ResponseEntity.ok().body(qrCodeGenerateService.updateQrCode(rq.toCommand()));
    }
}
