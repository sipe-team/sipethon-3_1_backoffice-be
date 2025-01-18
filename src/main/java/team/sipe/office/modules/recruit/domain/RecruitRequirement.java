package team.sipe.office.modules.recruit.domain;

import java.util.List;
import java.util.Objects;

public class RecruitRequirement {

    private final Long seq;
    private final long term;
    private final String requirement;
    private final List<String> descriptions;

    public static RecruitRequirement init(final long term, final String requirement, final List<String> descriptions) {
        return new RecruitRequirement(null, term, requirement, descriptions);
    }

    public RecruitRequirement(final Long seq, final long term, final String requirement, final List<String> descriptions) {
        this.seq = seq;
        this.term = term;
        this.requirement = requirement;
        this.descriptions = descriptions;
    }

    public RecruitRequirement update(final Long term,
                                     final String requirement,
                                     final List<String> descriptions
    ) {
        return new RecruitRequirement(this.seq, term, requirement, descriptions);
    }

    public Long getSeq() {
        return seq;
    }

    public long getTerm() {
        return term;
    }

    public String getRequirement() {
        return requirement;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RecruitRequirement that = (RecruitRequirement) o;
        return Objects.equals(getSeq(), that.getSeq());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSeq());
    }
}
