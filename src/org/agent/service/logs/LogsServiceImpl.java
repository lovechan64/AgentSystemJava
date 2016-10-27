package org.agent.service.logs;

import java.util.List;

import org.agent.dao.logs.LogsMapper;
 
import org.agent.pojo.Logs;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("logsService")
public class LogsServiceImpl implements LogsService {
	@Autowired
	private LogsMapper mapper;

	public void setMapper(LogsMapper mapper) {
		this.mapper = mapper;
	}

	
	@Override
	public int addLogs(Logs logs) {
		// TODO Auto-generated method stub
		return mapper.addLogs(logs);
	}

	@Override
	public int count(Logs logs) {
		// TODO Auto-generated method stub
		return mapper.count(logs);
	}


	@Override
	public List<Logs> getList(Logs logs) {
		// TODO Auto-generated method stub
		return mapper.getList(logs);
	}	
	 


}
