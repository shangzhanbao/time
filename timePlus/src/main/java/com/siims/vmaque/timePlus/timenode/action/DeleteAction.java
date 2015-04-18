package com.siims.vmaque.timePlus.timenode.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timenode.service.NodeService;

public class DeleteAction extends StrutsAction{
	
	public void delete() {
		String axisId = request.getParameter("axisId");
		String id = request.getParameter("id");
		ServiceContext.get(NodeService.class).delete(axisId, id);
	}
}
