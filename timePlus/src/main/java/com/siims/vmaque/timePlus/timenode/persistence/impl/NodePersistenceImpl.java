package com.siims.vmaque.timePlus.timenode.persistence.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.siims.framework.base.BaseDao;
import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.vmaque.timePlus.timeaxis.data.Axis;
import com.siims.vmaque.timePlus.timeaxis.service.AxisService;
import com.siims.vmaque.timePlus.timenode.data.Node;
import com.siims.vmaque.timePlus.timenode.persistence.NodePersistence;
import com.siims.vmaque.timePlus.timenode.service.NodeService;

@Singleton
@AutoBind(bindClass=NodePersistence.class)
public class NodePersistenceImpl implements NodePersistence {

	private final BaseDao hibernatedao;
	
	@Inject
	protected NodePersistenceImpl(@Named("hibernateDao") BaseDao hibernate) {
		this.hibernatedao = hibernate;
	}
	
	@Override
	public String create(String axisId, String name, String content) {
		// TODO Auto-generated method stub
		Node node = new Node(name, content);
		Axis axis = ServiceContext.get(AxisService.class).getAxisById(axisId);
		axis.getNodes().add(node);
		hibernatedao.update(null, axis);
		return node.getId();
	}

	@Override
	public void delete(String axisId, String id) {
		// TODO Auto-generated method stub
		Axis axis = (Axis) hibernatedao.queryData("from Axis a where a.id = "+axisId, null);
		Node node = (Node)hibernatedao.queryData("from Node n where n.id ="+id, null);
		if (axis.getNodes().contains(node)) {
			axis.getNodes().remove(node);
		}
		hibernatedao.update(null, axis);
	}

	@Override
	public Node getNodeById(String id) {
		// TODO Auto-generated method stub
		return (Node) hibernatedao.queryData("from Node n where n.id = "+id, Node.class);
	}

}
