package team.sipe.office.modules.faq.domain;

import java.util.List;

public interface FaqRepository {
    List<Faq> saveAll(List<Faq> newFaqs);
}
