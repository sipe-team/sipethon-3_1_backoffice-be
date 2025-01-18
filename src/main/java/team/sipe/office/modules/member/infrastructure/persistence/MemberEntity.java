package team.sipe.office.modules.member.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import team.sipe.office.global.jpa.BaseTimeEntity;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Table(name = "member")
@Entity
@NoArgsConstructor
public class MemberEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "field", nullable = false)
    private String field;


    @Column(name = "region", nullable = false)
    private String region;


    @Column(name = "birth", nullable = false)
    private String birth;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "phone", nullable = false)
    private String phone;


    @Column(name = "drop_reason", nullable = true)
    private String dropReason;

    @OneToMany(mappedBy = "member", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<TermEntity> terms;

    public MemberEntity(final Long id, final String name, final String field, final String region, final String birth, final String email, final String phone, final String dropReason, final List<TermEntity> terms, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.field = field;
        this.region = region;
        this.birth = birth;
        this.email = email;
        this.phone = phone;
        this.dropReason = dropReason;
        this.terms = terms;
        terms.forEach(term -> term.setMember(this));
    }
}
