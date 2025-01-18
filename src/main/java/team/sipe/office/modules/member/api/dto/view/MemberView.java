package team.sipe.office.modules.member.api.dto.view;

public record MemberView(
        Long id,
        String name,
        String field,
        String region,
        String email,
        String phone,
        String birth,
        boolean isStaff,
        boolean isDropped
) {
}
