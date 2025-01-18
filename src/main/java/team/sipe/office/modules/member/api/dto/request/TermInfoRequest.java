package team.sipe.office.modules.member.api.dto.request;

public record TermInfoRequest(
        int term,
        boolean isStaff
) {
}
