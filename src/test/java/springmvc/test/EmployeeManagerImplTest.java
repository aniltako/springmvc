package springmvc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.matchers.Any;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spring.mvc.dao.EmployeeDao;
import com.spring.mvc.model.Employee;
import com.spring.mvc.service.EmployeeManagerImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeManagerImplTest {

	@Mock
	EmployeeDao dao;
	
	@InjectMocks
	EmployeeManagerImpl employeeManager;
	
	@Spy
	List<Employee> employees = new ArrayList<Employee>();
	
	@Captor
	ArgumentCaptor<Employee> captor;
	
	@BeforeClass
	public void setup(){
		MockitoAnnotations.initMocks(this);
		employees = getEmployeeList();
	}
	
	 /*
     * Scenario for Successful [error-free] data persistence
     * Void method stubbing example
     */
	@Test
	public void saveEmployee(){
		/**
		 * Instruct mockito to do nothing when dao.saveEmployee will be called.
		 */
//		Mockito.doNothing().when(dao).save(Mockito.any(Employee.class));
		Mockito.when(dao.save(Mockito.any(Employee.class))).thenReturn(Mockito.any(Employee.class));
		employeeManager.saveEmployee(employees.get(0));
		employeeManager.saveEmployee(employees.get(1));
		/**
		 * Verify that dao.saveEmplyee was indeed called two time.
		 */
		Mockito.verify(dao, Mockito.times(2)).save(captor.capture());
		
		/**
		 * Assert that dao.saveEmployee was called with a particular Employee, assert employee details
		 */
		Assert.assertEquals(captor.getAllValues().get(0).getName(), "Axel");
		Assert.assertEquals(captor.getAllValues().get(1).getName(), "Jeremy");
		Assert.assertEquals(2, employees.size());
		Mockito.verify(employees, Mockito.times(2)).add(Mockito.any(Employee.class));
		
	}
	
	/**
	 * Scenario for failed data persistence (due to existing user)
	 * void method stubbing example
	 */
	
	@Test(dependsOnMethods = { "saveEmployee" }, expectedExceptions = RuntimeException.class)
	public void saveExistingEmployee(){
		/**
		 * Instruct mockito to throw an exception when dao.saveEmployee will be called
		 */
		Mockito.doThrow(RuntimeException.class).when(dao).save(employees.get(0));
		employeeManager.saveEmployee(Mockito.any(Employee.class));
	}
	
	/**
	 * Scenaria for Successful data retrieval
	 * @return
	 */
	@Test(dependsOnMethods = { "saveEmployee" })
	public void findAllEmployees(){
		/**
		 * Instruct mockito to return pre-populated employees list whenever dao.findAllEmployees will be called.
		 */
		Mockito.when(dao.findAll()).thenReturn(employees);
		Assert.assertEquals(employeeManager.findAllEmployees(), employees);
//		Mockito.verify(dao, Mockito.times(1)).findAll();
	}
	
	/**
	 * Scenario for Successful data deletion
	 * Void method stubbing example
	 */
	
//	@Test(dependsOnMethods = { "saveEmployee" })
//	public void deleteEmployeeBySnn(){
//		/**
//		 * Instruct mockito to do nothing when dao.deletEmployeeBySnn will be called
//		 */
//		Mockito.doNothing().when(dao).deleteEmployeeBySsn(Mockito.anyString());
//		employeeManager.deleteEmployeeBySsn(Mockito.anyString());
//		Mockito.verify(dao, Mockito.times(1)).deleteEmployeeBySsn(Mockito.anyString());
//	}
	
	/**
	 * Scenaria for Failed data deletion (due to no employee found with given ssn)
	 * Void method stubbing example
	 */
	@Test(expectedExceptions = RuntimeException.class)
	public void deleteEmployeeBysnnNotExist(){
		/**
		 * Instruct mockito to throw an exception when dao.deleteEmployeeBySnn will be called.
		 */
		Mockito.doThrow(RuntimeException.class).when(dao).deleteEmployeeBySsn(Mockito.anyString());
		employeeManager.deleteEmployeeBySsn("XXXX");
		Mockito.verify(dao, Mockito.atLeastOnce()).deleteEmployeeBySsn(Mockito.anyString());
	}
	
	/**
	 * Same as above test case, demostrates 'doAnswer().when' pattern
	 * Void method stubbing example
	 */
//	@Test(dependsOnMethods = { "saveEmployee" }, expectedExceptions = RuntimeException.class)
//	public void deleteEmployeeBySsnNotExitAgain(){
//		/**
//		 * Alternate way to Instruct mockito to throw an exception when dao.deleteEmployeeBySsn will be called.
//		 */
//		Mockito.doAnswer(new Answer<Object>() {
//
//			@Override
//			public Object answer(InvocationOnMock invocation) throws Throwable {
//				Object[] args = invocation.getArguments();
//				String arg = (String)args[0];
//				if(arg.equals("UNKNOWN_SSN")){
//					throw new RuntimeException("Item not present");
//				}
//				return null;
//			}
//			
//		}).when(dao).deleteEmployeeBySsn(Mockito.anyString());
//		employeeManager.deleteEmployeeBySsn("UNKNOWN_SSN");
//		Mockito.verify(dao, Mockito.atLeastOnce()).deleteEmployeeBySsn(Mockito.anyString());
//	}
	 /*
     * Simple data provider method
     */
    public List<Employee> getEmployeeList() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Axel");
        e1.setSsn("11111");
 
        Employee e2 = new Employee();
        e1.setId(2);
        e2.setName("Jeremy");
        e2.setSsn("11112");
 
        employees.add(e1);
        employees.add(e2);
        return employees;
    }
    
    
    @Test
    public void getEmployee(){
    	Mockito.when(dao.findAll()).thenReturn(employees);
		Assert.assertEquals(employeeManager.findAllEmployees(), employees);
    }
}
