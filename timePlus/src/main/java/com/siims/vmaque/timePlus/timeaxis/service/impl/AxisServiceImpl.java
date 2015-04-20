package com.siims.vmaque.timePlus.timeaxis.service.impl;

import java.util.List;

import com.google.inject.Singleton;
import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.framework.transaction.TransactionalContext;
import com.siims.vmaque.timePlus.timeaxis.business.AxisBusiness;
import com.siims.vmaque.timePlus.timeaxis.data.Axis;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

@Singleton
@AutoBind(bindClass=AxisService.class)
@TransactionalContext
public class AxisServiceImpl implements AxisService {

	@Override
	public String createAxis(String name, String advertisement, String userId) {
		// TODO Auto-generated method stub
		return ServiceContext.get(AxisBusiness.class).createAxis(name, advertisement, userId);
	}

	@Override
	public void deleteAxis(String id) {
		// TODO Auto-generated method stub
		ServiceContext.get(AxisBusiness.class).deleteAxis(id);
	}

	@Override
	public void publishAxis(String id) {
		// TODO Auto-generated method stub
		ServiceContext.get(AxisBusiness.class).publishAxis(id);
	}

	@Override
	public List<Axis> getAllAxis(String userId) {
		// TODO Auto-generated method stub
		return ServiceContext.get(AxisBusiness.class).getAllAxis(userId);
	}

	@Override
	public void praiseAxis(String id) {
		// TODO Auto-generated method stub
		ServiceContext.get(AxisBusiness.class).praiseAxis(id);;
	}

	@Override
	public String getAxisComputerUrl(String userId) {
		// TODO Auto-generated method stub
		return ServiceContext.get(AxisBusiness.class).getAxisComputerUrl(userId);
	}

	@Override
	public String getAxisPhoneUrl(String userId) {
		// TODO Auto-generated method stub
		return ServiceContext.get(AxisBusiness.class).getAxisPhoneUrl(userId);
	}
	
	public Axis getAxisById(String id) {
		// TODO Auto-generated method stub
		return ServiceContext.get(AxisBusiness.class).getAxisById(id);
	}
}
