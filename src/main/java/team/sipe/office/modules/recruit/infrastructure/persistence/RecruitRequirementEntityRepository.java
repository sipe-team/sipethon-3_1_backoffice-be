package team.sipe.office.modules.recruit.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitRequirementEntityRepository extends JpaRepository<RecruitRequirementEntity, Long> {
    RecruitRequirementEntity findBySeq(Long seq);

    void deleteBySeq(Long seq);
}