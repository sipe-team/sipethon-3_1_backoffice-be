package team.sipe.office.modules.admin.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Comment;
import team.sipe.office.global.jpa.BaseTimeEntity;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "admin")
@Entity
public class AdminEntity extends BaseTimeEntity {

    @Comment("관리자 아이디")
    @Id
    private String id;

    @Comment("관리자 비밀번호")
    @Column(name = "password", nullable = false)
    private String password;

    public AdminEntity() {
    }

    public AdminEntity(final String id, final String password, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AdminEntity that = (AdminEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
