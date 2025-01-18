package team.sipe.office.modules.recruit.api.dto;

import team.sipe.office.modules.recruit.application.command.RecruitActivityCommand;
import java.time.LocalDateTime;

public record RecruitActivityRequest(
        int term,
        int phase,
        LocalDateTime date,
        String content,
        Array<String> tag

) {
    public RecruitActivityCommand command() {
        return new RecruitActivityCommand(term, phase, date, content, tag);
    }

}
