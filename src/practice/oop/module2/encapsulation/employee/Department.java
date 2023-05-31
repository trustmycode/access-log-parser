package practice.oop.module2.encapsulation.employee;

public class Department {

  private final String departmentName;
  private Employee chief;

  public Department(String departmentName) {
    this.departmentName = departmentName;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public Employee getChief() {
    return chief;
  }

  public void setChief(Employee chief) {
    if (chief.getDepartment().getDepartmentName().equals(departmentName)) {
      this.chief = chief;
      chief.setDepartment(this);
    } else {
      throw new IllegalArgumentException("The name of the chief's department and the department to be changed must be the same");
    }
  }

  @Override
  public String toString() {
    return "Отдел " + departmentName + ". Начальник отдела " + chief.getFirstname();
  }
}
