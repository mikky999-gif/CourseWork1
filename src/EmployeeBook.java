/*7 Создайте класс EmployeeBook c полем типа Employee[10], которое будет выполнять роль хранилища для записей о сотрудниках.
Массив объявлен и инициализирован как Employee[10].*/
public class EmployeeBook {
    private final Employee[] employees = new Employee[10];
    Employee employee;

    public void add(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }
/*8 Создайте методы класса EmployeeBook, которые будут взаимодействовать с массивом из пункта 7 и возвращать результат:
 Получить список всех сотрудников со всеми данными о них, вывести в консоль значения всех полей, кроме Null.
Используйте цикл for each и toString. Использован цикл for each, вызван метод toString и выведены все сотрудники
за исключением null.*/
    public void listAllEmployees() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.toString());
            }
        }
    }
/*Подсчитать среднее значение зарплат. В качестве количества сотрудников для подсчета среднего используйте количество
полей до первого null. Среднее значение рассчитано корректно, с делением на актуальное количество сотрудников.*/
    public void averageSalary() {
        double sum = 0;
        double count = 0;
        double av = 0;
        for (Employee e : employees) {
            if (e != null) {
                sum = sum + e.getSalary();
                count++;
            }
        }
        av = sum / count;
        System.out.println(av);
    }
/*Вывести значения налогов. Их можно считать по двум схемам: PROPORTIONAL и PROGRESSIVE. Если в метод передать строкой
тип расчета PROPORTIONAL, то налог всегда 13%. Если передать PROGRESSIVE, то налог рассчитывается по формуле: «13% для
зарплаты до 150, 17% для зарплаты до 350, 21% для зарплаты выше 350». Примените switch для выбора формулы расчета зарплаты.
Использован switch, все диапазоны покрыты, налоги вычислены и выведены корректно.*/
    public void calculateTax(String taxType) {
        for (Employee emp : employees) {
            if (emp != null) {
                double salary = emp.getSalary();
                double taxAmount = 0;

                switch (taxType.toUpperCase()) {
                    case "PROPORTIONAL":
                        taxAmount = salary * 0.13;
                        System.out.println("Налог для сотрудника " + emp.getSurname() + " составляет " + taxAmount + " рублей.");
                        break;
                    case "PROGRESSIVE":
                        if (salary <= 150) {
                            taxAmount = salary * 0.13;
                            System.out.println("Налог для сотрудника " + emp.getSurname() + " составляет " + taxAmount + " рублей.");
                        } else if (salary <= 350) {
                            taxAmount = salary * 0.17;
                            System.out.println("Налог для сотрудника " + emp.getSurname() + " составляет " + taxAmount + " рублей.");
                        } else {
                            taxAmount = salary * 0.21;
                            System.out.println("Налог для сотрудника " + emp.getSurname() + " составляет " + taxAmount + " рублей.");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Неправильно указан тип налогового режима");
                }
            }
        }
    }
/*Получить в качестве параметра номер отдела (1–5) и проиндексировать зарплату всех сотрудников отдела на процент,
который приходит в качестве параметра (то есть вызвать изменение зарплаты у всех сотрудников на величину аргумента в
процентах). Примените continue для пропуска сотрудников, зарплата которых не меняется. Использован continue, зарплата
сотрудников указанного отдела проиндексирована корректно.*/
    public void indexation (int enterDepartment) {
        double ind = 0;
        for (Employee dep : employees) {
            if (dep != null) {
                int d = dep.getDepartment();
                double s = dep.getSalary();
                if (d == enterDepartment) {
                    ind = 0.1;
                    s = s + s * ind;
                    System.out.println("Зарплата сотрудника " + dep.getSurname() + " после индексации составляет " + s + " рублей.");
                    continue;
                } else {
                    System.out.println("Сотруднику " + dep.getSurname() + " в этом году не положена индексация.");
                }
            }
        }
    }
/*Получить в качестве параметра номер отдела (1–5) и цифру зарплаты и вывести первого сотрудника этого отдела с
зарплатой больше указанной вместе с порядковым номером в списке. Используйте цикл for и оператор break для поиска.
В выводе используйте метод printShortInfo() из пункта 6. Использованы for и break, вызван printShortInfo, сотрудник
найден и выведен корректно.*/
public void findSalary(int enterSalaryToSearch) {
    for (int i = 0; i < employees.length; i++) {
        Employee depart = employees[i];
        if (depart != null) {
            int s = depart.getSalary();
            if (s > enterSalaryToSearch) {
                depart.printShortInfo();
                break;
            }
        }
    }
}
/*Получить в качестве параметра цифру зарплаты wage и число сотрудников employeeNumber и вывести первые employeeNumber
сотрудников с зарплатой меньше wage. Используйте для поиска цикл while и оператор break. Использованы while и break,
выведено корректное количество сотрудников с зарплатой ниже wage.*/
    public void findEmployeeNumber (int wage, int employeeNumber) {
        int count = 0;
        int ind = 0;

        while (count < employeeNumber && ind < employees.length) {
            Employee emp = employees[ind++];
            if (emp != null && emp.getSalary() < wage) {
                System.out.println("Номер сотрудника с зарплатой меньше " + wage + " : " + ind);
                emp.printShortInfo();
                count++;
                if (count == employeeNumber) {
                    break;
                }
            }
        }
    }
/*Получить в качестве параметра объект сотрудника и вернуть boolean, есть ли такой сотрудник в массиве с точки зрения
бухгалтерского учета (по зарплате) или нет. Сравнение проводится через equals. Метод equals корректно возвращает true
или false при сравнении, есть ли такой сотрудник в массиве с точки зрения бухгалтерского учета или нет.*/
    public boolean findEmployee(Employee sal) {
        for (Employee ex : employees) {
            if (ex != null && ex.equals(sal)) {
                return true;
            }
        }
        return false;
    }
/*9 Добавьте метод наполнения EmployeeBook: метод должен найти свободную ячейку в массиве и положить в нее данные нового
сотрудника. Поиск свободных ячеек происходит с начала массива. Если свободных мест для сотрудника нет, метод возвращает
false. Если для сотрудника нашлось место, метод возвращает true. Метод EmployeeBook корректно находит свободное место,
добавляет сотрудника, возвращает true при успешном добавлении и false при отсутствии места.*/
    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }
/*10 Добавьте метод для получения сотрудника по id. Корректно реализован метод для поиска сотрудника по id, он возвращает
объект или null.*/
    public Employee searchId(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}