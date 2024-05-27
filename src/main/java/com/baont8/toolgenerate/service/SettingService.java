package com.baont8.toolgenerate.service;

import com.baont8.toolgenerate.entity.toolGenerate.Setting;
import com.baont8.toolgenerate.enumration.SettingEnum;
import com.baont8.toolgenerate.service.dtoRequest.setting.SettingFileCreMessageHrRequestDto;
import com.baont8.toolgenerate.service.dtoRequest.setting.SettingFileCreMessageNextHrRequestDto;

public interface SettingService {

	public void settingFileTemplateToCreateCmMessageForNextHrCore(SettingFileCreMessageNextHrRequestDto requestDto);

	public void settingFileTemplateToCreateCmMessageForHrCore(SettingFileCreMessageHrRequestDto requestDto);

	public Setting findOneByCodeAndThrowExceptionIfNotExists(SettingEnum code);

	public Setting findOneByCode(SettingEnum code);

}
