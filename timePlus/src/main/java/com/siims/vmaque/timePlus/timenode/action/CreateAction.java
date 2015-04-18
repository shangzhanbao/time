package com.siims.vmaque.timePlus.timenode.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timenode.service.NodeService;

public class CreateAction extends StrutsAction{

	private String nodeId;
	
	public void create() {
		String axisId = request.getParameter("axisId");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		nodeId = ServiceContext.get(NodeService.class).create(axisId, name, content);
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
}
