package team.sipe.office.modules.recruit.infrastructure.dto;

import java.util.List;

public record RecruitRequirementInfo(
        Long seq,
        long term,
        String requirement,
        List<String> descriptions
) {
}
