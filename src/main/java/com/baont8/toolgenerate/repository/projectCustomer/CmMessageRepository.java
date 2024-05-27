package com.baont8.toolgenerate.repository.projectCustomer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baont8.toolgenerate.entity.projectCustomer.CmMessage;
import com.baont8.toolgenerate.entity.projectCustomer.CmMessageId;
import com.baont8.toolgenerate.repository.projectCustomer.query.CmMessageQuery;
import com.baont8.toolgenerate.service.dtoResponse.cmMessage.GetDetailCmMessageInterfaceDto;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
//@Repository
public interface CmMessageRepository {
//	extends JpaRepository<CmMessage, CmMessageId>{
//
//	public Optional<CmMessage> findOneByMsgGrpAndMsgCdAndLangCdAndCompCd(@Param("MSG_GRP") String msgGrp
//			, @Param("MSG_CD") String msgCd, @Param("LANG_CD") String langCd
//			, @Param("COMP_CD") String compCd
//	);
//
//	@Query(value = CmMessageQuery.FIND_CM_MESSAGE, nativeQuery = true)
//	List<GetDetailCmMessageInterfaceDto> findCmMessage(@Param("MSG") String msg);
}
