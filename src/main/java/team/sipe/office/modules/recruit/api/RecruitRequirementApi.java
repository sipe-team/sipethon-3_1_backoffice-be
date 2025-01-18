package team.sipe.office.modules.recruit.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.sipe.office.modules.recruit.api.dto.requirements.*;
import team.sipe.office.modules.recruit.application.RecruitRequirementService;
import team.sipe.office.modules.recruit.domain.RecruitRequirement;
import team.sipe.office.modules.recruit.infrastructure.RecruitRequirementDao;

import java.net.URI;
import java.util.List;

@Tag(name = "지원")
@RequestMapping("/api/recruit/requirement")
@RestController
public class RecruitRequirementApi {

    private final RecruitRequirementService recruitRequirementService;
    private final RecruitRequirementDao recruitRequirementDao;

    public RecruitRequirementApi(final RecruitRequirementService recruitRequirementService,
                                 final RecruitRequirementDao recruitRequirementDao) {
        this.recruitRequirementService = recruitRequirementService;
        this.recruitRequirementDao = recruitRequirementDao;
    }

    @PostMapping()
    public ResponseEntity<RecruitRequirementsRegisterResponse> register(
            @RequestBody final RecruitRequirementsRegisterRequest request
    ) {
        final RecruitRequirement recruitRequirement = recruitRequirementService.register(request.toCommand());
        final Long seq = recruitRequirement.getSeq();
        final URI uri = URI.create("/api/recruit/requirement/" + seq);
        final RecruitRequirementsRegisterResponse response = new RecruitRequirementsRegisterResponse(seq);
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{term}")
    public ResponseEntity<RecruitRequirementsFindAllResponse> findAll(
            @PathVariable("term") final long term
    ) {
        final List<RecruitRequirementsFindResponse> recruitRequirements = recruitRequirementDao.findAll(term).stream()
                .map(recruitRequirementInfo -> new RecruitRequirementsFindResponse(
                        recruitRequirementInfo.seq(),
                        recruitRequirementInfo.term(),
                        recruitRequirementInfo.requirement(),
                        recruitRequirementInfo.descriptions()
                )).toList();
        return ResponseEntity.ok().body(new RecruitRequirementsFindAllResponse(recruitRequirements));
    }

    @PutMapping("/{seq}")
    public ResponseEntity<Void> updateRequirement(
            @PathVariable("seq") final Long seq,
            @RequestBody final RecruitRequirementsUpdateRequest request
    ) {
        recruitRequirementService.update(request.toCommand(seq));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> delete(
            @PathVariable("seq") final Long seq
    ) {
        recruitRequirementService.delete(seq);
        return ResponseEntity.ok().build();
    }
}
