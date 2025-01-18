package team.sipe.office.modules.recruit.api.dto.requirements;

import java.util.List;

public record RecruitRequirementsFindResponse(
        Long seq,
        long term,
        String requirement,
        List<String> descriptions
) {
}