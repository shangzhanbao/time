package com.siims.vmaque.timePlus.timecomment.service;

import com.siims.framework.base.BaseService;
import com.siims.vmaque.timePlus.timecomment.data.Comment;

public interface CommentService extends BaseService {

	public String create(String nodeId ,String content);
	public Comment getCommentById(String id);
	
}
