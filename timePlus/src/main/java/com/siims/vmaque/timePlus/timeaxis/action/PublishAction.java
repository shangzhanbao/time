package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class PublishAction extends StrutsAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1212121L;
	
	private String id;
	
	public void publish() {
		ServiceContext.get(AxisService.class).publishAxis(id);
	}
}
