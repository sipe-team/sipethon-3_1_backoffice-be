package team.sipe.office.modules.member.infrastructure.mapper;

import org.springframework.stereotype.Component;
import team.sipe.office.global.mapper.DomainEntityMapper;
import team.sipe.office.modules.member.domain.Member;
import team.sipe.office.modules.member.domain.Term;
import team.sipe.office.modules.member.infrastructure.persistence.MemberEntity;
import team.sipe.office.modules.member.infrastructure.persistence.TermEntity;

@Component
public class MemberDomainEntityMapper implements DomainEntityMapper<Member, MemberEntity> {
    @Override
    public Member toDomain(MemberEntity memberEntity) {
        return new Member(
                memberEntity.getId(),
                memberEntity.getName(),
                memberEntity.getField(),
                memberEntity.getRegion(),
                memberEntity.getBirth(),
                memberEntity.getEmail(),
                memberEntity.getPhone(),
                memberEntity.getDropReason(),
                memberEntity.getTerms()
                            .stream()
                            .map(termEntity -> new Term(termEntity.getSeq(), termEntity.getTerm(), termEntity.isStaff()))
                            .toList(),
                memberEntity.getCreatedAt(),
                memberEntity.getUpdatedAt()
        );
    }

    @Override
    public MemberEntity toEntity(Member member) {
        return new MemberEntity(
                member.getId(),
                member.getName(),
                member.getField(),
                member.getRegion(),
                member.getBirth(),
                member.getEmail(),
                member.getPhone(),
                member.getDropReason(),
                member.getTerms()
                        .stream()
                        .map(term -> new TermEntity(term.getSeq(), term.getTerm(), term.isStaff()))
                        .toList(),
                member.getCreatedAt(),
                member.getUpdatedAt()
        );
    }
}
