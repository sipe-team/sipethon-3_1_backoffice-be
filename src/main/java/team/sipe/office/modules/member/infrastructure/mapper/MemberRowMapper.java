package team.sipe.office.modules.member.infrastructure.mapper;

import org.springframework.jdbc.core.RowMapper;
import team.sipe.office.modules.member.api.dto.view.MemberView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<MemberView> {

    @Override
    public MemberView mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new MemberView(
                Long.parseLong(rs.getString("id")),
                rs.getString("name"),
                rs.getString("field"),
                rs.getString("reason"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("birth"),
                Boolean.parseBoolean(rs.getString("isStaff")),
                Boolean.parseBoolean(rs.getString("isDropped"))
        );
    }
}
