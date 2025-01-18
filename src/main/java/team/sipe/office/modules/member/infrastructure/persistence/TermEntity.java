package team.sipe.office.modules.member.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.sipe.office.global.jpa.BaseTimeEntity;

@Getter
@Table(name = "term")
@Entity
@NoArgsConstructor
public class TermEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "term", nullable = false)
    private int term;

    @Column(name = "is_staff", nullable = false)
    private boolean isStaff;

    @Setter
    @JoinColumn(name = "member_id")
    @ManyToOne
    private MemberEntity member;

    public TermEntity(Long seq, int term, boolean isStaff) {
        this.seq = seq;
        this.term = term;
        this.isStaff = isStaff;
    }
}
