package com.baont8.toolgenerate.mapper.projectCustomer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.baont8.toolgenerate.service.dtoResponse.cmMessage.GetCmMessageDetailResponseDto;

public class CmMessageRowMapper implements RowMapper<GetCmMessageDetailResponseDto>{

	@Override
	public GetCmMessageDetailResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		GetCmMessageDetailResponseDto cmMessageDto = new GetCmMessageDetailResponseDto();
		cmMessageDto.setMsgGrp(rs.getString("MSG_GRP"));
		cmMessageDto.setMsgCd(rs.getString("MSG_CD"));
		cmMessageDto.setLangCd(rs.getString("LANG_CD"));
		cmMessageDto.setMsgType(rs.getString("MSG_TYPE"));
		cmMessageDto.setSysCd(rs.getString("SYS_CD"));
		cmMessageDto.setCompCd(rs.getString("COMP_CD"));
		cmMessageDto.setMsg(rs.getString("MSG"));

		return cmMessageDto;
	}

}
