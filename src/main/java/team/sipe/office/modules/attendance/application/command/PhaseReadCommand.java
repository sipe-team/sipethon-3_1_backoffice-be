package team.sipe.office.modules.attendance.application.command;

import jakarta.validation.constraints.NotNull;
import team.sipe.office.global.validate.CommandValidating;

public record PhaseReadCommand(
        @NotNull Integer term) implements CommandValidating<PhaseReadCommand> {
    public PhaseReadCommand(Integer term) {
        this.term = term;
        this.validateSelf(this);
    }
}
