package com.siims.vmaque.timePlus.timenode.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timenode.service.NodeService;

public class DeleteAction extends StrutsAction{

	private String axisId;
	private String id;
	
	public void delete() {
		ServiceContext.get(NodeService.class).delete(axisId, id);
	}
}
