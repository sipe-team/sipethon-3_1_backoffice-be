package team.sipe.office.modules.member.domain;

import java.util.Optional;

public interface MemberRepository {
    Member findById(Long id);

    void save(Member member);

    Optional<Member> findByNameAndPhone(String name, String phoneNumber);
}
