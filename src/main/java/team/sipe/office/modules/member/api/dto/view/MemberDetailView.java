package team.sipe.office.modules.member.api.dto.view;

import team.sipe.office.modules.member.domain.Member;

import java.util.List;
import java.util.Objects;

public record MemberDetailView(
        Long id,
        String name,
        List<TermInfoView> termInfo,
        String field,
        String region,
        String email,
        String phone,
        String birth,
        boolean isDropped,
        String reason
) {
    public MemberDetailView(Member member) {
        this(member.getId(),
                member.getName(),
                member.getTerms()
                        .stream()
                        .map(TermInfoView::new)
                        .toList(),
                member.getField(),
                member.getRegion(),
                member.getEmail(),
                member.getPhone(),
                member.getBirth(),
                Objects.nonNull(member.getDropReason()),
                member.getDropReason()
        );
    }
}
