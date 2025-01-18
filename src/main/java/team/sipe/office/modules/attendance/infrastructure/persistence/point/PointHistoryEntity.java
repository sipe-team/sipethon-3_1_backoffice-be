package team.sipe.office.modules.attendance.infrastructure.persistence.point;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.sipe.office.global.jpa.BaseTimeEntity;
import team.sipe.office.modules.attendance.domain.point.PointType;

@Getter
@Entity
@Table(name = "point_history", indexes = {
        @Index(name = "idx_point_history_term_phase_member_id", columnList = "term, member_id")
})
@IdClass(PointHistoryId.class)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC, staticName = "of")
public class PointHistoryEntity extends BaseTimeEntity {
    @Id
    @Column(name = "term", nullable = false)
    private Integer term;
    @Id
    @Column(name = "phase", nullable = false)
    private Integer phase;
    @Id
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    @Column(name = "point_type", nullable = false)
    private PointType pointType;

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "reason")
    private String reason;
}
