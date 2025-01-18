package team.sipe.office.modules.faq.infrastructure.persistence;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import team.sipe.office.modules.faq.infrastructure.dto.FaqsInfo;
import team.sipe.office.modules.faq.infrastructure.mapper.FaqsInfosMapper;

import javax.sql.DataSource;
import java.util.List;

@Component
public class FaqDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FaqDao(final DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Transactional(transactionManager = "transactionManager", readOnly = true)
    public List<FaqsInfo> findAll(final long term) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("term", term);
        final String query = "SELECT * FROM faqs WHERE term = :term";
        return namedParameterJdbcTemplate.query(query, namedParameters, new FaqsInfosMapper());
    }
}


