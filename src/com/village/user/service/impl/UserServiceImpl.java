package com.village.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.village.base.abs.AbstractBaseService;
import com.village.base.model.VillageUser;
import com.village.user.service.IUserService;

@Transactional
@Service("testService")
//public class TestServiceImpl extends MyBatisBaseServiceImpl<VillageUser> implements ITestService {
//public class TestServiceImpl extends HibernateBaseServiceImpl<VillageUser> implements ITestService {
public class UserServiceImpl extends AbstractBaseService<VillageUser> implements IUserService {

	public List<VillageUser> findAllByParams(){
		String hql = "from VillageUser";
		return super.findAllByParams(hql, null);
	}
	 
	public Integer saveVillageUser(VillageUser villageUser){
		villageUser.setCractUnid(22);
		villageUser.setCractUuid("222312312312");
		int result = super.save(villageUser);
		return result;
	}
	
	public VillageUser getVillageUser(VillageUser model){
		return super.get(model);
	}
	
}
