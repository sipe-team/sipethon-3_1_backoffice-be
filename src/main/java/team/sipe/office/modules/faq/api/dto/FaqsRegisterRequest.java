package team.sipe.office.modules.faq.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import team.sipe.office.modules.faq.appplication.command.FaqRegisterCommand;
import team.sipe.office.modules.faq.appplication.command.FaqsRegisterCommand;

import java.util.List;

public record FaqsRegisterRequest(
        List<FaqRegisterRequest> faqs
) {
    public FaqsRegisterCommand toCommand() {
        return new FaqsRegisterCommand(faqs.stream()
                .map(FaqRegisterRequest::toCommand)
                .toList());
    }
}

record FaqRegisterRequest(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Long seq,
        String question,
        String answer
) {

    public FaqRegisterCommand toCommand() {
        return new FaqRegisterCommand(seq, question, answer);
    }
}