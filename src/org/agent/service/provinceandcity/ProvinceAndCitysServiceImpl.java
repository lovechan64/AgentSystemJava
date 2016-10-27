package org.agent.service.provinceandcity;

import java.util.List;

 
import org.agent.dao.provinceandcity.ProvinceAndCitysMapper;
import org.agent.pojo.Area;
import org.agent.pojo.City;
 
import org.agent.pojo.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("provinceAndCitysService")
public class ProvinceAndCitysServiceImpl implements ProvinceAndCitysService {
	@Autowired
	private ProvinceAndCitysMapper mapper;

	@Override
	public List<Province> getProvinceList() {
		// TODO Auto-generated method stub
		return mapper.getProvinceList();
	}

	@Override
	public List<City> getCitys(Province province) {
		// TODO Auto-generated method stub
		return mapper.getCitys(province);
	}

	@Override
	public List<Area> getAreas(City city) {
		// TODO Auto-generated method stub
		return mapper.getAreas(city);
	}

	public void setMapper(ProvinceAndCitysMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Area getShengShiXian(Area area) {
		// TODO Auto-generated method stub
		return mapper.getShengShiXian(area);
	}

 

}
