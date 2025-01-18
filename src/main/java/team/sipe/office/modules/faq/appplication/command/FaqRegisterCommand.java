package team.sipe.office.modules.faq.appplication.command;

public record FaqRegisterCommand(
        Long seq,
        long term,
        String question,
        String answer
) {
}
