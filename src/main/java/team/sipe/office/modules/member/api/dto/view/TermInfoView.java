package team.sipe.office.modules.member.api.dto.view;

import team.sipe.office.modules.member.domain.Term;

public record TermInfoView(
        int term,
        boolean isStaff
) {
    public TermInfoView(Term term) {
        this(term.getTerm(), term.isStaff());
    }
}
