package team.sipe.office.modules.faq.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import team.sipe.office.modules.faq.domain.Faq;
import team.sipe.office.modules.faq.domain.FaqRepository;
import team.sipe.office.modules.faq.infrastructure.mapper.FaqDomainEntityMapper;
import team.sipe.office.modules.faq.infrastructure.persistence.FaqEntityRepository;

import java.util.List;

@Component
public class FaqRepositoryAdapter implements FaqRepository {

    private final FaqDomainEntityMapper faqDomainEntityMapper;
    private final FaqEntityRepository faqEntityRepository;

    public FaqRepositoryAdapter(final FaqDomainEntityMapper faqDomainEntityMapper,
                                final FaqEntityRepository faqEntityRepository) {
        this.faqDomainEntityMapper = faqDomainEntityMapper;
        this.faqEntityRepository = faqEntityRepository;
    }

    @Transactional
    @Override
    public List<Faq> saveAll(final List<Faq> faqs) {
        return faqEntityRepository.saveAll(faqs.stream()
                        .map(faqDomainEntityMapper::toEntity)
                        .toList())
                .stream()
                .map(faqDomainEntityMapper::toDomain)
                .toList();
    }
}
