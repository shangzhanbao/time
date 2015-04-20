package com.siims.vmaque.timePlus.timecomment.persistence.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.siims.framework.base.BaseDao;
import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.vmaque.timePlus.timecomment.data.Comment;
import com.siims.vmaque.timePlus.timecomment.persistence.CommentPersistence;
import com.siims.vmaque.timePlus.timenode.data.Node;
import com.siims.vmaque.timePlus.timenode.service.NodeService;

@Singleton
@AutoBind(bindClass=CommentPersistence.class)
public class CommentPersistenceImpl implements CommentPersistence{

	private final BaseDao hibernatedao;
	
	@Inject
	protected CommentPersistenceImpl(@Named("hibernateDao") BaseDao hibernate) {
		this.hibernatedao = hibernate;
	}
	
	@Override
	public String create(String nodeId, String content) {
		// TODO Auto-generated method stub
		Comment comment = new Comment(content);
		Node node = ServiceContext.get(NodeService.class).getNodeById(nodeId);
		node.getComments().add(comment);
		hibernatedao.update(null, node);
		return comment.getId();
	}

	@Override
	public Comment getCommentById(String id) {
		// TODO Auto-generated method stub
		return (Comment) hibernatedao.queryData("from Comment c where c.id = "+id, Comment.class);
	}

}
