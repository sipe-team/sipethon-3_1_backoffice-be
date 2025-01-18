package team.sipe.office.modules.recruit.api.dto.requirements;

import java.util.List;

public record RecruitRequirementsFindAllResponse(
        List<RecruitRequirementsFindResponse> requirements
) {
}

