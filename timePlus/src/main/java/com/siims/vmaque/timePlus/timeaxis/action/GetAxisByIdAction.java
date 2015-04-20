package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.data.Axis;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class GetAxisByIdAction extends StrutsAction{
			
	private Axis axis;
	
	public void getAxisById() {
		String id = request.getParameter("id");
		axis = ServiceContext.get(AxisService.class).getAxisById(id);
	}

	public Axis getAxis() {
		return axis;
	}

	public void setAxis(Axis axis) {
		this.axis = axis;
	}
	
}
