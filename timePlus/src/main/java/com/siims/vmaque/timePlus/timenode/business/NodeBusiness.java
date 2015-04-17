package com.siims.vmaque.timePlus.timenode.business;

import com.siims.framework.base.BaseBusiness;
import com.siims.vmaque.timePlus.timenode.data.Node;

public interface NodeBusiness extends BaseBusiness{

	public String create(String axisId, String name, String content);
	public void delete(String axisId, String id);
	public Node getNodeById(String id);
}
