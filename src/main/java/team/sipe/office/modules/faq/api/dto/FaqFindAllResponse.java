package team.sipe.office.modules.faq.api.dto;

public record FaqFindAllResponse(
        Long seq,
        long term,
        String question,
        String answer
) {
}
