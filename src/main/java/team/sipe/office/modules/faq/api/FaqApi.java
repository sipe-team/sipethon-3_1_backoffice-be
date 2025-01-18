package team.sipe.office.modules.faq.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.sipe.office.modules.faq.api.dto.FaqFindAllResponse;
import team.sipe.office.modules.faq.api.dto.FaqsFindAllResponse;
import team.sipe.office.modules.faq.api.dto.FaqsRegisterRequest;
import team.sipe.office.modules.faq.appplication.FaqService;
import team.sipe.office.modules.faq.infrastructure.persistence.FaqDao;

@RequestMapping("/api/faqs")
@RestController
public class FaqApi {

    private final FaqDao faqDao;
    private final FaqService faqService;

    public FaqApi(final FaqDao faqDao, final FaqService faqService) {
        this.faqDao = faqDao;
        this.faqService = faqService;
    }

    @PostMapping
    public ResponseEntity<Void> register(
            @RequestBody final FaqsRegisterRequest request
    ) {
        faqService.register(request.toCommand());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{{term}}")
    public ResponseEntity<FaqsFindAllResponse> list(
            @PathVariable("term") final long term
    ) {
        final FaqsFindAllResponse faqsFindAllResponse = new FaqsFindAllResponse(faqDao.findAll(term).stream()
                .map(it -> new FaqFindAllResponse(it.seq(), it.term(), it.question(), it.answer()))
                .toList());
        return ResponseEntity.ok().body(faqsFindAllResponse);
    }
}
