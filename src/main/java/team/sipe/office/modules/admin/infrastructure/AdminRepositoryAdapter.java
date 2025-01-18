package team.sipe.office.modules.admin.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import team.sipe.office.modules.admin.domain.Admin;
import team.sipe.office.modules.admin.domain.AdminRepository;
import team.sipe.office.modules.admin.infrastructure.mapper.AdminDomainEntityMapper;
import team.sipe.office.modules.admin.infrastructure.persistence.AdminEntityRepository;

@Component
public class AdminRepositoryAdapter implements AdminRepository {

    private final AdminDomainEntityMapper adminDomainEntityMapper;
    private final AdminEntityRepository adminEntityRepository;

    public AdminRepositoryAdapter(final AdminDomainEntityMapper adminDomainEntityMapper, final AdminEntityRepository adminEntityRepository) {
        this.adminDomainEntityMapper = adminDomainEntityMapper;
        this.adminEntityRepository = adminEntityRepository;
    }

    @Transactional(readOnly = true)
    public Admin findById(final String id) {
        return adminEntityRepository.findById(id)
                .map(adminDomainEntityMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("관리자 정보를 찾을 수 없습니다."));
    }
}
