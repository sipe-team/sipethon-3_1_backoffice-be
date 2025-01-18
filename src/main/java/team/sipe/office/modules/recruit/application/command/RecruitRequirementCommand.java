package team.sipe.office.modules.recruit.application.command;

import jakarta.validation.constraints.NotBlank;
import team.sipe.office.global.validate.CommandValidating;
import java.time.LocalDateTime;

public record RecruitActivityCommand(
        @NotBlank int term,
        @NotBlank int phase,
        @NotBlank LocalDateTime date,
        @NotBlank String content,
        Array<String> tag
) implements CommandValidating<RecruitActivityCommand> {

    public RecruitActivityCommand(final int term, final int phase, final LocalDateTime date) {
        this.id = id;
        this.password = password;
        this.validateSelf(this);
    }
}
