package practice.oop.demo;

public class Student {
    public void setNumOfClass(Integer numOfClass) {
        this.numOfClass = numOfClass;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public void setFirstTeacher(Teacher firstTeacher) {
        this.firstTeacher = firstTeacher;
    }

    private Integer numOfClass;
    private String nameOfStudent;
    private Teacher firstTeacher;

    // Конструктор, геттеры и сеттеры
    public Student(Integer numOfClass, String nameOfStudent, Teacher firstTeacher) {
        this.numOfClass = numOfClass;
        this.nameOfStudent = nameOfStudent;
        this.firstTeacher = firstTeacher;
    }

    public Integer getNumOfClass() {
        return numOfClass;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public Teacher getFirstTeacher() {
        return firstTeacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "numOfClass=" + numOfClass +
                ", nameOfStudent='" + nameOfStudent + '\'' +
                ", firstTeacher=" + firstTeacher +
                '}';
    }
}
