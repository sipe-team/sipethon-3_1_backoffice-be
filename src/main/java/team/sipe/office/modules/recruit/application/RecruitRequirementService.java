package team.sipe.office.modules.recruit.application;

import org.springframework.stereotype.Service;
import team.sipe.office.modules.recruit.application.command.RecruitRequirementsRegisterCommand;
import team.sipe.office.modules.recruit.application.command.RecruitRequirementsUpdateCommand;
import team.sipe.office.modules.recruit.domain.RecruitRequirement;
import team.sipe.office.modules.recruit.domain.RecruitRequirementRepository;

@Service
public class RecruitRequirementService {

    private final RecruitRequirementRepository recruitRequirementRepository;

    public RecruitRequirementService(final RecruitRequirementRepository recruitRequirementRepository) {
        this.recruitRequirementRepository = recruitRequirementRepository;
    }

    public RecruitRequirement register(final RecruitRequirementsRegisterCommand command) {
        final RecruitRequirement requirement = RecruitRequirement.init(command.term(), command.requirement(), command.descriptions());
        return recruitRequirementRepository.save(requirement);
    }

    public RecruitRequirement update(final RecruitRequirementsUpdateCommand command) {
        final RecruitRequirement requirement = recruitRequirementRepository.findBySeq(command.seq());
        return recruitRequirementRepository.save(requirement.update(command.term(), command.requirement(), command.descriptions()));
    }

    public void delete(final Long seq) {
        recruitRequirementRepository.delete(seq);
    }
}
