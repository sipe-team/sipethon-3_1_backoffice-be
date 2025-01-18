package team.sipe.office.modules.recruit.infrastructure.mapper;

import org.springframework.jdbc.core.RowMapper;
import team.sipe.office.modules.recruit.infrastructure.dto.RecruitRequirementInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RecruitRequirementsMapper implements RowMapper<RecruitRequirementInfo> {
    @Override
    public RecruitRequirementInfo mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new RecruitRequirementInfo(
                rs.getLong("seq"),
                rs.getLong("term"),
                rs.getString("requirement"),
                List.of(rs.getString("descriptions").split("\\|"))
        );
    }
}
