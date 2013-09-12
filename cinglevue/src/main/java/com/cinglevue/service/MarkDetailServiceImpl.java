package com.cinglevue.service;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinglevue.common.CommonDAO;
import com.cinglevue.dao.MarkDetailDAO;
import com.cinglevue.entity.MarkDetail;
import com.cinglevue.entity.School;
import com.cinglevue.util.CingleVueConstant;

@Service(value="markDetailService")
public class MarkDetailServiceImpl implements MarkDetailService {

	@Autowired
	private CommonDAO commonDAO;
	
	@Autowired
	private MarkDetailDAO markDetailDAO;
	
	@Override
	public String addJsonDataToDatabase() throws Exception {
		try {
			JSONParser parser = new JSONParser();
			JSONObject a = (JSONObject) parser.parse(new FileReader(CingleVueConstant.JSON_FILE_PATH));
			
			JSONArray school = (JSONArray) a.get("schools");
			if (markDetailDAO.tableRowCount() < 1) {
			  for (Object o : school)
			  {
				MarkDetail markDetailObj = new MarkDetail();
			    JSONObject markDetail = (JSONObject) o;

			    String subject = (String) markDetail.get("subject");
			    System.out.println(subject);
			    markDetailObj.setSubject(subject);
			    
			    Double latestY3 = (Double) markDetail.get("latestY3");
			    System.out.println(latestY3);
			    markDetailObj.setLatestY3(latestY3);
			    
			    Double latestY5 = (Double) markDetail.get("latestY5");
			    System.out.println(latestY5);
			    markDetailObj.setLatestY5(latestY5);
			    
			    Double latestY7 = (Double) markDetail.get("latestY7");
			    System.out.println(latestY7);
			    markDetailObj.setLatestY7(latestY7);
			    
			    Double latestY9 = (Double) markDetail.get("latestY9");
			    System.out.println(latestY9);
			    markDetailObj.setLatestY9(latestY9);
			    
			    Double rawGainY3Y5 = (Double) markDetail.get("rawGainY3Y5");
			    System.out.println(rawGainY3Y5);
			    markDetailObj.setRawGainY3Y5(rawGainY3Y5);
			    
			    Double factoredGainY3Y5 = (Double) markDetail.get("factoredGainY3Y5");
			    System.out.println(factoredGainY3Y5);
			    markDetailObj.setFactoredGainY3Y5(factoredGainY3Y5);
			    
			    Double glgY3Y5 = (Double) markDetail.get("glgY3Y5");
			    System.out.println(glgY3Y5);
			    markDetailObj.setGlgY3Y5(glgY3Y5);
			    
			    Double latestGainInGainY3Y5 = (Double) markDetail.get("latestGainInGainY3Y5");
			    System.out.println(latestGainInGainY3Y5);
			    markDetailObj.setLatestGainInGainY3Y5(latestGainInGainY3Y5);
			    
			    JSONObject schoolObj = (JSONObject) markDetail.get("school");
			    String schoolName = (String) schoolObj.get("schoolName");
			    System.out.println(schoolName);
			    
			    School schoolNew = new School();
			    schoolNew.setSchoolName(schoolName);
			    schoolNew.setMarkDetail(markDetailObj);
			    
			    commonDAO.createEntity(markDetailObj);
			    commonDAO.createEntity(schoolNew);
			  }
			}
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CingleVueConstant.SUCCESS;
	}

	@Override
	public List<Map<String, Object>> marksList(String subject) throws Exception {

		return markDetailDAO.marksList(subject);
	}

	@Override
	public List<String> getDistinctSubjects() throws Exception {
		List<String> markDetails = markDetailDAO.getDistinctSubjects();
		return markDetails;
	}

}
