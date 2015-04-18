package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class DeleteAction extends StrutsAction{
		
	public void delete() {
		String id = request.getParameter("id");
		ServiceContext.get(AxisService.class).deleteAxis(id);
	}

}
