package team.sipe.office.modules.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Term {
    private Long seq;
    private int term;
    private boolean isStaff;

    public void updateTerm(int term, boolean isStaff) {
        this.term = term;
        this.isStaff = isStaff;
    }
}
