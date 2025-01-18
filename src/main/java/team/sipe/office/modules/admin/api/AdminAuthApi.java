package team.sipe.office.modules.admin.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.sipe.office.modules.admin.api.dto.AdminLoginRequest;
import team.sipe.office.modules.admin.application.AdminAuthService;

@RestController("/api/admin/auth")
public class AdminAuthApi {

    private final AdminAuthService adminAuthService;

    public AdminAuthApi(final AdminAuthService adminAuthService) {
        this.adminAuthService = adminAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @RequestBody final AdminLoginRequest request
    ) {
        adminAuthService.login(request.command());
        return ResponseEntity.ok().build();
    }
}
