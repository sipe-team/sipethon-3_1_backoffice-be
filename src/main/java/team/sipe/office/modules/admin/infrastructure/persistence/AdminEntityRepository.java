package team.sipe.office.modules.admin.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminEntityRepository extends JpaRepository<AdminEntity, String> {
}
