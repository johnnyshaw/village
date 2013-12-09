package com.village.base.abs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.village.base.model.BaseModel;
import com.village.base.service.BaseService;

public abstract class AbstractBaseService<T extends BaseModel> implements BaseService<T>{
	
	@Autowired
	protected BaseService<T> baseService;

	public T get(T t){
		return baseService.get(t);
	}
	
	public Integer save(T t){
		return baseService.save(t);
	}
	
	public void update(T t){
		baseService.update(t);
	}
	
	public void delete(T t){
		baseService.delete(t);
	}
	
	public void batchSave(List<T> list){
		baseService.batchSave(list);
	}
	
	public void batchUpdate(List<T> list){
		baseService.batchUpdate(list);
	}
	
	public void batchDelete(List<T> list){
		baseService.batchDelete(list);
	}
	
	public List<T> findAllByParams(String sql, Map<String, Object> map){
		return baseService.findAllByParams(sql, map);
	}
	
	//TODO 先暂时不删除，可删除的方法
	public void setParam(List<Object> list){
		baseService.setParam(list);
	}
	
	public List<T> findByPage(String sql, Map<String,Object> map){
		return baseService.findByPage(sql, map);
	}
	
	
}
