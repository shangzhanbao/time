package com.siims.vmaque.timePlus.timeaxis.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.mvc.struts.StrutsAction;
import com.siims.vmaque.timePlus.support.AxisInfo;
import com.siims.vmaque.timePlus.timeaxis.data.Axis;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;
import com.siims.vmaque.timePlus.util.AxisSorter;

public class GetAllAxisAction extends StrutsAction{
	
	private List<AxisInfo> infos = new ArrayList<AxisInfo>();
	
	public void getAllAxis() {
		String userId = request.getParameter("userId");
		List<Axis> axis =  ServiceContext.get(AxisService.class).getAllAxis(userId);
		Collections.sort(axis, new AxisSorter());
		for (int i = 0; i < axis.size(); i++) {
			AxisInfo info = new AxisInfo(axis.get(i).getId(),axis.get(i).getName());
			infos.add(info);
		}
	}

	public List<AxisInfo> getInfos() {
		return infos;
	}

	public void setInfos(List<AxisInfo> infos) {
		this.infos = infos;
	}
	
}









