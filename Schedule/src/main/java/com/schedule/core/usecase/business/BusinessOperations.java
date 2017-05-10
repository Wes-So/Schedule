package com.schedule.core.usecase.business;


import com.schedule.core.entity.Business;

public class BusinessOperations {
	private CreateBusiness createBusiness;
	private GetBusiness getBusiness;
	

	public BusinessOperations(CreateBusiness createBusiness,GetBusiness getBusiness){
		this.createBusiness = createBusiness;
		this.getBusiness = getBusiness;
	}
	
	public Business find(String businessName){
		return getBusiness.find(businessName);
	}
	
	public Business find(long id) { 
		return getBusiness.find(id);
	}	
	
	public boolean isBusinessExists(String businessName){
		return find(businessName) != null ? true:false;
	}
	
	public boolean isBusinessExists(long id){
		return find(id) != null ? true:false;
	}
	
	public void createBusiness(Business business){
		
		if(isBusinessExists(business.getName()))
			throw new BusinessExistsException();
		
		createBusiness.execute(business);
	}

	public void updateBusiness(Business business) {
		// TODO Auto-generated method stub
		
	}


	
	

}
