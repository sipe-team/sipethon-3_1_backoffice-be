package team.sipe.office.modules.activity.infrastructure.mapper;

import org.springframework.jdbc.core.RowMapper;
import team.sipe.office.modules.activity.api.dto.view.ActivityView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityRowMapper implements RowMapper<ActivityView> {

    @Override
    public ActivityView mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ActivityView(
                Integer.parseInt(rs.getString("week")),
                rs.getString("date"),
                rs.getString("description")
        );
    }
}
