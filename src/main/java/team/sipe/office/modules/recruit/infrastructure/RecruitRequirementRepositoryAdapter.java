package team.sipe.office.modules.recruit.infrastructure;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import team.sipe.office.modules.recruit.domain.RecruitRequirement;
import team.sipe.office.modules.recruit.domain.RecruitRequirementRepository;
import team.sipe.office.modules.recruit.infrastructure.mapper.RecruitRequirementDomainEntityMapper;
import team.sipe.office.modules.recruit.infrastructure.persistence.RecruitRequirementEntityRepository;

import java.util.Optional;

@Component
public class RecruitRequirementRepositoryAdapter implements RecruitRequirementRepository {

    private final RecruitRequirementDomainEntityMapper recruitRequirementDomainEntityMapper;
    private final RecruitRequirementEntityRepository requirementEntityRepository;

    public RecruitRequirementRepositoryAdapter(final RecruitRequirementDomainEntityMapper recruitRequirementDomainEntityMapper,
                                               final RecruitRequirementEntityRepository requirementEntityRepository) {
        this.recruitRequirementDomainEntityMapper = recruitRequirementDomainEntityMapper;
        this.requirementEntityRepository = requirementEntityRepository;
    }

    @Transactional
    @Override
    public RecruitRequirement save(final RecruitRequirement requirement) {
        return Optional.ofNullable(recruitRequirementDomainEntityMapper.toEntity(requirement))
                .map(requirementEntityRepository::save)
                .map(recruitRequirementDomainEntityMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Failed to save recruit requirement"));
    }

    @Override
    public RecruitRequirement findBySeq(final Long seq) {
        return Optional.ofNullable(requirementEntityRepository.findBySeq(seq))
                .map(recruitRequirementDomainEntityMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Recruit requirement not found"));
    }

    @Transactional
    @Override
    public void delete(final Long seq) {
        requirementEntityRepository.deleteBySeq(seq);
    }
}

