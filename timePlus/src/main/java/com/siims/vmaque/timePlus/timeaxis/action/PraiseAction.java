package com.siims.vmaque.timePlus.timeaxis.action;

import java.io.IOException;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;

public class PraiseAction extends StrutsAction{
			
	public void praise() {
		String id = request.getParameter("id");
		ServiceContext.get(AxisService.class).praiseAxis(id);
		try {
			response.setContentType("application/text;charset=UTF-8"); 
			response.getWriter().write("this is test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}