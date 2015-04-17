package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class PraiseAction extends StrutsAction{
	
	private String id;
	
	public void praise() {
		ServiceContext.get(AxisService.class).praiseAxis(id);
	}

}
