package com.siims.vmaque.timePlus.util;

import java.util.Comparator;

import com.siims.vmaque.timePlus.timenode.data.Node;

public class NodeSorter implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
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
