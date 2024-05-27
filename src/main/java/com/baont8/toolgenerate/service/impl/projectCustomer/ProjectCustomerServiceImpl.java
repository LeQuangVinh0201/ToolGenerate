package com.baont8.toolgenerate.service.impl.projectCustomer;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.CollectionUtils;

import com.baont8.toolgenerate.mapper.projectCustomer.CmMessageRowMapper;
import com.baont8.toolgenerate.service.FileTemplateService;
import com.baont8.toolgenerate.service.dtoRequest.fileTemplate.GenerateFileTemplateRequestDto;
import com.baont8.toolgenerate.service.dtoResponse.cmMessage.GetCmMessageDetailResponseDto;
import com.baont8.toolgenerate.service.projectCustomer.ProjectCustomerService;

@Service
public class ProjectCustomerServiceImpl implements ProjectCustomerService {

	@Autowired
	private FileTemplateService fileTemplateService;

	@Autowired
	@Qualifier("namedParameterJdbcTemplateProjectCustomer")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	@Qualifier("jdbcTemplateProjectCustomer")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("transactionManagerProjectCustomer")
    private PlatformTransactionManager transactionManager;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Override
	public List<GetCmMessageDetailResponseDto> getListCmMessage(String msg, Set<String> listLangCd, Set<String> listMsgGrp,
			Set<String> listMsgType, Set<String> listSysCd, Set<String> listCompCd, String msgCd) {
		
		// Initial Namped Parameters JDBC Template

		if (!checkExistsCmMessage(msg, listLangCd, listMsgGrp, listMsgType, listSysCd, listCompCd, msgCd)) {
			return null;
		} else {
			// Sql statement
			String sql = 
							" SELECT DISTINCT CM_MESSAGE_2.* " +
							" FROM CM_MESSAGE " +
							" LEFT JOIN CM_MESSAGE AS CM_MESSAGE_2 " +
							"   ON CM_MESSAGE_2.MSG_GRP = CM_MESSAGE.MSG_GRP " +
							"  AND CM_MESSAGE_2.MSG_CD = CM_MESSAGE.MSG_CD " +
							"  AND CM_MESSAGE_2.COMP_CD = CM_MESSAGE.COMP_CD " +
							" where 1 = 1 " +
							"  and ( " +
							"  	:MSG is NULL " +
							" 	or " +
							"   CM_MESSAGE.MSG = :MSG " +
							"  ) " +
							"  and ( " +
							"  	:CHECK_ARRAY_LANG_CD is NULL " +
							" 	or " +
							"   UPPER(CM_MESSAGE.LANG_CD) in (:ARRAY_LANG_CD) " +
							"  ) " +
							"  and ( " +
							"  	:CHECK_ARRAY_MSG_GRP is NULL " +
							" 	or " +
							"   UPPER(CM_MESSAGE.MSG_GRP) in (:ARRAY_MSG_GRP) " +
							"  ) " +
							"  and ( " +
							"  	:CHECK_ARRAY_MSG_TYPE is NULL " +
							" 	or " +
							"   UPPER(CM_MESSAGE.MSG_TYPE) in (:ARRAY_MSG_TYPE) " +
							"  ) " +
							"  and ( " +
							"  	:CHECK_ARRAY_SYS_CD is NULL " +
							" 	or " +
							"   UPPER(CM_MESSAGE.SYS_CD) in (:ARRAY_SYS_CD) " +
							"  ) " +
							"  and ( " +
							"  	:CHECK_ARRAY_COMP_CD is NULL " +
							" 	or " +
							"   UPPER(CM_MESSAGE.COMP_CD) in (:ARRAY_COMP_CD) " +
							"  ) " +
							"  and ( " +
							"  	:MSG_CD is NULL " +
							" 	or " +
							"   UPPER(CM_MESSAGE.MSG_CD) = UPPER(:MSG_CD) " +
							"  ) " +
							"  and UPPER(CM_MESSAGE.USE_FLAG) = 'Y' "
			;

			// Set parameter query
			MapSqlParameterSource sqlParameter = new MapSqlParameterSource();
			sqlParameter.addValue("MSG", StringUtils.isBlank(msg) ? null : msg);
			// lang_cd
			sqlParameter.addValue("CHECK_ARRAY_LANG_CD", CollectionUtils.isEmpty(listLangCd) ? null : "CHECK_TRUE");
			sqlParameter.addValue("ARRAY_LANG_CD", CollectionUtils.isEmpty(listLangCd) 
					? null : listLangCd.stream().map(String::toUpperCase).collect(Collectors.toSet()));
			// msg_grp
			sqlParameter.addValue("CHECK_ARRAY_MSG_GRP", CollectionUtils.isEmpty(listMsgGrp) ? null : "CHECK_TRUE");
			sqlParameter.addValue("ARRAY_MSG_GRP", CollectionUtils.isEmpty(listMsgGrp) 
					? null : listMsgGrp.stream().map(String::toUpperCase).collect(Collectors.toSet()));
			// msg_type
			sqlParameter.addValue("CHECK_ARRAY_MSG_TYPE", CollectionUtils.isEmpty(listMsgType) ? null : "CHECK_TRUE");
			sqlParameter.addValue("ARRAY_MSG_TYPE", CollectionUtils.isEmpty(listMsgType) 
					? null : listMsgType.stream().map(String::toUpperCase).collect(Collectors.toSet()));
			// msg_type
			sqlParameter.addValue("CHECK_ARRAY_SYS_CD", CollectionUtils.isEmpty(listSysCd) ? null : "CHECK_TRUE");
			sqlParameter.addValue("ARRAY_SYS_CD", CollectionUtils.isEmpty(listSysCd) 
					? null : listSysCd.stream().map(String::toUpperCase).collect(Collectors.toSet()));
			// comp_cd
			sqlParameter.addValue("CHECK_ARRAY_COMP_CD", CollectionUtils.isEmpty(listCompCd) ? null : "CHECK_TRUE");
			sqlParameter.addValue("ARRAY_COMP_CD", CollectionUtils.isEmpty(listCompCd) 
					? null : listCompCd.stream().map(String::toUpperCase).collect(Collectors.toSet()));
			// msg_cd
			sqlParameter.addValue("MSG_CD", msgCd);

			// Execute query
	        List<GetCmMessageDetailResponseDto> result = namedParameterJdbcTemplate.query(sql, sqlParameter, new CmMessageRowMapper());

	        return result;
		}
	}

