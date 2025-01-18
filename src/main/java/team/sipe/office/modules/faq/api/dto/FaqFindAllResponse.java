package team.sipe.office.modules.faq.api.dto;

public record FaqFindAllResponse(
        Long seq,
        String question,
        String answer
) {
}
