package team.sipe.office.modules.admin.application.command;

import jakarta.validation.constraints.NotBlank;
import team.sipe.office.global.validate.CommandValidating;

public record AdminLoginCommand(
        @NotBlank String id,
        @NotBlank String password
) implements CommandValidating<AdminLoginCommand> {

    public AdminLoginCommand(final String id, final String password) {
        this.id = id;
        this.password = password;
        this.validateSelf(this);
    }
}
