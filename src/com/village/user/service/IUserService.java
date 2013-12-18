package com.village.user.service;


import java.util.List;

import com.village.base.model.VillageUser;

//public interface ITestService extends BaseService<BaseModel>{
public interface IUserService{

	public List<VillageUser> findAllByParams();
	
	public Integer saveVillageUser(VillageUser model);
	
	public VillageUser getVillageUser(VillageUser model);
}
