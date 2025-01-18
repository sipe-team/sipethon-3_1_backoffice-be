package team.sipe.office.modules.recruit.api.dto;

import team.sipe.office.modules.recruit.application.command.AdminLoginCommand;

public record AdminLoginRequest(
        String id,
        String password
) {
    public AdminLoginCommand command() {
        return new AdminLoginCommand(id, password);
    }
}
