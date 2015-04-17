package com.siims.vmaque.timePlus.timecomment.business;

import com.siims.framework.base.BaseBusiness;
import com.siims.vmaque.timePlus.timecomment.data.Comment;

public interface CommentBusiness extends BaseBusiness {

	public String create(String nodeId ,String content);
	public Comment getCommentById(String id);
}
