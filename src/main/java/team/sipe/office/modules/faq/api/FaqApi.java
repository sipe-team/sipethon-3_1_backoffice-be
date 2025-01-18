package team.sipe.office.modules.faq.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.sipe.office.modules.faq.api.dto.FaqFindAllResponse;
import team.sipe.office.modules.faq.api.dto.FaqsFindAllResponse;
import team.sipe.office.modules.faq.api.dto.FaqsRegisterRequest;
import team.sipe.office.modules.faq.appplication.FaqService;
import team.sipe.office.modules.faq.infrastructure.persistence.FaqDao;

@Tag(name = "FAQ")
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

    @GetMapping
    public ResponseEntity<FaqsFindAllResponse> list() {
        final FaqsFindAllResponse faqsFindAllResponse = new FaqsFindAllResponse(faqDao.findAll().stream()
                .map(it -> new FaqFindAllResponse(it.seq(), it.question(), it.answer()))
                .toList());
        return ResponseEntity.ok().body(faqsFindAllResponse);
    }
}
