package org.agent.dao.systemconfig;

import java.util.List;

import org.agent.pojo.SystemConfig;
import org.apache.ibatis.annotations.Param;

public interface SystemConfigMapper {
	public List<SystemConfig> getSystemConfigs(SystemConfig systemConfig);
	public List<SystemConfig> getSystemConfigsIsStart(SystemConfig systemConfig);
	 
	public int addSystemConfig(SystemConfig systemConfig);
	public int modifySystemConfig(SystemConfig systemConfig);
	public int isPeatConfig(SystemConfig systemConfig);
	public int deleteSystemConfig(SystemConfig systemConfig);
	public int maxTypeValue(@Param("type")int type);
	 
}
