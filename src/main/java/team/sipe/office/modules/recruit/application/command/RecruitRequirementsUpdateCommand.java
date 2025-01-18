package team.sipe.office.modules.recruit.application.command;


import java.util.List;

public record RecruitRequirementsUpdateCommand(
        Long seq,
        Long term,
        String requirement,
        List<String> descriptions
) {
}
