package team.sipe.office.modules.recruit.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import team.sipe.office.modules.recruit.domain.Requirement;
import team.sipe.office.modules.recruit.domain.RequirementRepository;
import team.sipe.office.modules.recruit.infrastructure.mapper.RequirementEntityMapper;
import team.sipe.office.modules.recruit.infrastructure.persistence.RequirementEntityRepository;

@Component
public class RecruitRepositoryAdapter implements AdminRepository {

    private final RequirementEntityMapper requirementEntityMapper;
    private final RequirementEntityRepository requirementEntityRepository;

    public RecruitRepositoryAdapter(
        final AdminDomainEntityMapper adminDomainEntityMapper, 
        final AdminEntityRepository adminEntityRepository) {
        this.adminDomainEntityMapper = adminDomainEntityMapper;
        this.adminEntityRepository = adminEntityRepository;
    }

    @Transactional(readOnly = true)
    public Admin findById(final int Term) {
        return adminEntityRepository.findByTerm(term)
                .map(RequirementEntityMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("정보를 찾을 수 없습니다."));
    }
}
