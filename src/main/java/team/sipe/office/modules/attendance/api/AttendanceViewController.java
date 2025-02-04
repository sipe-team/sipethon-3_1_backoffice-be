package team.sipe.office.modules.attendance.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.sipe.office.modules.attendance.application.AttendanceCommandService;
import team.sipe.office.modules.attendance.application.command.AttendanceCreateCommand;
import team.sipe.office.modules.attendance.application.dto.SubmitDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view/attendance")
public class AttendanceViewController {

    private final AttendanceCommandService attendanceCommandService;

    @GetMapping("/attendanceCheck")
    public String showAttendanceCheck(@RequestParam("term") int term, @RequestParam("phase") int phase, Model model) {
        model.addAttribute("term", term);
        model.addAttribute("phase", phase);

        return "attendanceCheck";
    }

    @PostMapping("/submit")
    public String submitAttendance(@RequestParam("name") String name,
                                   @RequestParam("phoneNumber") String phoneNumber,
                                   @RequestParam("term") int term,
                                   @RequestParam("phase") int phase,
                                   Model model) {
        try {
            SubmitDto dto = attendanceCommandService.saveAttendance(new AttendanceCreateCommand(name, phoneNumber, term, phase, ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDateTime()));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy년 MM월 dd일 EEEE a h시 mm분 ss초", Locale.KOREAN);

            model.addAttribute("name", name);
            model.addAttribute("phoneNumber", phoneNumber);
            model.addAttribute("submitType", dto.getPointType().getName());
            model.addAttribute("submitTime", dto.getSubmitTime().format(formatter));
        }
        catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "attendanceError";
        }

        return "attendanceComplete";
    }
}
