package com.siims.vmaque.timePlus.timenode.service.impl;

import com.google.inject.Singleton;
import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.vmaque.timePlus.timenode.business.NodeBusiness;
import com.siims.vmaque.timePlus.timenode.data.Node;
import com.siims.vmaque.timePlus.timenode.service.NodeService;

@Singleton
@AutoBind(bindClass=NodeService.class)
public class NodeServiceImpl implements NodeService{

	@Override
	public String create(String axisId, String name, String content) {
		// TODO Auto-generated method stub
		return ServiceContext.get(NodeBusiness.class).create(axisId, name, content);
	}

	@Override
	public void delete(String axisId, String id) {
		// TODO Auto-generated method stub
		ServiceContext.get(NodeBusiness.class).delete(axisId, id);
	}

	@Override
	public Node getNodeById(String id) {
		// TODO Auto-generated method stub
		return ServiceContext.get(NodeBusiness.class).getNodeById(id);
	}

}
