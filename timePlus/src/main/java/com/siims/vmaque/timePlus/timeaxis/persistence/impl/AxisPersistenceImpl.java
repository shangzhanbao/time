package com.siims.vmaque.timePlus.timeaxis.persistence.impl;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.siims.framework.base.BaseDao;
import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.vmaque.timePlus.timeaxis.data.Axis;
import com.siims.vmaque.timePlus.timeaxis.persistence.AxisPersistence;

@Singleton
@AutoBind(bindClass=AxisPersistence.class)
public class AxisPersistenceImpl implements AxisPersistence{

	private final BaseDao hibernatedao;
	
	@Inject
	protected AxisPersistenceImpl(@Named("hibernateDao") BaseDao hibernate) {
		this.hibernatedao = hibernate;
	}
	
	@Override
	public String createAxis(String name, String advertisement, String userId) {
		// TODO Auto-generated method stub
		Axis axis = new Axis(name,advertisement,userId);
		hibernatedao.insert(null, axis);
		return axis.getId();
	}

	@Override
	public void deleteAxis(String id) {
		// TODO Auto-generated method stub
		Axis axis = new Axis();
		axis.setId(id);
		hibernatedao.delete(null, axis);
	}

	@Override
	public void publishAxis(String id) {
		// TODO Auto-generated method stub
		Axis axis = (Axis)hibernatedao.queryData(id, Axis.class);
		axis.setIsPublished("1");
		hibernatedao.update(null, axis);
	}

	@Override
	public List<Axis> getAllAxis(String userId) {
		// TODO Auto-generated method stub
		List<Axis> list = hibernatedao.queryList("from Axis a where a.userId " +userId ,Axis.class);
		return list;
	}

	@Override
	public void praiseAxis(String id) {
		// TODO Auto-generated method stub
		Axis axis = new Axis("lgm", "lgm", "12123");
		axis.setId(id);
		axis.setPraiseNum(12);
		hibernatedao.update(null, axis);
	}

	@Override
	public String getAxisComputerUrl(String userId) {
		// TODO Auto-generated method stub
		Axis axis = (Axis)hibernatedao.queryData(userId, Axis.class);
		return axis.getUrlComputer();
	}

	@Override
	public String getAxisPhoneUrl(String userId) {
		// TODO Auto-generated method stub
		Axis axis = (Axis)hibernatedao.queryData(userId, Axis.class);
		return axis.getUrlPhone();
	}

	@Override
	public Axis getAxisById(String id) {
		// TODO Auto-generated method stub
		Axis axis = (Axis) hibernatedao.queryData(id, Axis.class);
		System.out.println(axis.getName());
		return axis;
	}
}
