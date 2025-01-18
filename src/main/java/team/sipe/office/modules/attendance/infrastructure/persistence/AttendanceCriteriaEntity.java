package team.sipe.office.modules.attendance.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import team.sipe.office.global.jpa.BaseTimeEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Entity
@IdClass(AttendanceCriteriaId.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "attendance_criteria", indexes = {
        @Index(name = "idx_attendance_criteria", columnList = "term, phase")
})
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendanceCriteriaEntity extends BaseTimeEntity {

    @Id
    @EqualsAndHashCode.Include
    @Comment("기수")
    @Column(name = "term", nullable = false)
    private Integer term;

    @Id
    @EqualsAndHashCode.Include
    @Comment("회차")
    @Column(name = "phase", nullable = false)
    private Integer phase;

    @Comment("시작 시간")
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Comment("지각 시간")
    @Column(name = "late_time", nullable = false)
    private LocalDateTime lateTime;

    @Comment("결석 시간")
    @Column(name = "absence_time", nullable = false)
    private LocalDateTime absenceTime;
}
