package com.siims.vmaque.timePlus.timenode.business.impl;

import com.google.inject.Singleton;
import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.vmaque.timePlus.timenode.business.PictureBusiness;
import com.siims.vmaque.timePlus.timenode.persistence.PicturePersistence;

@Singleton
@AutoBind(bindClass=PictureBusiness.class)
public class PictureBusinessImpl implements PicturePersistence {

	@Override
	public String create(String url, String desc) {
		// TODO Auto-generated method stub
		return ServiceContext.get(PicturePersistence.class).create(url, desc);
	}

}
