package team.sipe.office.modules.admin.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Admin {

    private final String id;
    private final String password;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Admin(final String id, final String password, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.id = id;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void login(final String password) {
        if (!this.password.equals(password)) {
            throw new RuntimeException("Invalid password");
        }
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Admin admin = (Admin) o;
        return Objects.equals(getId(), admin.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
