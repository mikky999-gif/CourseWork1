import java.util.Objects;

public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private int department;
    private int salary;
    private int id;
    private static int idEmployee = 0;

    public Employee(String surname, String name, String patronymic, int department, int salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = ++idEmployee;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public static int getIdEmployee() {
        return idEmployee;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(salary);
    }

    @Override
    public String toString() {
        return "Сотрудник № " + id + ": ФИО " + surname + " " + name + " " + patronymic + " работает в отделе №" +
                department + " и получает зарплату " + salary + " рублей в месяц.";
    }
    public void printShortInfo() {
                    System.out.println("Сотрудник по имени " + name + " получает зарплату " + salary + " рублей в месяц.");
    }
}