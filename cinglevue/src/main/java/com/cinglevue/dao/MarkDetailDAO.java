package com.cinglevue.dao;

import java.util.List;
import java.util.Map;

import com.cinglevue.entity.MarkDetail;

public interface MarkDetailDAO {
	
	public List<Map<String, Object>> marksList(String subject) throws Exception;
	
	public List<String> getDistinctSubjects() throws Exception;
	
	public int tableRowCount() throws Exception;

}
