package team.sipe.office.modules.faq.appplication.command;

public record FaqRegisterCommand(
        Long seq,
        String question,
        String answer
) {
}
