package team.sipe.office.modules.member.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.sipe.office.modules.member.api.dto.request.CreateMemberRequest;
import team.sipe.office.modules.member.api.dto.request.DeleteMemberRequest;
import team.sipe.office.modules.member.api.dto.request.UpdateMemberRequest;
import team.sipe.office.modules.member.api.dto.view.MemberDetailView;
import team.sipe.office.modules.member.api.dto.view.MemberView;
import team.sipe.office.modules.member.application.MemberService;
import team.sipe.office.modules.member.domain.Member;
import team.sipe.office.modules.member.infrastructure.MemberDao;

import java.util.List;

@Tag(name = "회원")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberApi {
    private final MemberService memberService;
    private final MemberDao memberDao;

    @PostMapping("/members")
    public ResponseEntity<Void> createMember(@RequestBody CreateMemberRequest request) {
        memberService.createMember(request);
        return ResponseEntity.ok()
                .build();
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberView>> getMemberList(@RequestParam(value = "term", required = true) Long term,
                                                          @RequestParam(value = "name", required = false) String name) {
        List<MemberView> memberList = memberDao.getMemberList(term, name);
        return ResponseEntity.ok(memberList);
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberDetailView> getMember(@PathVariable("memberId") Long memberId) {
        Member member = memberService.getMember(memberId);
        return ResponseEntity.ok(new MemberDetailView(member));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<Void> updateMember(@PathVariable("memberId") Long memberId,
                                             @RequestBody UpdateMemberRequest request) {
        memberService.updateMember(memberId, request);
        return ResponseEntity.ok()
                .build();
    }

    @DeleteMapping("/members/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable("memberId") Long memberId,
                                             @RequestBody DeleteMemberRequest request) {
        memberService.deleteMember(memberId, request);
        return ResponseEntity.ok()
                .build();
    }
}
