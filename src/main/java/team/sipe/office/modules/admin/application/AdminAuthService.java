package team.sipe.office.modules.admin.application;

import org.springframework.stereotype.Service;
import team.sipe.office.modules.admin.application.command.AdminLoginCommand;
import team.sipe.office.modules.admin.domain.Admin;
import team.sipe.office.modules.admin.domain.AdminRepository;

@Service
public class AdminAuthService {

    private final AdminRepository adminRepository;

    public AdminAuthService(final AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**
     * 암호화 적용해야함
     *
     * @param command
     * @return
     */
    public Admin login(final AdminLoginCommand command) {
        final Admin admin = adminRepository.findById(command.id());
        admin.login(command.password());
        return admin;
    }
}
