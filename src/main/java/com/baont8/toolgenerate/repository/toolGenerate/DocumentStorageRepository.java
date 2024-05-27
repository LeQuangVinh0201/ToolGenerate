package com.baont8.toolgenerate.repository.toolGenerate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baont8.toolgenerate.entity.toolGenerate.DocumentStorage;
import com.baont8.toolgenerate.enumration.StatusEnum;

import io.swagger.v3.oas.annotations.Hidden;

@Repository
@Hidden
public interface DocumentStorageRepository extends JpaRepository<DocumentStorage, Integer>{

	Optional<DocumentStorage> findOneByIdAndStatus(Long id, StatusEnum status);

}
