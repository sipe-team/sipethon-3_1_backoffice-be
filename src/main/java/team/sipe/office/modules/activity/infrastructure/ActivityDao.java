package team.sipe.office.modules.activity.infrastructure;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import team.sipe.office.modules.activity.api.dto.view.ActivityView;
import team.sipe.office.modules.activity.infrastructure.mapper.ActivityRowMapper;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ActivityDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ActivityDao(final DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<ActivityView> getActivityList(Integer term) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("term", term);

        String query = """
                SELECT *
                FROM activity
                WHERE term = :term
                """;

        return jdbcTemplate.query(query, params, new ActivityRowMapper());
    }
}
