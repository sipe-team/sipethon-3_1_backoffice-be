package team.sipe.office.modules.faq.api.dto;

import java.util.List;

public record FaqsFindAllResponse(
        List<FaqFindAllResponse> faqs
) {
}
