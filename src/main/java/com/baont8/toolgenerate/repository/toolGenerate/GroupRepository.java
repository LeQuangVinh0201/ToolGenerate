package com.baont8.toolgenerate.repository.toolGenerate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baont8.toolgenerate.entity.toolGenerate.GroupData;

import io.swagger.v3.oas.annotations.Hidden;

@Repository
@Hidden
public interface GroupRepository extends JpaRepository<GroupData, Integer>{

}
