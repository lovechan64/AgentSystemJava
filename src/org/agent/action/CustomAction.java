package org.agent.action;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.agent.common.Constants;
 
import org.agent.pojo.Area;
import org.agent.pojo.City;
import org.agent.pojo.Contacts;
import org.agent.pojo.Customs;
import org.agent.pojo.Logs;
import org.agent.pojo.Province;
import org.agent.pojo.SystemConfig;
import org.agent.service.contacts.ContactsService;
import org.agent.service.customs.CustomsService;
import org.agent.service.provinceandcity.ProvinceAndCitysService;

import com.opensymphony.xwork2.Action;


public class CustomAction extends BaceAction {
	private Customs custom;
	private Logs logs;
	private Contacts contacts;
	private CustomsService customsService;
	private ContactsService contactsService;
	private ProvinceAndCitysService provinceAndCitysService;
	private List<SystemConfig> customTypeList=Constants.customConfigList;
	private List<SystemConfig> cardTypeList=Constants.cardTypeConfigList;
	private List<Province> provinceList;
	private List<City> cityList;
	private List<Area> areaList;
	
	private Province province;
	private City city;
	private Area area;
	private List<Contacts> contactsList;
	
	
	
	
	public String modifyCustomStatus(){
		if(custom!=null)
	if(	this.customsService.modifyCustomStatus(custom)>0){
		return "success";
	}
		
		return "input";
	}
	
	public String execute(){
		
		
		
		
		
		
		 	custom.setAgentCode(this.getCurrentUser().getUserCode());
		custom.setAgentId(this.getCurrentUser().getId());
		custom.setAgentName(this.getCurrentUser().getUserName());
		 
		 
			if(custom!=null)
				this.getCustomsService().tx_modifyCustomContact(custom, contactsList);
		this.setLog(getCurrentUser(), "用户【"+this.getCurrentUser().getUserCode()+"】进行客户修改操作:修改客户:"+custom.getCustomName());
			
		 
		
		
		
		return "success";

		
		
		
		 
	}

	public String chakanCustom(){
	
		contacts=new Contacts();
		 
		contacts.setCustomId(custom.getId());
		contactsList=this.getContactsService().getContactsList(contacts);
		this.custom= this.getCustomsService().getCustomsById(custom);
		
		if(area==null)
		area=new Area();
		area.setAreaId(custom.getArea());
	 
		area=this.provinceAndCitysService.getShengShiXian(area);
		
		return Action.SUCCESS;
	}
	public String modifyCustom(){
		
		contacts=new Contacts();
		 
		contacts.setCustomId(custom.getId());
		contactsList=this.getContactsService().getContactsList(contacts);
		this.custom= this.getCustomsService().getCustomsById(custom);
		return Action.SUCCESS;
	}
	public void loadCity(){
		 String cjson="";
		 cityList=this.provinceAndCitysService.getCitys(province);
		 cjson=JSONArray.fromObject(cityList).toString();
		 this.getOut().print(cjson);
		
		
		
		
	}	public void loadArea(){
		 
		 String ajson="";
		 areaList=this.provinceAndCitysService.getAreas(city);
		 ajson=JSONArray.fromObject(areaList).toString();
		 this.getOut().print(ajson);
		
		
		
		
	}
	public void isExitCustomName(){
		 if(this.getCustomsService().isExitCustoms(custom)>0){
			 this.getOut().print("peat");
			 
		 }else {
			 this.getOut().print("nopeat");
		};
	}

	public void setLogs(Logs logs) {
		this.logs = logs;
	}
	public String exex(){
		return Action.SUCCESS;
	}
	public String addCustom(){
		custom.setAgentCode(this.getCurrentUser().getUserCode());
		custom.setAgentId(this.getCurrentUser().getId());
		custom.setAgentName(this.getCurrentUser().getUserName());
		custom.setRegDatetime(new Date());
		 
			if(custom!=null)
				this.getCustomsService().tx_addCustomContact(custom, contactsList);
		this.setLog(getCurrentUser(), "用户【"+this.getCurrentUser().getUserCode()+"】进行客户添加操作:添加客户:"+custom.getCustomName());
			return Action.SUCCESS;
			
		 
		
		
		
		
	}

 

	public Customs getCustom() {
		return custom;
	}



	public void setCustom(Customs custom) {
		this.custom = custom;
	}



	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public CustomsService getCustomsService() {
		return customsService;
	}

	public void setCustomsService(CustomsService customsService) {
		this.customsService = customsService;
	}

	public ContactsService getContactsService() {
		return contactsService;
	}

	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

	public ProvinceAndCitysService getProvinceAndCitysService() {
		return provinceAndCitysService;
	}

	public void setProvinceAndCitysService(
			ProvinceAndCitysService provinceAndCitysService) {
		this.provinceAndCitysService = provinceAndCitysService;
	}

	public List<SystemConfig> getCustomTypeList() {
		return customTypeList;
	}

	public void setCustomTypeList(List<SystemConfig> customTypeList) {
		this.customTypeList = customTypeList;
	}

	public List<SystemConfig> getCardTypeList() {
		return cardTypeList;
	}

	public void setCardTypeList(List<SystemConfig> cardTypeList) {
		this.cardTypeList = cardTypeList;
	}

	public List<Province> getProvinceList() {
		this.provinceList=this.getProvinceAndCitysService().getProvinceList();
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public Province getProvince() {
		 
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Contacts> getContactsList() {
		return contactsList;
	}

	public void setContactsList(List<Contacts> contactsList) {
		this.contactsList = contactsList;
	}
	
	
	
	
	
	
	
}
