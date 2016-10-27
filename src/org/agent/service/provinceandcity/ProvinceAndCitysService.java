package org.agent.service.provinceandcity;

import java.util.List;

import org.agent.pojo.Area;
import org.agent.pojo.City;
 
import org.agent.pojo.Province;
 

public interface ProvinceAndCitysService {
	public List<Province> getProvinceList();
	public List<City> getCitys(Province province);
	public List<Area> getAreas(City city);
	public  Area getShengShiXian(Area area);
}
