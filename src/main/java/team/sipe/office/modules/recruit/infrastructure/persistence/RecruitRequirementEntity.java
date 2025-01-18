package team.sipe.office.modules.recruit.infrastructure.persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Table(name = "recruit_requirements")
@Entity
public class RecruitRequirementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Comment("기수")
    @Column(name = "term", nullable = false)
    private long term;

    @Comment("지원자격")
    @Column(name = "requirement", nullable = false)
    private String requirement;

    @Comment("상세내용")
    @Column(name = "descriptions", nullable = false)
    private String descriptions;

    public RecruitRequirementEntity() {
    }

    public RecruitRequirementEntity(final Long seq, final long term, final String requirement, final String descriptions) {
        this.seq = seq;
        this.term = term;
        this.requirement = requirement;
        this.descriptions = descriptions;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(final Long seq) {
        this.seq = seq;
    }

    public long getTerm() {
        return term;
    }

    public void setTerm(final long term) {
        this.term = term;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(final String requirement) {
        this.requirement = requirement;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(final String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RecruitRequirementEntity that = (RecruitRequirementEntity) o;
        return Objects.equals(getSeq(), that.getSeq());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSeq());
    }
}
