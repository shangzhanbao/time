package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.data.Axis;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class GetAxisById extends StrutsAction{
		
	private String id;
	
	private Axis axis;
	
	public void getAxisById() {
		axis = ServiceContext.get(AxisService.class).getAxisById(id);
	}
}
