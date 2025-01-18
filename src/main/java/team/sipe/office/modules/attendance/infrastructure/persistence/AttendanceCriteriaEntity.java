package team.sipe.office.modules.attendance.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import team.sipe.office.global.jpa.BaseTimeEntity;

import java.time.LocalDateTime;

@Getter
@Entity
@IdClass(AttendanceCriteriaId.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "attendance_criteria")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttendanceCriteriaEntity extends BaseTimeEntity {

    @Id
    @EqualsAndHashCode.Include
    @Comment("기수")
    @Column(name = "term")
    private Long term;

    @Id
    @EqualsAndHashCode.Include
    @Comment("회차")
    @Column(name = "phase")
    private Long phase;

    @Comment("시작 시간")
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Comment("지각 기준")
    @Column(name = "late_minute")
    private int lateMinute;

    @Comment("결석 기준")
    @Column(name = "absence_minute")
    private int absenceMinute;
}
