package com.baont8.toolgenerate.repository.toolGenerate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baont8.toolgenerate.entity.toolGenerate.FileTemplate;
import com.baont8.toolgenerate.enumration.StatusEnum;
import com.baont8.toolgenerate.repository.toolGenerate.query.FileTemplateQuery;

import io.swagger.v3.oas.annotations.Hidden;

@Repository
@Hidden
public interface FileTemplateRepository extends JpaRepository<FileTemplate, Integer>{

	boolean existsFileTemplateByFileTemplateIdAndStatus(Integer fileTemplateId, StatusEnum status);
	
	Optional<FileTemplate> findOneByFileTemplateIdAndStatus(Integer fileTemplateId, StatusEnum status);

	@Query(value = FileTemplateQuery.LIST_FILE_TEMPLATE,
		   countQuery = FileTemplateQuery.LIST_FILE_TEMPLATE,
		   nativeQuery = true)
	Page<FileTemplate> findAllFileTemplateWithPaging(Pageable pageable, @Param("status") String status);


	@Query(value = FileTemplateQuery.LIST_FILE_TEMPLATE,
			   countQuery = FileTemplateQuery.LIST_FILE_TEMPLATE,
			   nativeQuery = true)
	List<FileTemplate> findAllFileTemplateUnPaging(@Param("status") String status);
}
