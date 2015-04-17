package com.siims.vmaque.timePlus.util;

import java.util.Comparator;

import com.siims.vmaque.timePlus.timecomment.data.Comment;

public class CommentSorter implements Comparator<Comment> {

	@Override
	public int compare(Comment o1, Comment o2) {
		// TODO Auto-generated method stub
		if (o1.getTime().after(o2.getTime())) {
			return -1;
		}else if (o1.getTime().before(o2.getTime())) {
			return 1;
		}else {
			return 0;
		}
	}

}
