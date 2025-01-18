package team.sipe.office.modules.faq.infrastructure.mapper;

import org.springframework.jdbc.core.RowMapper;
import team.sipe.office.modules.faq.infrastructure.dto.FaqsInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FaqsInfosMapper implements RowMapper<FaqsInfo> {

    @Override
    public FaqsInfo mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return new FaqsInfo(
                rs.getLong("seq"),
                rs.getString("question"),
                rs.getString("answer")
        );
    }
}

