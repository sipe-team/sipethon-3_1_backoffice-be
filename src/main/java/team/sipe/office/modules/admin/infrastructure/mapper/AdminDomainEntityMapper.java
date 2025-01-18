package team.sipe.office.modules.admin.infrastructure.mapper;

import org.springframework.stereotype.Component;
import team.sipe.office.global.mapper.DomainEntityMapper;
import team.sipe.office.modules.admin.domain.Admin;
import team.sipe.office.modules.admin.infrastructure.persistence.AdminEntity;

@Component
public class AdminDomainEntityMapper implements DomainEntityMapper<Admin, AdminEntity> {

    @Override
    public Admin toDomain(final AdminEntity adminEntity) {
        return new Admin(
                adminEntity.getId(),
                adminEntity.getPassword(),
                adminEntity.getCreatedAt(),
                adminEntity.getUpdatedAt()
        );
    }

    /**
     * 아직 사용하지 않는 메서드
     *
     * @param admin
     * @return
     */
    @Override
    public AdminEntity toEntity(final Admin admin) {
        return new AdminEntity(
                admin.getId(),
                admin.getPassword(),
                admin.getCreatedAt(),
                admin.getUpdatedAt()
        );
    }
}
