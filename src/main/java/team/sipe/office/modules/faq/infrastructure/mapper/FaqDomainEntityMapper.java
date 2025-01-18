package team.sipe.office.modules.faq.infrastructure.mapper;

import org.springframework.stereotype.Component;
import team.sipe.office.global.mapper.DomainEntityMapper;
import team.sipe.office.modules.faq.domain.Faq;
import team.sipe.office.modules.faq.infrastructure.persistence.FaqEntity;

@Component
public class FaqDomainEntityMapper implements DomainEntityMapper<Faq, FaqEntity> {
    @Override
    public Faq toDomain(final FaqEntity faqEntity) {
        return new Faq(faqEntity.getSeq(), faqEntity.getQuestion(), faqEntity.getAnswer());
    }

    @Override
    public FaqEntity toEntity(final Faq faq) {
        return new FaqEntity(faq.getSeq(), faq.getQuestion(), faq.getAnswer());
    }
}
