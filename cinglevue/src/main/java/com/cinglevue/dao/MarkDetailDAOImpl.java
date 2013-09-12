package com.cinglevue.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cinglevue.entity.MarkDetail;

@Repository(value = "markDetailDAO")
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MarkDetailDAOImpl implements MarkDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Map<String, Object>> marksList(String subject) throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MarkDetail.class);
		if (!subject.equals("all")) {
			criteria.add(Restrictions.eq("subject", subject));			
		}
		List<MarkDetail> marksList = criteria.list();
		
		List<Map<String,Object>> returnMapList=new ArrayList<Map<String,Object>>();
		if(!(marksList==null || marksList.isEmpty())){
			for (MarkDetail mark : marksList) {				
				returnMapList.add(mark.toMarkDetailMap());
			}
		}	
		return returnMapList;
	}

	@Override
	public List<String> getDistinctSubjects() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MarkDetail.class);
		criteria.setProjection(Projections.distinct(Projections.property("subject")));
		return criteria.list();
	}

	@Override
	public int tableRowCount() throws Exception {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MarkDetail.class);
		return criteria.list().size();
	}

}
