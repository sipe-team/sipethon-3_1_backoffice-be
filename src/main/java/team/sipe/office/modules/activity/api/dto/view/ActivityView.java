package team.sipe.office.modules.activity.api.dto.view;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ActivityView {
    private int phase;
    private String date;
    private String description;
}
