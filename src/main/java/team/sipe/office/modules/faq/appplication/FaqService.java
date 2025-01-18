package team.sipe.office.modules.faq.appplication;

import org.springframework.stereotype.Service;
import team.sipe.office.modules.faq.appplication.command.FaqsRegisterCommand;
import team.sipe.office.modules.faq.domain.Faq;
import team.sipe.office.modules.faq.domain.FaqRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FaqService {

    private final FaqRepository faqRepository;

    public FaqService(final FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public List<Faq> register(final FaqsRegisterCommand command) {
        final List<Faq> faqs = updateFaqs(command);
        faqs.addAll(newFaqs(command));
        return faqRepository.saveAll(faqs);
    }

    private List<Faq> newFaqs(final FaqsRegisterCommand command) {
        return command.faqCommands()
                .stream()
                .filter(it -> Objects.isNull(it.seq()))
                .map(it -> Faq.init(it.question(), it.answer()))
                .collect(Collectors.toList());
    }

    private List<Faq> updateFaqs(final FaqsRegisterCommand command) {
        return command.faqCommands()
                .stream()
                .filter(it -> Objects.nonNull(it.seq()))
                .map(it -> new Faq(it.seq(), it.question(), it.answer()))
                .collect(Collectors.toList());
    }
}
