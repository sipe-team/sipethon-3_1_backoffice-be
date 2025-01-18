package team.sipe.office.modules.attendance.application.command;

import jakarta.validation.constraints.NotNull;
import team.sipe.office.global.validate.CommandValidating;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record AttendanceCriteriaUpdateCommand
        (@NotNull Integer term,
         @NotNull Integer phase,
         @NotNull LocalDateTime startTime,
         @NotNull LocalDateTime lateTime,
         @NotNull LocalDateTime absenceTime) implements CommandValidating<AttendanceCriteriaUpdateCommand> {

    public AttendanceCriteriaUpdateCommand(Integer term, Integer phase, LocalDateTime startTime, LocalDateTime lateTime, LocalDateTime absenceTime) {
        this.term = term;
        this.phase = phase;
        this.startTime = startTime;
        this.lateTime = lateTime;
        this.absenceTime = absenceTime;
        this.validateSelf(this);
    }
}
