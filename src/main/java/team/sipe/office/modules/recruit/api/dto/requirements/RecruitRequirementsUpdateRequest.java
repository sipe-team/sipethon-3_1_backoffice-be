package team.sipe.office.modules.recruit.api.dto.requirements;

import team.sipe.office.modules.recruit.application.command.RecruitRequirementsUpdateCommand;

import java.util.List;

public record RecruitRequirementsUpdateRequest(
        long term,
        String requirement,
        List<String> descriptions
) {

    public RecruitRequirementsUpdateCommand toCommand(Long seq) {
        return new RecruitRequirementsUpdateCommand(seq, term, requirement, descriptions);
    }
}
