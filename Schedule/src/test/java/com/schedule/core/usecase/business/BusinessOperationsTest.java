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
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;

public class BusinessOperationsTest { 
	private BusinessDao businessDao;
	private BusinessOperations businessOperations;
	private Business business;
	
	@Before
	public void setup(){
		businessDao = mock(BusinessDao.class);
		business = new Business("Test");	
		businessOperations = new BusinessOperations(businessDao);
	}

	@Test
	public void initializeWithCreateInterface() {		 
		assertNotNull(new BusinessOperations(businessDao));
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
		Business expected = givenABusinessIsFoundById();
		Business actual = businessOperations.find(1L);
		assertThat(actual).isEqualTo(expected);
	}
	
	@Test
	public void createAnExistingBusiness(){
		givenABusinessIsFound();
		assertThatExceptionOfType(BusinessExistsException.class).isThrownBy(() -> businessOperations.createBusiness(business));
	}
	
	@Test
	public void createBusiness(){
		givenABusinessIsNotFound();
		businessOperations.createBusiness(business);
		Mockito.verify(businessDao,atLeastOnce()).create(business);
	}	
	
	@Test
	public void updateNonExistingBusiness(){
		givenABusinessIsNotFoundById();
		assertThatExceptionOfType(BusinessNotExistingException.class).isThrownBy(() -> businessOperations.updateBusiness(business));
	}
	
	@Test
	public void updateExistingBusiness(){
		givenABusinessIsFoundById();
		businessOperations.updateBusiness(business);
		Mockito.verify(businessDao,atLeastOnce()).update(business);
	}
	
	
    private Business givenABusinessIsFound() {
        Business expected = new Business("Test");
        when(businessDao.find("Test")).thenReturn(expected);
        return expected;
    }
    
    private Business givenABusinessIsFoundById() {
        Business expected = new Business("Test");
        when(businessDao.find(anyLong())).thenReturn(expected);
        return expected;
    }
    
    private void givenABusinessIsNotFound() { 
        when(businessDao.find(anyString())).thenReturn(null);        
    }
    
    private void givenABusinessIsNotFoundById() { 
        when(businessDao.find(anyLong())).thenReturn(null);        
    }
}
