package team.sipe.office.modules.faq.appplication.command;

import java.util.List;

public record FaqsRegisterCommand(
        List<FaqRegisterCommand> faqCommands
) {
}


