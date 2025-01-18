package team.sipe.office.modules.attendance.infrastructure.qrcode;

import org.springframework.stereotype.Component;

@Component
public class AttendanceUrlGenerator {

    private static final String BASE_URL = "http://localhost:8080/attendanceCheck";

    public String generateUrl(String term, String phase) {
        return BASE_URL + "?term=" + term + "&phase=" + phase;
    }
}
