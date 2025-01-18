package team.sipe.office.modules.activity.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.sipe.office.modules.activity.api.dto.view.ActivityView;
import team.sipe.office.modules.activity.infrastructure.ActivityDao;

import java.util.List;

@Tag(name = "활동")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ActivityApi {
    private final ActivityDao activityDao;

    @GetMapping("/activities")
    public ResponseEntity<List<ActivityView>> getActivities(@RequestParam("term") Integer term) {
        return ResponseEntity.ok(activityDao.getActivityList(term));
    }
}
