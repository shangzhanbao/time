package com.siims.vmaque.timePlus.timecomment.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timecomment.service.CommentService;

public class CreateAction extends StrutsAction{

	private String nodeId;
	private String content;
	
	public void create() {
		ServiceContext.get(CommentService.class).create(nodeId, content);
	}
}
