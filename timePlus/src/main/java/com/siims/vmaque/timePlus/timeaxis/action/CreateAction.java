package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class CreateAction extends StrutsAction{
	
	private String axisId;
	
	public String create() {
		String name = request.getParameter("name");
		String advertisement = request.getParameter("advertisement");
		String userId = request.getParameter("userId");
		axisId =  ServiceContext.get(AxisService.class).createAxis(name, advertisement, userId);
		return "success";
	}

	public String getAxisId() {
		return axisId;
	}

	public void setAxisId(String axisId) {
		this.axisId = axisId;
	}
	
	
}
