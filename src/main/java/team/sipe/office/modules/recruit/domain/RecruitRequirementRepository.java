package team.sipe.office.modules.recruit.domain;

public interface RecruitRequirementRepository {
    RecruitRequirement save(RecruitRequirement requirement);
    RecruitRequirement findBySeq(Long seq);
    void delete(Long seq);
}
