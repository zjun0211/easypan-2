package com.easypan.config;

import com.easypan.entity.constants.Constants;
import com.easypan.entity.dto.SysSettingsDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 王哲
 * @ClassName RedisComponent
 * @create 2023--六月--下午3:12
 * @Description a
 * @Version V1.0
 */
@Component
public class RedisComponent {

    @Resource
    private RedisUtils redisUtils;

    //获得设置
    public SysSettingsDto getSystemSettingDto() {
        SysSettingsDto sysSettingsDto = (SysSettingsDto)redisUtils.get(Constants.REDIS_SYSTEM_SETTING);
        if (sysSettingsDto == null) {
            sysSettingsDto = new SysSettingsDto();
            redisUtils.set(Constants.REDIS_SYSTEM_SETTING, sysSettingsDto);
        }
        return sysSettingsDto;
    }

}
