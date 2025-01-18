package team.sipe.office.modules.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String field;
    private String region;
    private String birth;
    private String email;
    private String phone;
    private String dropReason;
    private List<Term> terms;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void updateMember(String name, String field, String region, String birth, String email, String phone) {
        this.name = name;
        this.field = field;
        this.region = region;
        this.birth = birth;
        this.email = email;
        this.phone = phone;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateTerm(List<Term> updated) {
        this.terms = updated.stream()
                .map(updatedValue -> {
                    for (Term term : terms) {
                        if (term.getTerm() == updatedValue.getTerm()) {
                            term.updateTerm(updatedValue.getTerm(), updatedValue.isStaff());
                            return term;
                        }
                    }
                    return updatedValue;
                })
                .toList();
        updatedAt = LocalDateTime.now();
    }

    public void updateDropReason(String dropReason) {
        this.dropReason = dropReason;
        updatedAt = LocalDateTime.now();
    }
}
