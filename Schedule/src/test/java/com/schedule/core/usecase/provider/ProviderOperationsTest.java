package com.schedule.core.usecase.provider;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.schedule.core.entity.ContactInfo;
import com.schedule.core.entity.Provider;

public class ProviderOperationsTest {
	
	private ProviderDao providerDao;
	private ProviderOperations providerOps;
	private Provider provider;
	
	@Before
	public void setUp(){
		providerDao =  mock(ProviderDao.class);
		providerOps = new ProviderOperations(providerDao);
		provider = createProvider();
	}

	@Test
	public void addANewProvider() { 		
		providerOps.addProvider(provider); 
		Mockito.verify(providerDao ,atLeastOnce()).create(provider);
	}
	
	@Test
	public void updateProvider(){		
		providerOps.updateProvider(provider);
		Mockito.verify(providerDao ,atLeastOnce()).update(provider);
	}	

//	
//	private List<Schedule> createSchedules(){
//		List<Schedule> schedules = new ArrayList<>();
//		for(int i = 0; i < 10; i++){
//			schedules.add(createSchedule());
//		}
//		return schedules;
//	}
//	
//	private Schedule createSchedule(){
//		Schedule schedule = new Schedule();		
//		return schedule;
//	}

	private Provider createProvider(){
		Provider provider = new Provider();
		ContactInfo contact = new ContactInfo("phone", "email");
		provider.setContactInfo(contact);
		
		return provider;
	}

}
