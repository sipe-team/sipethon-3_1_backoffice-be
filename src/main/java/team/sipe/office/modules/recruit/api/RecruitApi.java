package team.sipe.office.modules.recruit.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.sipe.office.modules.recruit.api.dto.RecruitActivityRequest;
import team.sipe.office.modules.recruit.api.dto.RecruitRequirementRequest;
import team.sipe.office.modules.recruit.api.dto.RecruitScheduleRequest;
import team.sipe.office.modules.recruit.application.RecruitService;

@RestController("/api/recruit")
public class AdminAuthApi {

    private final RecruitService recruitService;

    @PostMapping("/requirement")
    public ResponseEntity<Void> createRequirement(
            @RequestBody final RecruitRequirementsRequest request
    ) {
        RecruitService.createRequirement(request.command());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/requirement/{term}")
    public ResponseEntity<Void> getRequirement(
            @PathVariable("term") int term
            @RequestBody final RecruitRequirementsRequest request
    ) {
        RecruitService.getRequirement(request.command());
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/requirement/{seq}")
    public ResponseEntity<Void> updateRequirement(
            @PathVariable("seq") int seq
            @RequestBody final RecruitRequirementsRequest request
    ) {
        RecruitService.requirement(seq,request.command());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/requirement/{seq}")
    public ResponseEntity<Void> deleteRequirement(
        @PathVariable("seq") int seq
    ) {
        RecruitService.deleteRequirement(seq);                                                                                      
        return ResponseEntity.ok().build();
    }





    @PostMapping("/recruitSchedule")
    public ResponseEntity<Void> recruitSchedule(
            @RequestBody final RecruitRequirementsRequest request
    ) {
        RecruitService.recruitSchedule(request.command());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/activity")
    public ResponseEntity<Void> activity(
            @RequestBody final RecruitActivityRequest request
    ) {
        RecruitService.activity(request.command());
        return ResponseEntity.ok().build();
    }
}
