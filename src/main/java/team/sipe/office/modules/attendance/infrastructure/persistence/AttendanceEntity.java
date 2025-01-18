package team.sipe.office.modules.attendance.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import team.sipe.office.global.jpa.BaseTimeEntity;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "attendance", indexes = {
        @Index(name = "idx_attendance", columnList = "term, phase")
})
@IdClass(AttendanceId.class)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AttendanceEntity extends BaseTimeEntity {
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

    @Id
    @EqualsAndHashCode.Include
    @Comment("회원 아이디")
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Comment("출석 시간")
    @Column(name = "attendance_time", nullable = false)
    private LocalDateTime attendanceTime;
}
