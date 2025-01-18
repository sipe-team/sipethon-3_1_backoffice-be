package team.sipe.office.modules.attendance.application.command;

import jakarta.validation.constraints.NotNull;
import team.sipe.office.global.validate.CommandValidating;

public record AttendanceCreateCommand(@NotNull String name,
                                      @NotNull String phone,
                                      @NotNull Integer term,
                                      @NotNull Integer phase) implements CommandValidating<AttendanceCreateCommand> {
    public AttendanceCreateCommand(@NotNull String name,
                                   @NotNull String phone,
                                   @NotNull Integer term, @NotNull Integer phase) {
        this.name = name;
        this.phone = phone;
        this.term = term;
        this.phase = phase;
        this.validateSelf(this);
    }
}
