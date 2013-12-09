package com.village.base.service.impl;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.village.base.model.BaseModel;
import com.village.base.service.BaseService;
import com.village.util.ClassUtil;

public class HibernateBaseServiceImpl<T extends BaseModel> implements BaseService<T>{
//public class HibernateBaseServiceImpl<T extends BaseModel> extends AbstractBaseServiceImpl<BaseModel> {//implements BaseService<BaseModel>{
	
	private Class<T> entityClass;
	    
	public HibernateBaseServiceImpl(){
//		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
//		entityClass = (Class<T>)type.getActualTypeArguments()[0];
		entityClass = ClassUtil.getGenericClass(getClass());
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}


	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
//		return this.sessionFactory.openSession();
	}
	
	@SuppressWarnings("unchecked")
	public T get(T t) {
		return (T)this.getSession().get(entityClass,t);
	}

	public Integer save(T t) {
		return (Integer) this.getSession().save(t);
	}

	public void update(T t) {
		this.getSession().update(t);
	}
	
	public void delete(T t) {
		this.getSession().delete(t);
	}
	
	
	public void batchDelete(List<T> list) {
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				this.getSession().delete(list.get(i));
			}
		}
	}

	public void batchSave(List<T> list) {
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				this.getSession().saveOrUpdate(list.get(i));
			}
		}
	}

	public void batchUpdate(List<T> list) {
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				this.getSession().saveOrUpdate(list.get(i));
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAllByParams(String sql, Map<String, Object> map) {
		if(this.getSession() == null)
			System.out.println("connection is null-----------------------------------------");
		Query query = this.getSession().createQuery(sql);
		setParameter(query, map);
		return query.list();
	}
	
	private Query setParameter(Query query, Map<String, Object> map) {  
        if (map != null) {  
            Set<String> keySet = map.keySet();  
            for (String string : keySet) {  
                Object obj = map.get(string);  
                //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
                if(obj instanceof Collection<?>){  
                    query.setParameterList(string, (Collection<?>)obj);  
                }else if(obj instanceof Object[]){  
                    query.setParameterList(string, (Object[])obj);  
                }else{  
                    query.setParameter(string, obj);  
                }  
            }  
        }  
        return query;
    }  

	public void setParam(List<Object> list) {
		Criteria criteria = getSession().createCriteria(entityClass);
		if(list != null && list.size()>0){
			for(int i=0;i<list.size();i++){
				
			}
		}
	}

	public List<T> findByPage(String sql, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}


}
