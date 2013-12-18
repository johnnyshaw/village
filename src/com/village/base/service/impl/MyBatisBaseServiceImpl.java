package com.village.base.service.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.johnny.util.ClassUtil;
import com.village.base.model.BaseModel;
import com.village.base.service.BaseService;

public class MyBatisBaseServiceImpl <T extends BaseModel> implements BaseService<T>{
	
	private String mapperPackage = "";
	
	private String className;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public String getMapperPackage() {
		return mapperPackage;
	}

	public void setMapperPackage(String mapperPackage) {
		this.mapperPackage = mapperPackage;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public MyBatisBaseServiceImpl(){
		mapperPackage = "com.village.base.model.mybatis.mapper.";
//		className=ClassUtil.getGenericClass(this.getClass());
//		System.out.println(className+"---------------className============");
	}

	public T get(T t) {
		this.className = ClassUtil.getClassName(t.getClass().getName());
//		t.setCondition(condition)
		return this.sqlSessionTemplate.selectOne(mapperPackage+className+"Mapper.get"+className, t);
	}

	public Integer save(T t) {
		this.className = ClassUtil.getClassName(t.getClass().getName());
		if(this.sqlSessionTemplate == null){
			System.out.println("-------------sqlSessionTemplate-----is----null----------");
		}
		return this.sqlSessionTemplate.insert(mapperPackage+className+"Mapper.save"+className, t);
	}

	public void update(T t) {
		// TODO Auto-generated method stub
	}
	
	public void delete(T t) {
		// TODO Auto-generated method stub
	}
	
	public void batchDelete(List<T> list) {
		// TODO Auto-generated method stub
	}

	public void batchSave(List<T> list) {
		// TODO Auto-generated method stub
	}

	public void batchUpdate(List<T> list) {
		// TODO Auto-generated method stub
	}


	public void setParam(List<Object> list) {
		// TODO Auto-generated method stub
		
	}

	public List<T> findAllByParams(String sql, Map<String, Object> map) {
		return null;
	}

	public List<T> findByPage(String sql, Map<String, Object> map) {
		return null;
	}
	
}
