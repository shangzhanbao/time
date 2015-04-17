package com.siims.vmaque.timePlus.timenode.persistence;

import com.siims.framework.base.BasePersistence;
import com.siims.vmaque.timePlus.timenode.data.Node;

public interface NodePersistence extends BasePersistence<Node> {

	public String create(String axisId, String name, String content);
	public void delete(String axisId, String id);
	public Node getNodeById(String id);
}
