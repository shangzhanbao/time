package com.siims.vmaque.timePlus.timeaxis.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class CreateAction extends StrutsAction{

	private static final long serialVersionUID = 12121221L;
	
	private String name;
	private String advertisement;
	private String userId;
	private String axisId;
	
	public String create() {
		axisId =  ServiceContext.get(AxisService.class).createAxis(name, advertisement, userId);
		return "success";
	}
}
