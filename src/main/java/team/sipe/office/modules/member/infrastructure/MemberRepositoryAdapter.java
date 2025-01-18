package team.sipe.office.modules.member.infrastructure;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.sipe.office.modules.member.domain.Member;
import team.sipe.office.modules.member.domain.MemberRepository;
import team.sipe.office.modules.member.infrastructure.mapper.MemberDomainEntityMapper;
import team.sipe.office.modules.member.infrastructure.persistence.MemberEntityRepository;

@Component
@RequiredArgsConstructor
public class MemberRepositoryAdapter implements MemberRepository {
    private final MemberDomainEntityMapper memberDomainEntityMapper;
    private final MemberEntityRepository memberEntityRepository;

    @Transactional
    public Member findById(Long id) {
        return memberEntityRepository.findById(id)
                .map(memberDomainEntityMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Transactional
    public void save(Member member) {
        memberEntityRepository.save(memberDomainEntityMapper.toEntity(member));
    }
}
