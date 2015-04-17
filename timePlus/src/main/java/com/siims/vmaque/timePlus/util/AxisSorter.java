package com.siims.vmaque.timePlus.util;

import java.util.Comparator;

import com.siims.vmaque.timePlus.timeaxis.data.Axis;

public class AxisSorter implements Comparator<Axis>  {

	@Override
	public int compare(Axis o1, Axis o2) {
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
