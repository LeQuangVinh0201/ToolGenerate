package com.baont8.toolgenerate.repository.toolGenerate;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baont8.toolgenerate.entity.toolGenerate.Setting;
import com.baont8.toolgenerate.enumration.SettingEnum;
import com.baont8.toolgenerate.enumration.StatusEnum;

import io.swagger.v3.oas.annotations.Hidden;

@Repository
@Hidden
public interface SettingRepository extends JpaRepository<Setting, SettingEnum>{

	Optional<Setting> findOneByCodeAndStatus(SettingEnum code, StatusEnum status);

}
