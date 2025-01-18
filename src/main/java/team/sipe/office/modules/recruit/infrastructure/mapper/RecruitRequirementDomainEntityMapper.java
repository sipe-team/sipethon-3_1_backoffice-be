package team.sipe.office.modules.recruit.infrastructure.mapper;

import org.springframework.stereotype.Component;
import team.sipe.office.global.mapper.DomainEntityMapper;
import team.sipe.office.modules.recruit.domain.RecruitRequirement;
import team.sipe.office.modules.recruit.infrastructure.persistence.RecruitRequirementEntity;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class RecruitRequirementDomainEntityMapper implements DomainEntityMapper<RecruitRequirement, RecruitRequirementEntity> {

    @Override
    public RecruitRequirement toDomain(final RecruitRequirementEntity recruitRequirementEntity) {
        return new RecruitRequirement(
                recruitRequirementEntity.getSeq(),
                recruitRequirementEntity.getTerm(),
                recruitRequirementEntity.getRequirement(),
                Arrays.stream(recruitRequirementEntity.getDescriptions().split("|")).toList()
        );
    }

    @Override
    public RecruitRequirementEntity toEntity(final RecruitRequirement recruitRequirement) {
        return new RecruitRequirementEntity(
                recruitRequirement.getSeq(),
                recruitRequirement.getTerm(),
                recruitRequirement.getRequirement(),
                String.join("|", recruitRequirement.getDescriptions())
        );
    }
}
