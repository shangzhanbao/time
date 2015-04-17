package com.siims.vmaque.timePlus.timeaxis.business;

import java.util.List;

import com.siims.framework.base.BaseBusiness;
import com.siims.vmaque.timePlus.timeaxis.data.Axis;

public interface AxisBusiness extends BaseBusiness {

	public String createAxis(String name, String advertisement, String userId);
	public void deleteAxis(String id);
	public void publishAxis(String id);
	public List<Axis> getAllAxis(String userId);
	public void praiseAxis(String id);
	public String getAxisComputerUrl(String userId);
	public String getAxisPhoneUrl(String userId);
	public Axis getAxisById(String id);
}
