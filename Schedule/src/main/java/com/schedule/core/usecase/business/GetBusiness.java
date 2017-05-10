package com.schedule.core.usecase.business;

import com.schedule.core.entity.Business;

public interface GetBusiness {
	Business find(String businessName);
	Business find(Long id);
}
