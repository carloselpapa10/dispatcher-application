package com.example.dispatcher;

import com.example.dispatcher.Model.Employee;
import com.example.dispatcher.Model.EmployeeRepository;
import com.example.dispatcher.Model.EmployeeType;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DispatcherApplication {

	@Bean
	ApplicationRunner init(EmployeeRepository er){

		/*Esta aplicación inicia con 5 operadores, 3 supervisores y 1 director*/

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Op1", EmployeeType.OPERATOR));
		employeeList.add(new Employee("Op2", EmployeeType.OPERATOR));
		employeeList.add(new Employee("Op3", EmployeeType.OPERATOR));
		employeeList.add(new Employee("Op4", EmployeeType.OPERATOR));
		employeeList.add(new Employee("Op5", EmployeeType.OPERATOR));
		employeeList.add(new Employee("Sup1", EmployeeType.SUPERVISOR));
		employeeList.add(new Employee("Sup2", EmployeeType.SUPERVISOR));
		employeeList.add(new Employee("Sup3", EmployeeType.SUPERVISOR));
		employeeList.add(new Employee("Dir", EmployeeType.DIRECTOR));

		er.saveAll(employeeList);

		return null;
	}

	public static void main(String[] args) {
		SpringApplication.run(DispatcherApplication.class, args);
	}
}
