package team.sipe.office.modules.recruit.api.dto.requirements;

import team.sipe.office.modules.recruit.application.command.RecruitRequirementsRegisterCommand;

import java.util.List;

public record RecruitRequirementsRegisterRequest(
        long term,
        String requirement,
        List<String> descriptions
) {
    public RecruitRequirementsRegisterCommand toCommand() {
        return new RecruitRequirementsRegisterCommand(term, requirement, descriptions);
    }
}

