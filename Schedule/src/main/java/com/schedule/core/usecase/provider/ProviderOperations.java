package com.schedule.core.usecase.provider;

import java.util.List;

import com.schedule.core.entity.Provider;
import com.schedule.core.entity.Schedule;

public class ProviderOperations {
	
	private ProviderDao providerDao;
	
	public ProviderOperations(ProviderDao providerDao){
		this.providerDao = providerDao;
	}

	public void addProvider(Provider provider) {
		providerDao.create(provider);		
	}

	public void updateProvider(Provider provider) {
		providerDao.update(provider);		
	}

	public void setAvailableSchedules(Provider provider, List<Schedule> schedules) {
		// TODO Auto-generated method stub
		
	}

}
