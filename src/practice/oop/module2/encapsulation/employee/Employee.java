package practice.oop.module2.encapsulation.employee;

public class Employee {

  private final String firstname;
  private Department department;

  public Employee(String firstname) {
    this.firstname = firstname;
  }

  public String getFirstname() {
    return firstname;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    if (this == department.getChief()) {
      return firstname + " является начальником отдела " + department.getDepartmentName();
    } else if (department.getChief() == null) {
      department.setChief(this);
      return firstname + " является начальником отдела " + department.getDepartmentName();
    } else {
      return firstname + " работает в отделе "
          + department.getDepartmentName() + ", начальник которого "
          + department.getChief().getFirstname();
    }
  }
}
