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
		Axis axis = (Axis) hibernatedao.queryData("from Axis a where a.id = "+id, null);
		hibernatedao.delete(null, axis);
	}

	@Override
	public void publishAxis(String id) {
		// TODO Auto-generated method stub
		Axis axis = (Axis)hibernatedao.queryData("from Axis a where a.id = "+id, null);
		axis.setIsPublished("1");
		hibernatedao.update(null, axis);
	}

	@Override
	public List<Axis> getAllAxis(String userId) {
		// TODO Auto-generated method stub
		List<Axis> list = hibernatedao.queryList("from Axis a where a.userId " +userId ,null);
		return list;
	}

	@Override
	public void praiseAxis(String id) {
		// TODO Auto-generated method stub
		Axis axis = (Axis) hibernatedao.queryData("from Axis a where a.id = "+id, null);
		axis.setPraiseNum(axis.getPraiseNum()+1);
		hibernatedao.update(null, axis);
	}

	@Override
	public String getAxisComputerUrl(String userId) {
		// TODO Auto-generated method stub
		Axis axis = (Axis)hibernatedao.queryData("from Axis a where a.id = "+userId, null);
		return axis.getUrlComputer();
	}

	@Override
	public String getAxisPhoneUrl(String userId) {
		// TODO Auto-generated method stub
		Axis axis = (Axis)hibernatedao.queryData("from Axis a where a.id = "+userId, null);
		return axis.getUrlPhone();
	}

	@Override
	public Axis getAxisById(String id) {
		// TODO Auto-generated method stub
		return (Axis) hibernatedao.queryData("from Axis a where a.id = "+id, null);
	}
}
