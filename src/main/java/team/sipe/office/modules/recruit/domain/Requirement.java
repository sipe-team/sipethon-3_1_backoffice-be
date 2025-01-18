package team.sipe.office.modules.recruit.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Requirement {

    private final int seq;
    private final int term;
    private final String content;
    private final boolean isRequirement;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Requirement(final int seq, final int term, 
                       final String content, final boolean isRequirement,
                       final LocalDateTime createdAt, final LocalDateTime updatedAt) {
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
        final Requirement Requirement = (Requirement) o;
        return Objects.equals(getId(), Requirement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
