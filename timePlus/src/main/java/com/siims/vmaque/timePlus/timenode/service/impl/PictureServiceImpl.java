package com.siims.vmaque.timePlus.timenode.service.impl;

import com.google.inject.Singleton;
import com.siims.framework.ioc.ServiceContext;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.vmaque.timePlus.timenode.business.PictureBusiness;
import com.siims.vmaque.timePlus.timenode.service.PictureService;

@Singleton
@AutoBind(bindClass=PictureService.class)
public class PictureServiceImpl implements PictureService{

	@Override
	public String create(String url, String desc) {
		// TODO Auto-generated method stub
		return ServiceContext.get(PictureBusiness.class).create(url, desc);
	}
}
