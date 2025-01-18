package team.sipe.office.modules.member.domain;

public interface MemberRepository {
    Member findById(Long id);

    void save(Member member);
}
