package com.village.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.village.base.model.VillageUser;
import com.village.user.service.ITestService;

@Controller
public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	@Autowired
	ITestService testService;
	
	private HttpServletRequest request; 
    private HttpServletResponse response;

	private String userName;
	
	private String password;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String login(){
		String temp= "";
		if("123".equals(userName)&& "123".equals(password)){
			temp = "ok";
		}else{
			temp = "fail";
		}
//		request.setAttribute("str", temp);
//		VillageUser villageUser = new VillageUser();
		VillageUser villageUser = new VillageUser();
//		List<com.village.base.model.hibernate.VillageUser> list = testService.findAllByParams();
//		testService.saveVillageUser(villageUser);
		VillageUser villageUser2 = new VillageUser();
		villageUser2.setCractUnid(0);
		villageUser2 = testService.getVillageUser(villageUser2);
		System.out.println(villageUser2.getCractCrorgUuid()+"--------villageUser2---------------");
		System.out.println("--------------123123---------");
//		testService.save(villageUser);
		
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	
}
