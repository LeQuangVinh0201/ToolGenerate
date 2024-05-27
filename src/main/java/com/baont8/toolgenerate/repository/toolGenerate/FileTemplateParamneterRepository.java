package com.baont8.toolgenerate.repository.toolGenerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baont8.toolgenerate.entity.toolGenerate.FileTemplateParameter;
import com.baont8.toolgenerate.repository.toolGenerate.query.FileTemplateParameterQuery;

import io.swagger.v3.oas.annotations.Hidden;

@Repository
@Hidden
public interface FileTemplateParamneterRepository  extends JpaRepository<FileTemplateParameter, Integer>{

	@Modifying
	@Query(value = FileTemplateParameterQuery.HARD_DELETE_BY_FILE_TEMPLATE_ID_AND_FILE_TEMPLATE_PARAM_ID, nativeQuery = true)
	@Transactional
	public void hardDeleteByFileIdAndFileParamId(Integer fileTemplateId, Integer fileTemplateParameterId);

}
