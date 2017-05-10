package com.schedule.core.usecase.business;


import com.schedule.core.entity.Business;

public class BusinessOperations {
	private BusinessDao businessDao;	

	public BusinessOperations(BusinessDao businessDao){
		this.businessDao = businessDao;
	}
	
	public void createBusiness(Business business){		
		if(isBusinessExists(business.getName()))
			throw new BusinessExistsException();
		
		businessDao.create(business);
	}

	public void updateBusiness(Business business) {		
		if(!isBusinessExists(business.getId()))
			throw new BusinessNotExistingException();
		
		businessDao.update(business);
	}
	
	public Business find(String businessName){
		return businessDao.find(businessName);
	}
	
	public Business find(long id) { 
		return businessDao.find(id);
	}	
	
	public boolean isBusinessExists(String businessName){
		return find(businessName) != null ? true:false;
	}
	
	public boolean isBusinessExists(long id){
		System.out.println(find(id));
		return find(id) != null ? true:false;
	}	

}
