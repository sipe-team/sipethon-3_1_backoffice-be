package team.sipe.office.modules.member.api.dto.request;

import java.util.List;


public record UpdateMemberRequest(
        String name,
        List<TermInfoRequest> term,
        String field,
        String region,
        String email,
        String phone,
        String birth
) {
}
