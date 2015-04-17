package com.siims.vmaque.timePlus.timecomment.persistence;

import com.siims.framework.base.BasePersistence;
import com.siims.vmaque.timePlus.timecomment.data.Comment;

public interface CommentPersistence extends BasePersistence<Comment>{

	public String create(String nodeId ,String content);
	public Comment getCommentById(String id);
}
