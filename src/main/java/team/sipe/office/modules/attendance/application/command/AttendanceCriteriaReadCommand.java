package team.sipe.office.modules.attendance.application.command;

import jakarta.validation.constraints.NotNull;
import team.sipe.office.global.validate.CommandValidating;

public record AttendanceCriteriaReadCommand(
        @NotNull Integer term,
        @NotNull Integer phase) implements CommandValidating<AttendanceCriteriaReadCommand> {
    public AttendanceCriteriaReadCommand(Integer term, Integer phase) {
        this.term = term;
        this.phase = phase;
        this.validateSelf(this);
    }
}
