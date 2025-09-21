import java.util.Objects;
/* 1 Создайте класс Employee с информацией о Ф. И. О., отделе и зарплате сотрудника.
Для простоты назовите отделы от 1 до 5. Зарплату задайте в интервале 50–450.
Все поля объявлены с корректными типами (Ф. И. О. — string, отдел, зарплата и id — int).
Переданы поля Ф. И. О., отдел, зарплата.*/
public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private int department;
    private int salary;
    private int id;
/* 2 Добавьте статическую переменную-счетчик, которая будет отвечать за id.
Статическая переменная объявлена и инициализирована корректно, используется для генерации уникальных id.*/
    private static int idEmployee = 0;
/*3 Добавьте в класс Employee поле id. Оно переносится из счетчика, и затем счетчик увеличивает свое значение.
Все поля класса объявлены с модификатором private.*/
    public Employee() {
        this.id = ++idEmployee;
    }

    public Employee(String surname, String name, String patronymic, int department, int salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = ++idEmployee;
    }
/*4 Скройте прямой доступ к полям класса Employee, добавьте возможность получать значения полей (геттеры) и устанавливать
значения полей отдела и зарплаты(сеттеры). Геттеры реализованы для всех полей, сеттеры — для отдела и зарплаты.*/
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
/*5 Реализуйте в классе Employee контракт equals. Для бухгалтерского учета сравнение должно проходить только по значению зарплаты.
Метод equals переопределен, сравнивает только зарплату, корректно обрабатывает null и разные типы.*/
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
/*6 Реализуйте в классе Employee методы вывода информации о сотруднике. Вывод всех данных — через переопределение метода
toString, вывод только имени и зарплаты — через вызов System.out.println в отдельном методе public void printShortInfo().
По умолчанию все поля, кроме id, должны передаваться через конструктор. Также все поля (включая id, который нужно
получить из счетчика) должны заполняться в конструкторе. Метод toString выводит все поля в читаемом и структурированном формате.
Метод printShortInfo() реализован корректно, выводит Ф. И. О. и зарплату в читаемом и структурированном формате.*/
    @Override
    public String toString() {
        return "Сотрудник № " + id + ": ФИО " + surname + " " + name + " " + patronymic + " работает в отделе №" +
                department + " и получает зарплату " + salary + " рублей в месяц.";
    }
    public void printShortInfo() {
                    System.out.println("Сотрудник по имени " + name + " получает зарплату " + salary + " рублей в месяц.");
    }
}