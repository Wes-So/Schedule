package com.schedule.core.usecase.business;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.schedule.core.entity.Business;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;

public class BusinessOperationsTest { 
	private CreateBusiness createBusiness;
	private GetBusiness getBusiness;
	private BusinessOperations businessOperations;
	private Business business;
	
	@Before
	public void setup(){
		createBusiness = mock(CreateBusiness.class);
		business = new Business("Test");		
		getBusiness = mock(GetBusiness.class);
		businessOperations = new BusinessOperations(createBusiness,getBusiness);
	}

	@Test
	public void initializeWithCreateInterface() {		 
		assertNotNull(new BusinessOperations(createBusiness,getBusiness));
	}
	
	@Test
	public void findBusinessByNameThatExists(){		
		Business expected = givenABusinessIsFound();
		Business actual = businessOperations.find("Test");
        assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void findBusinessByNameThatIsNonExistent(){		
		givenABusinessIsNotFound();
		Business actual = businessOperations.find("Test");
        assertThat(actual).isEqualTo(null);
	}
	
	@Test
	public void findBusinessByIdThatExists(){
		Business expected = givenABusinessIsFound();
		Business actual = businessOperations.find(1L);
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void createAnExistingBusiness(){
		givenABusinessIsFound();
		businessOperations.createBusiness(new Business("test"));
		assertThatExceptionOfType(BusinessExistsException.class).isThrownBy(() -> businessOperations.createBusiness(business));
	}
	
	@Test
	public void createBusiness(){
		givenABusinessIsNotFound();
		businessOperations.createBusiness(business);
		Mockito.verify(createBusiness,atLeastOnce()).execute(business);
	}
	
	
	
	@Test
	public void updateNonExistingBusiness(){
		givenABusinessIsNotFound();
		businessOperations.updateBusiness(business);
		
	}
	
	
    private Business givenABusinessIsFound() {
        Business expected = new Business("Test");
        when(getBusiness.find("Test")).thenReturn(expected);
        return expected;
    }
    
    private void givenABusinessIsNotFound() { 
        when(getBusiness.find(anyString())).thenReturn(null);        
    }
}
