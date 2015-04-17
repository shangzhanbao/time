package com.siims.vmaque.timePlus.util;

import java.util.Comparator;

import com.siims.vmaque.timePlus.timenode.data.Picture;

public class PicSorter implements Comparator<Picture> {

	@Override
	public int compare(Picture o1, Picture o2) {
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
