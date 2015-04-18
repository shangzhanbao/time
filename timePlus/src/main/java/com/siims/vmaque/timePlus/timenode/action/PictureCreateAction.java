package com.siims.vmaque.timePlus.timenode.action;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timenode.service.PictureService;

public class PictureCreateAction extends StrutsAction{

	private String picId;
	
    public void picCreate() {
		String url = request.getParameter("url");
		String desc = request.getParameter("desc");
		picId = ServiceContext.get(PictureService.class).create(url, desc);
	}

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}
}
