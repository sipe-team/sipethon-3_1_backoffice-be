package team.sipe.office.modules.recruit.infrastructure;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import team.sipe.office.modules.recruit.infrastructure.dto.RecruitRequirementInfo;
import team.sipe.office.modules.recruit.infrastructure.mapper.RecruitRequirementsMapper;

import javax.sql.DataSource;
import java.util.List;

@Component
public class RecruitRequirementDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public RecruitRequirementDao(final DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Transactional(transactionManager = "transactionManager", readOnly = true)
    public List<RecruitRequirementInfo> findAll(final long term) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("term", term);
        final String query = "SELECT * FROM recruit_requirements WHERE term = :term";
        return namedParameterJdbcTemplate.query(query, namedParameters, new RecruitRequirementsMapper());
    }
}
