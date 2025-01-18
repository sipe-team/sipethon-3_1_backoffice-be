package team.sipe.office.modules.attendance.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.sipe.office.modules.attendance.application.command.AttendanceCriteriaUpdateCommand;
import team.sipe.office.modules.attendance.domain.AttendanceCriteria;
import team.sipe.office.modules.attendance.domain.AttendanceCriteriaRepository;
import team.sipe.office.modules.attendance.infrastructure.persistence.AttendanceCriteriaId;
import team.sipe.office.modules.attendance.infrastructure.qrcode.AttendanceUrlGenerator;
import team.sipe.office.modules.attendance.infrastructure.qrcode.QrCodeGenerateClient;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class QrCodeGenerateService {

    private final AttendanceCriteriaRepository attendanceCriteriaRepository;
    private final QrCodeGenerateClient qrCodeGenerateClient;
    private final AttendanceUrlGenerator attendanceUrlGenerator;
    private static final String QR_CODE_SIZE = "150";

    public byte[] createQrCode(AttendanceCriteriaUpdateCommand cmd) {

        AttendanceCriteria criteria = attendanceCriteriaRepository.updateCriteria(
                AttendanceCriteria.of(
                        cmd.term(),
                        cmd.phase(),
                        cmd.startTime(),
                        cmd.lateTime(),
                        cmd.absenceTime()
                )
        );

        String url = attendanceUrlGenerator.generateUrl(String.valueOf(criteria.getTerm()), String.valueOf(criteria.getPhase()));

        return qrCodeGenerateClient.generateQrCode(QR_CODE_SIZE, url);
    }
}
