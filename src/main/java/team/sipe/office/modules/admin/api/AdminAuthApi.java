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
        refreshSession(httpSession, admin.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
            final HttpSession httpSession
    ) {
        httpSession.removeAttribute("id");
        return ResponseEntity.ok().build();
    }

    private void refreshSession(HttpSession httpSession, String adminId) {
        final String currentSessionId = (String) httpSession.getAttribute("id");
        if (adminId.equals(currentSessionId)) {
            httpSession.setMaxInactiveInterval(24 * 60 * 60);
            return;
        }
        httpSession.setAttribute("id", adminId);
        httpSession.setMaxInactiveInterval(24 * 60 * 60);
    }
}
