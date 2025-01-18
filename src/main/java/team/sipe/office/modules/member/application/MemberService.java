package team.sipe.office.modules.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.sipe.office.modules.member.api.dto.request.CreateMemberRequest;
import team.sipe.office.modules.member.api.dto.request.DeleteMemberRequest;
import team.sipe.office.modules.member.api.dto.request.UpdateMemberRequest;
import team.sipe.office.modules.member.domain.Member;
import team.sipe.office.modules.member.domain.MemberRepository;
import team.sipe.office.modules.member.domain.Term;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void createMember(CreateMemberRequest request) {
        Member member = request.init();
        memberRepository.save(member);
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public void updateMember(Long memberId, UpdateMemberRequest request) {
        Member member = getMember(memberId);
        member.updateMember(request.name(), request.field(), request.region(), request.birth(), request.email(), request.phone());
        member.updateTerm(request.term()
                .stream()
                .map(term -> new Term(null, term.term(), term.isStaff()))
                .toList());
        memberRepository.save(member);
    }

    public void deleteMember(Long memberId, DeleteMemberRequest request) {
        Member member = getMember(memberId);
        member.updateDropReason(request.reason());
        memberRepository.save(member);
    }
}
