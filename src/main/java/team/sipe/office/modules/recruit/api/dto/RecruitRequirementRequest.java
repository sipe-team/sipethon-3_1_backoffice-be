package team.sipe.office.modules.recruit.api.dto;

import team.sipe.office.modules.recruit.application.command.RecruitRequirementCommand;

public record RecruitRequirementRequest(
        int term,
        String content,
        boolean isRequirement 
) {
    public RecruitRequirementCommand command() {
        return new RecruitRequirementCommand(term, content, isRequirement);
    }
}
