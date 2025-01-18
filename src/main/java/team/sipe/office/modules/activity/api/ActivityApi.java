package team.sipe.office.modules.activity.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.sipe.office.modules.activity.api.dto.view.ActivityView;
import team.sipe.office.modules.activity.infrastructure.ActivityDao;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ActivityApi {
    private final ActivityDao activityDao;

    @GetMapping("/activities")
    public ResponseEntity<List<ActivityView>> getActivities() {
        return ResponseEntity.ok(activityDao.getActivityList());
    }
}
