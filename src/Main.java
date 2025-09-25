public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов", "Иван", "Иванович", 1, 50000);
        employees[1] = new Employee("Петров", "Петр", "Перович", 2, 150000);
        employees[2] = new Employee("Толтой", "Карл", "Тарасович", 3, 200000);
        employees[3] = new Employee("Карпов", "Александр", "Васильевич", 4, 400000);
        employees[4] = new Employee("Александрова", "Галина", "Васильевна", 5, 450000);

        System.out.println(employees[0]);
        System.out.println(employees[1]);
        System.out.println(employees[2]);
        System.out.println(employees[3]);
        System.out.println(employees[4]);
        System.out.println( );
        employees[0].printShortInfo();
        employees[1].printShortInfo();
        employees[2].printShortInfo();
        employees[3].printShortInfo();
        employees[4].printShortInfo();
        System.out.println( );

        EmployeeBook employee = new EmployeeBook();
        employee.add(employees[0]);
        employee.add(employees[1]);
        employee.add(employees[2]);
        employee.add(employees[3]);
        employee.add(employees[4]);
        System.out.println("Список всех сотрудников:");
        employee.printAllEmployees();
        System.out.println( );
        System.out.print("Среднее значение зарплат:");
        employee.countAverageSalary();
        System.out.println( );
        System.out.println("Налоги по схеме PROPORTIONAL:");
        employee.calculateTax("PROPORTIONAL");
        System.out.println( );
        System.out.println("Налоги по схеме PROGRESSIVE:");
        employee.calculateTax("PROGRESSIVE");
        System.out.println();
        System.out.println("Индексация сотрудников:");
        employee.makeIndexation(4, 0.3);
        System.out.println();
        System.out.println("Сотрудник из нужного отдела с зарплатой больше указанной: ");
        employee.findSalary(3,50000);
        System.out.println();
        employee.findEmployeeNumber(1000000, 2);
        System.out.println();
        Employee newEmp = new Employee("Поляков", "Николай", "Николаевич", 6, 60000);
        employees[5] = newEmp;
        System.out.println("Добавлен новый сотрудник " + employees[5]);
        System.out.println();
        employee.searchId(2);
        Employee foundEmployee = employee.searchId(2); // Попробуем найти сотрудника с id=2
        if (foundEmployee != null) {
            System.out.println("Найден сотрудник с id=" + foundEmployee.getId() + ": " + foundEmployee.getName());
        } else {
            System.out.println("Сотрудник с указанным id не найден.");
        }
        System.out.println();

        Employee newEmployee1 = new Employee("Абрамов", "Всеволод", "Ильич", 1, 20000);
        employees[6] = newEmployee1;
        System.out.println("Добавлен новый сотрудник " + employees[6]);

        Employee newEmployee2 = new Employee("Баранов", "Артемий", "Леонидович", 3, 50000);
        employees[7] = newEmployee2;
        System.out.println("Добавлен новый сотрудник " + employees[7]);

        Employee newEmployee3 = new Employee("Волков", "Владимир", "Петрович", 4, 20000);
        employees[8] = newEmployee3;
        System.out.println("Добавлен новый сотрудник " + employees[8]);

        Employee newEmployee4 = new Employee("Дмитров", "Артур", "Иванович", 2, 20000);
        employees[9] = newEmployee4;
        System.out.println("Добавлен новый сотрудник " + employees[9]);

        Employee newEmployee5 = new Employee("Еременко", "Иван", "Дмитриевич", 5, 20000);
        employees[10] = newEmployee5;
        System.out.println("Добавлен новый сотрудник " + employees[10]);

        Employee newEmployee6 = new Employee("Жданов", "Артемий", "Сергеевич", 1, 20000);
        employees[11] = newEmployee6;
        System.out.println("Добавлен новый сотрудник " + employees[11]);

        Employee newEmployee7 = new Employee("Гуськов", "Михаил", "Тарасович", 1, 200000);
        employees[12] = newEmployee7;
        System.out.println("Добавлен новый сотрудник " + employees[12]);

        Employee newEmployee8 = new Employee("Проходцев", "Кирилл", "Михайлович", 2, 250000);
        employees[13] = newEmployee8;
        System.out.println("Добавлен новый сотрудник " + employees[13]);

        Employee newEmployee9 = new Employee("Ярнов", "Константин", "Петрович", 3, 240000);
        employees[14] = newEmployee9;
        System.out.println("Добавлен новый сотрудник " + employees[14]);

        Employee newEmployee10 = new Employee("Рахманов", "Тарас", "Николаевич", 4, 270000);
        employees[15] = newEmployee10;
        System.out.println("Добавлен новый сотрудник " + employees[15]);

        Employee newEmployee11 = new Employee("Хватов", "Дмитрий", "Петрович", 5, 290000);
        employees[16] = newEmployee11;
        System.out.println("Добавлен новый сотрудник " + employees[16]);
    }
}