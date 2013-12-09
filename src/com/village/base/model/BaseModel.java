package com.village.base.model;

import java.io.Serializable;
import java.util.List;

import com.village.base.sqlCmd.ISqlExp;

public class BaseModel implements Serializable{
	
	private PageInfo pageInfo;
	
	private List<BaseModel> result;
	
	private ISqlExp condition;
	
	private ISqlExp updateSet;

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public List<BaseModel> getResult() {
		return result;
	}

	public void setResult(List<BaseModel> result) {
		this.result = result;
	}

	public ISqlExp getCondition() {
		return condition;
	}

	public void setCondition(ISqlExp condition) {
		this.condition = condition;
	}

	public ISqlExp getUpdateSet() {
		return updateSet;
	}

	public void setUpdateSet(ISqlExp updateSet) {
		this.updateSet = updateSet;
	}
	
}
