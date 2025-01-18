package team.sipe.office.modules.member.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long> {
}
