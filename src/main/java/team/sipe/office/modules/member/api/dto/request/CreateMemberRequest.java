package team.sipe.office.modules.member.api.dto.request;

import team.sipe.office.modules.member.domain.Member;
import team.sipe.office.modules.member.domain.Term;

import java.time.LocalDateTime;
import java.util.List;

public record CreateMemberRequest(
        String name,
        int term,
        String field,
        String region,
        String email,
        String phone,
        String birth
) {
    public Member init() {
        return new Member(
                null,
                name,
                field,
                field,
                region,
                email,
                phone,
                birth,
                List.of(new Term(null, term, false)),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

}
