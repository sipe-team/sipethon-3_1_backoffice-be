package team.sipe.office.modules.faq.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqEntityRepository extends JpaRepository<FaqEntity, Long> {
}
