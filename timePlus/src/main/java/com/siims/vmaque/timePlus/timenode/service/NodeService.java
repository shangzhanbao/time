package com.siims.vmaque.timePlus.timenode.service;

import com.siims.framework.base.BaseService;
import com.siims.vmaque.timePlus.timenode.data.Node;

public interface NodeService extends BaseService{

	public String create(String axisId, String name, String content);
	public void delete(String axisId, String id);
	public Node getNodeById(String id);
	
}
