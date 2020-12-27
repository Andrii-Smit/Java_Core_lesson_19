package task1;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File fileEmployee = new File("Employee.obj");
		Employee employee = new Employee(23, "Вася", 7500);
		System.out.println("Наш работник:");
		System.out.println(employee);

		System.out.println("Наш работник после сериализации/десереализации:");
		Methods.serialize(employee, fileEmployee);
		System.out.println(Methods.deserealize(fileEmployee));

		System.out.println();

		File fileEmployeeList = new File("EmployeeList.obj");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		employeeList.add(new Employee(57, "Влад", 12500));
		employeeList.add(new Employee(72, "Виталий", 28500));
		employeeList.add(new Employee(84, "Валентин", 10250));
		employeeList.add(new Employee(89, "Ольга", 5750));
		employeeList.add(new Employee(95, "Яна", 9200));

		System.out.println("Список наших работников:");
		for (Employee eachEmployee : employeeList) {
			System.out.println(eachEmployee);
		}

		System.out.println();

		System.out.println("Список наших работников после сериализации/десереализации:");
		Methods.serialize((Serializable) employeeList, fileEmployeeList);

		List<Employee> employeeListDeserialized = new ArrayList<Employee>();
		employeeListDeserialized = (List<Employee>) Methods.deserealize(fileEmployeeList);

		for (Employee eachEmployee : employeeListDeserialized) {
			System.out.println(eachEmployee);
		}

	}

}
