package com.cinglevue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinglevue.common.CommonDAO;
import com.cinglevue.dao.MarkDetailDAO;
import com.cinglevue.service.MarkDetailService;
import com.cinglevue.util.CingleVueConstant;


@Controller
public class MarkDetailController {
	
	@Autowired
	private MarkDetailService markDetailService;

    /**
     * Method for load dashboard page
     */
	
	@RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
	public String getProductDetail(HttpServletRequest request) {	
		return "adminDashboard";
	}
	
    /**
     * Method for add json file data to db
     */
	@RequestMapping(value = "/addJsonDataToDb", method = RequestMethod.GET)
	public @ResponseBody Map addJsonDataToDb(HttpServletRequest request) {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		Map<String, Object> valuesMap = new HashMap<String, Object>();
		try {
			String result = markDetailService.addJsonDataToDatabase();
			responseMap.put("status", result);			
		} catch (Exception e) {
			e.printStackTrace();
			valuesMap.put("exception", e.getMessage());

			responseMap.put("status", "exception");
			responseMap.put("data", valuesMap);
		}
		return responseMap;
	}
	
    /**
     * Method for get marks list
     */
	@RequestMapping(value = "/marksList.htm", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> marksList(HttpServletRequest request, @RequestParam("subject") String subject) {
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			 map.put("aaData", markDetailService.marksList(subject));
			 return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
    /**
     * Method for get unique subjects 
     */
	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public @ResponseBody Map subjects(HttpServletRequest request) {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		Map<String, Object> valuesMap = new HashMap<String, Object>();
		try {
			List<String> subjects = markDetailService.getDistinctSubjects();
			valuesMap.put("subjects", subjects);
			responseMap.put(CingleVueConstant.DATA, valuesMap);
			responseMap.put("status", "success");			
		} catch (Exception e) {
			e.printStackTrace();
			valuesMap.put("exception", e.getMessage());

			responseMap.put("status", "exception");
			responseMap.put(CingleVueConstant.DATA, valuesMap);
		}
		return responseMap;
	}
	
}
