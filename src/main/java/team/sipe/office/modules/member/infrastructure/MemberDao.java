package team.sipe.office.modules.member.infrastructure;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import team.sipe.office.modules.member.api.dto.view.MemberView;
import team.sipe.office.modules.member.infrastructure.mapper.MemberRowMapper;

import javax.sql.DataSource;
import java.util.List;

@Component
public class MemberDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MemberDao(final DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<MemberView> getMemberList(Long term, String name) {
        SqlParameterSource params = new MapSqlParameterSource().addValue("term", term)
                .addValue("name", "%" + StringUtils.defaultString(name) + "%");

        String query = """
                SELECT m.id AS id,
                m.name AS name,
                m.field AS field,
                m.drop_reason AS reason,
                m.email AS email,
                m.phone AS phone,
                m.birth AS birth,
                t.is_staff AS isStaff,
                (m.drop_reason IS NULL) AS isDropped 
                FROM member AS m 
                INNER JOIN term AS t 
                ON m.id = t.member_id
                WHERE t.term = :term
                AND m.name LIKE :name
                """;

        return jdbcTemplate.query(query, params, new MemberRowMapper());
    }
}
