package team.sipe.office.modules.attendance.infrastructure.qrcode;

import org.springframework.stereotype.Component;

@Component
public class AttendanceUrlGenerator {

    //TODO change this to the real URL
    private static final String BASE_URL = "https://backoffice.conects.com/view/attendance/attendanceCheck";

    public String generateUrl(String term, String phase) {
        return BASE_URL + "?term=" + term + "&phase=" + phase;
    }
}
