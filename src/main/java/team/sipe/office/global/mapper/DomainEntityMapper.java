package team.sipe.office.global.mapper;

public interface DomainEntityMapper<DOMAIN, ENTITY> {
    DOMAIN toDomain(ENTITY entity);

    ENTITY toEntity(DOMAIN domain);
}