package team.sipe.office.modules.attendance.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.sipe.office.modules.attendance.api.dto.request.QrCodeCreateRequest;
import team.sipe.office.modules.attendance.api.dto.view.AttendancePhaseReadView;
import team.sipe.office.modules.attendance.api.dto.view.PointHistoryView;
import team.sipe.office.modules.attendance.api.dto.view.PointsReadView;
import team.sipe.office.modules.attendance.application.AttendanceReadService;
import team.sipe.office.modules.attendance.application.QrCodeGenerateService;
import team.sipe.office.modules.attendance.application.command.PhaseReadCommand;
import team.sipe.office.modules.attendance.application.dto.PhaseDto;
import team.sipe.office.modules.attendance.application.dto.PointsDto;

import java.util.List;

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

    @PostMapping("/qrCode")
    public ResponseEntity<byte[]> updateQrCode(@RequestBody QrCodeCreateRequest rq) {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCodeGenerateService.createQrCode(rq.toCommand()));
    }

    @GetMapping("/points")
    public ResponseEntity<PointsReadView> readPoints(@RequestParam("memberId") Long memberId,
                                                     @RequestParam("term") Integer term) {
        PointsDto dto = attendanceReadService.readPoints(memberId, term);
        return ResponseEntity.ok().body(
                PointsReadView.of(
                        dto.getPoints(),
                        dto.getMaxPoints(),
                        dto.getPointHistories().stream().map(PointHistoryView::from).toList())
        );
    }

}
