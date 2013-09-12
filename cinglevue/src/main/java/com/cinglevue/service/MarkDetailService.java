package com.cinglevue.service;

import java.util.List;
import java.util.Map;

public interface MarkDetailService {
	
    /**
     * Method for add json file data to db
     */
	public String addJsonDataToDatabase() throws Exception;
	
    /**
     * Method for get marks list
     */
	public List<Map<String, Object>> marksList(String subject) throws Exception;
	
    /**
     * Method for get unique subjects 
     */
	public List<String> getDistinctSubjects() throws Exception;

}
