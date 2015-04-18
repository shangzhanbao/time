package com.siims.vmaque.timePlus.timenode.persistence.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.siims.framework.base.BaseDao;
import com.siims.framework.ioc.guice.annotation.AutoBind;
import com.siims.vmaque.timePlus.timenode.data.Picture;
import com.siims.vmaque.timePlus.timenode.persistence.PicturePersistence;

@Singleton
@AutoBind(bindClass=PicturePersistence.class)
public class PicturePersistenceImpl implements PicturePersistence{

	private final BaseDao hibernatedao;
	
	@Inject
	protected PicturePersistenceImpl(@Named("hibernateDao") BaseDao hibernate) {
		this.hibernatedao = hibernate;
	}
	
	@Override
	public String create(String url, String desc) {
		// TODO Auto-generated method stub
		Picture picture = new Picture(url, desc);
		hibernatedao.insert(null, picture);
		return picture.getId();
	}

}
