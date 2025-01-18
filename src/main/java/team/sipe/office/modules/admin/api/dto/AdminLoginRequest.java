package team.sipe.office.modules.admin.api.dto;

import team.sipe.office.modules.admin.application.command.AdminLoginCommand;

public record AdminLoginRequest(
        String id,
        String password
) {

    public AdminLoginCommand command() {
        return new AdminLoginCommand(id, password);
    }
}
