package team.sipe.office.modules.attendance.application.command;

import jakarta.validation.constraints.NotNull;
import team.sipe.office.global.validate.CommandValidating;

import java.time.LocalDateTime;

public record AttendanceCreateCommand(@NotNull String name,
                                      @NotNull String phone,
                                      @NotNull Integer term,
                                      @NotNull Integer phase,
                                      @NotNull LocalDateTime submitTime) implements CommandValidating<AttendanceCreateCommand> {
    public AttendanceCreateCommand(@NotNull String name,
                                   @NotNull String phone,
                                   @NotNull Integer term,
                                   @NotNull Integer phase,
                                   @NotNull LocalDateTime submitTime) {
        this.name = name;
        this.phone = phone;
        this.term = term;
        this.phase = phase;
        this.submitTime = submitTime;
        this.validateSelf(this);
    }
}
