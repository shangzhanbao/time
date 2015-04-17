package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class DeleteAction extends StrutsAction{
	
	private static final long serialVersionUID = 1212122221L;
	
	private String id;
	
	public void delete() {
		ServiceContext.get(AxisService.class).deleteAxis(id);
	}

}
