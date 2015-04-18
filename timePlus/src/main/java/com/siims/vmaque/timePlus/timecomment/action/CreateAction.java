package com.siims.vmaque.timePlus.timecomment.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timecomment.service.CommentService;

public class CreateAction extends StrutsAction{
	
	public void create() {
		String nodeId = request.getParameter("nodeId");
		String content = request.getParameter("content");
		ServiceContext.get(CommentService.class).create(nodeId, content);
	}
}
