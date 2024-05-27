package com.baont8.toolgenerate.repository.toolGenerate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baont8.toolgenerate.entity.toolGenerate.FileTemplateDocumentStorage;
import com.baont8.toolgenerate.entity.toolGenerate.id.FileTemplateDocumentStorageId;
import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.repository.toolGenerate.query.FileTemplateDocumentStoragerQuery;

import io.swagger.v3.oas.annotations.Hidden;

@Repository
@Hidden
public interface FileTemplateDocumentStorageRepository extends JpaRepository<FileTemplateDocumentStorage, FileTemplateDocumentStorageId>{

	@Modifying
	@Query(value = FileTemplateDocumentStoragerQuery.HARD_DELETE_BY_FILE_TEMPLATE_ID_AND_DOCUMENT_STORAGE_ID, nativeQuery = true)
	@Transactional
	public void hardDeleteByFileIdAndDocumentStorageId(Integer fileTemplateId, Long documentStorageId);

	public List<FileTemplateDocumentStorage> findAllDocumentStorageByFileTemplateFileTemplateId(Integer fileTemplateId);
}
