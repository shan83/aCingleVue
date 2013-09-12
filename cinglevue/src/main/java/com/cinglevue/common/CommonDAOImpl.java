package com.cinglevue.common;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cinglevue.util.CingleVueConstant;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Repository(value = "commonDAO")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CommonDAOImpl implements CommonDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CommonDAOImpl(){}

	public CommonDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public <Entity> long createEntity(Entity entity) {
		Object obj=sessionFactory.getCurrentSession().save(entity);
		if(!(obj==null))
		return (Long) obj;
		return 0;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public <Entity> String deleteEntity(Entity entity) {

		sessionFactory.getCurrentSession().delete(entity);

		return "success";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public <Entity> Entity getEntityById(Class classz, long id) {

		return (Entity) sessionFactory.getCurrentSession().get(classz, id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public <Entity> Entity loadEntityById(Class classz, long id) {
		return (Entity) sessionFactory.getCurrentSession().load(classz, id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public <Entity> String updateEntity(Entity entity) {
		sessionFactory.getCurrentSession().update(entity);
		return CingleVueConstant.SUCCESS;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public <Entity> String saveOrUpdateEntity(Entity entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return CingleVueConstant.SUCCESS;
	}
	
}
