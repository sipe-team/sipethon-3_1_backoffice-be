package team.sipe.office.modules.admin.api;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/api/test")
    public ResponseEntity<String> test(
            HttpSession httpSession
    ) {
        final String id = httpSession.getId();
        System.out.println(id);
        return ResponseEntity.ok().body(id);
    }
}
