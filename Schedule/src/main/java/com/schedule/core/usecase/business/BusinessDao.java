package com.schedule.core.usecase.business;

import com.schedule.core.entity.Business;

public interface BusinessDao {
	void create(Business business);
	void update(Business business);
	Business find(String businessName);
	Business find(Long id);
}
