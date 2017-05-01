package com.rahul.spring.jdbctemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		EmpDao empDao = context.getBean("empdao",EmpDao.class);
		
		//boolean res = empDao.insertDataUsingPreparedStatement(new Emp(1,"1984-10-30","Rahul","Sahukar","M","2006-05-19"));
		//int res = empDao.updateData("Rahul");
		
		//List<Emp> empList = empDao.selectAllEmployees();
		List<Emp> empList = empDao.selectAllEmployeesMapper();
		for(Emp emp: empList){
			System.out.println(emp.toString());
		}
		
		//System.out.println(res);

	}

}
