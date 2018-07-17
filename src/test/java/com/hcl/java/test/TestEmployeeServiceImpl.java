package com.hcl.java.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.hcl.java.entity.Employee;
import com.hcl.java.exception.EmployeeException;
import com.hcl.java.service.IEmployeeService;
import com.hcl.java.service.impl.EmployeeServiceImpl;

public class TestEmployeeServiceImpl {

	private static ApplicationContext context = null;
	
	private IEmployeeService empService = null;
	private static final Logger logger = LogManager.getLogger(TestEmployeeServiceImpl.class);

	@BeforeEach
	void setUp() throws Exception {
		empService = new EmployeeServiceImpl();
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		empService = context.getBean("empBean", IEmployeeService.class);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		empService = null;
	}

	@Test
	void testSaveEmployee() {
		Employee emp = new Employee();
		emp.setEmployeeId(1);
		emp.setFirstName("John");
		emp.setLastName("Doe");
		emp.setEmail("johndoe@gmail.com");
		try {
			empService.saveEmployee(emp);
			assertEquals(empService.getEmployee(1).getFirstName(), emp.getFirstName());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testGetEmployee() {
		Integer id = 1;
		try {
			Employee emp = empService.getEmployee(id);
			assertEquals("Harsha", emp.getFirstName());
		} catch (EmployeeException e) {
			logger.debug("Employee not found with id: " + id);
			e.printStackTrace();
		}
	}

	@Test
	void testGetAllEmployees() {
		try {
			List<Employee> emp = empService.getAllEmployees();
			assertTrue(!emp.isEmpty());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testAddAllEmployee() {
		Employee emp = new Employee("demo1", "demolast1", "demo123@gmail.com");
		Employee emp2 = new Employee("demo2", "demolast2", "demo234@gmail.com");
		Employee emp3 = new Employee("demo3", "demolast3", "demo345@gmail.com");
		Employee emp4 = new Employee("demo4", "demolast4", "demo456@gmail.com");
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		
		try {
			empService.addAllEmployee(empList);
			empService.getAllEmployees();
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testDeleteEmployee() {
		Integer id = 1;

		try {
			empService.deleteEmployee(id);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateEmployee() {
		Employee emp = new Employee();
		emp.setEmployeeId(1);
		emp.setFirstName("UpdatedFirstName");
		emp.setLastName("UpdatedLastName");
		emp.setEmail("demo@gmail.com");
		try {
			empService.updateEmployee(emp);
			assertEquals(empService.getEmployee(1).getFirstName(), emp.getFirstName());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
