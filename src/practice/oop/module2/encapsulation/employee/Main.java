package practice.oop.module2.encapsulation.employee;

public class Main {

  public static void main(String[] args) {
    Employee chief = new Employee("Anton");
    Employee employee = new Employee("Gleb");
    Employee chief1 = new Employee("Alexandra");
    Employee employee2 = new Employee("Vladislav");
    Employee chief2 = new Employee("Sergey");
    Employee employee4 = new Employee("Inessa");
    Employee employee5 = new Employee("Roman");
    Employee employee6 = new Employee("Anastasiya");
    Department department = new Department("QA");
    Department department1 = new Department("APIVNRZR");
    Department department2 = new Department("APIRB");
    chief.setDepartment(department);
    chief1.setDepartment(department2);
    chief2.setDepartment(department1);
    department.setChief(chief);
    department1.setChief(chief2);
    department2.setChief(chief1);
    employee.setDepartment(department1);
    employee2.setDepartment(department);
    employee4.setDepartment(department2);
    employee5.setDepartment(department);
    employee6.setDepartment(department1);
    System.out.println(employee);
    System.out.println(employee2);
    System.out.println(employee4);
    System.out.println(employee5);
    System.out.println(employee6);
    System.out.println(department);
    System.out.println(department1);
    System.out.println(department2);
    System.out.println(chief);
    System.out.println(chief1);
    System.out.println(chief2);
  }

}
