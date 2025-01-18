package team.sipe.office.modules.admin.api;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.sipe.office.modules.admin.api.dto.AdminLoginRequest;
import team.sipe.office.modules.admin.application.AdminAuthService;
import team.sipe.office.modules.admin.domain.Admin;

@RequestMapping("/api/admin/auth")
@RestController
public class AdminAuthApi {

    private final AdminAuthService adminAuthService;

    public AdminAuthApi(final AdminAuthService adminAuthService) {
        this.adminAuthService = adminAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @RequestBody final AdminLoginRequest request,
            final HttpSession httpSession
    ) {
        final Admin admin = adminAuthService.login(request.command());
        httpSession.setAttribute("id", admin.getId());
        httpSession.setMaxInactiveInterval(24 * 60 * 60);
        return ResponseEntity.ok().build();
    }
}
