package com.village.base.service;

import java.util.List;
import java.util.Map;

import com.village.base.model.BaseModel;

public interface BaseService<T extends BaseModel> {
	
	public T get(T t);
	
	public Integer save(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public void batchSave(List<T> list);
	
	public void batchUpdate(List<T> list);
	
	public void batchDelete(List<T> list);
	
	public List<T> findAllByParams(String sql, Map<String, Object> map);
	
	//TODO 先暂时不删除，可删除的方法
	public void setParam(List<Object> list);
	
	public List<T> findByPage(String sql, Map<String,Object> map);
}
