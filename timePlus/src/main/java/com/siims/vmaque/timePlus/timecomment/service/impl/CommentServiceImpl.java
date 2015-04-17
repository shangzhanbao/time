package com.siims.vmaque.timePlus.timecomment.service.impl;

import com.google.inject.Singleton;
import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.vmaque.timePlus.timecomment.business.CommentBusiness;
import com.siims.vmaque.timePlus.timecomment.data.Comment;
import com.siims.vmaque.timePlus.timecomment.service.CommentService;

@Singleton
@AutoBind(bindClass=CommentService.class)
public class CommentServiceImpl implements CommentService {

	@Override
	public String create(String nodeId, String content) {
		// TODO Auto-generated method stub
		return ServiceContext.get(CommentBusiness.class).create(nodeId, content);
	}

	@Override
	public Comment getCommentById(String id) {
		// TODO Auto-generated method stub
		return ServiceContext.get(CommentBusiness.class).getCommentById(id);
	}

}