	@Override
	public boolean checkExistsCmMessage(String msg, Set<String> listLangCd, Set<String> listMsgGrp,
			Set<String> listMsgType, Set<String> listSysCd, Set<String> listCompCd, String msgCd) {
		// Initial Namped Parameters JDBC Template

		// Sql statement
		String sql = 
						" SELECT count(1) " +
						" FROM CM_MESSAGE " +
						" where 1 = 1 " +
						"  and ( " +
						"  	:MSG is NULL " +
						" 	or " +
						"   MSG = :MSG " +
						"  ) " +
						"  and ( " +
						"  	:CHECK_ARRAY_LANG_CD is NULL " +
						" 	or " +
						"   UPPER(LANG_CD) in (:ARRAY_LANG_CD) " +
						"  ) " +
						"  and ( " +
						"  	:CHECK_ARRAY_MSG_GRP is NULL " +
						" 	or " +
						"   UPPER(MSG_GRP) in (:ARRAY_MSG_GRP) " +
						"  ) " +
						"  and ( " +
						"  	:CHECK_ARRAY_MSG_TYPE is NULL " +
						" 	or " +
						"   UPPER(MSG_TYPE) in (:ARRAY_MSG_TYPE) " +
						"  ) " +
						"  and ( " +
						"  	:CHECK_ARRAY_SYS_CD is NULL " +
						" 	or " +
						"   UPPER(SYS_CD) in (:ARRAY_SYS_CD) " +
						"  ) " +
						"  and ( " +
						"  	:CHECK_ARRAY_COMP_CD is NULL " +
						" 	or " +
						"   UPPER(CM_MESSAGE.COMP_CD) in (:ARRAY_COMP_CD) " +
						"  ) " +
						"  and ( " +
						"  	:MSG_CD is NULL " +
						" 	or " +
						"   UPPER(CM_MESSAGE.MSG_CD) = UPPER(:MSG_CD) " +
						"  ) " +
						"  and UPPER(USE_FLAG) = 'Y' "
		;

		// Set parameter query
		MapSqlParameterSource sqlParameter = new MapSqlParameterSource();
		sqlParameter.addValue("MSG", StringUtils.isBlank(msg) ? null : msg);
		// lang_cd
		sqlParameter.addValue("CHECK_ARRAY_LANG_CD", CollectionUtils.isEmpty(listLangCd) ? null : "CHECK_TRUE");
		sqlParameter.addValue("ARRAY_LANG_CD", CollectionUtils.isEmpty(listLangCd) 
				? null : listLangCd.stream().map(String::toUpperCase).collect(Collectors.toSet()));
		// msg_grp
		sqlParameter.addValue("CHECK_ARRAY_MSG_GRP", CollectionUtils.isEmpty(listMsgGrp) ? null : "CHECK_TRUE");
		sqlParameter.addValue("ARRAY_MSG_GRP", CollectionUtils.isEmpty(listMsgGrp) 
				? null : listMsgGrp.stream().map(String::toUpperCase).collect(Collectors.toSet()));
		// msg_type
		sqlParameter.addValue("CHECK_ARRAY_MSG_TYPE", CollectionUtils.isEmpty(listMsgType) ? null : "CHECK_TRUE");
		sqlParameter.addValue("ARRAY_MSG_TYPE", CollectionUtils.isEmpty(listMsgType) 
				? null : listMsgType.stream().map(String::toUpperCase).collect(Collectors.toSet()));
		// msg_type
		sqlParameter.addValue("CHECK_ARRAY_SYS_CD", CollectionUtils.isEmpty(listSysCd) ? null : "CHECK_TRUE");
		sqlParameter.addValue("ARRAY_SYS_CD", CollectionUtils.isEmpty(listSysCd) 
				? null : listSysCd.stream().map(String::toUpperCase).collect(Collectors.toSet()));
		// comp_cd
		sqlParameter.addValue("CHECK_ARRAY_COMP_CD", CollectionUtils.isEmpty(listCompCd) ? null : "CHECK_TRUE");
		sqlParameter.addValue("ARRAY_COMP_CD", CollectionUtils.isEmpty(listCompCd) 
				? null : listCompCd.stream().map(String::toUpperCase).collect(Collectors.toSet()));
		// msg_cd
		sqlParameter.addValue("MSG_CD", msgCd);

		// Execute query
        int count = namedParameterJdbcTemplate.queryForObject(sql, sqlParameter, Integer.class);
		return count > 0 ? true : false;
	}

	@Override
	public boolean saveCmMessageIntoNextHRCore(GenerateFileTemplateRequestDto requestDto) {
		// Initial Namped Parameters JDBC Template

		String sql = fileTemplateService.generateFileTemplateToString(requestDto);
		if (StringUtils.isBlank(sql) || sql.toUpperCase().contains("DELETE FROM")) {
			return false;
		} else {
        	// Split array query statement
			String[] arrayQueryStatement = sql.split(";");
			// Handling Transaction Template execute
			boolean checkSaved = transactionTemplate.execute(status -> {
				for (int i = 0; i < arrayQueryStatement.length; i++) {
					if (StringUtils.isNotBlank(arrayQueryStatement[i])) {
						jdbcTemplate.update(arrayQueryStatement[i]);
					}
				}
	            return true;
	        });
			return checkSaved; 
		}
	}
}
