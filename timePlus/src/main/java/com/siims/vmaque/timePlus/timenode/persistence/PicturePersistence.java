package com.siims.vmaque.timePlus.timenode.persistence;

import com.siims.framework.base.BasePersistence;
import com.siims.vmaque.timePlus.timenode.data.Picture;

public interface PicturePersistence extends BasePersistence<Picture> {
	
	public String create(String url, String desc);

}
