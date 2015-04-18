package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class PraiseAction extends StrutsAction{
		
	public void praise() {
		String id = request.getParameter("id");
		ServiceContext.get(AxisService.class).praiseAxis(id);
	}

}