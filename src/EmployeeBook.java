public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void add(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void countAverageSalary() {
        double sum = 0;
        double count = 0;
        double avarage = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum = sum + employee.getSalary();
                count++;
            }
        }
        avarage = sum / count;
        System.out.println(avarage);
    }

    public void calculateTax(String taxType) {
        for (Employee employee : employees) {
            if (employee != null) {
                double salary = employee.getSalary();
                double taxAmount = 0;

                switch (taxType.toUpperCase()) {
                    case "PROPORTIONAL":
                        taxAmount = salary * 0.13;
                        System.out.println("Налог для сотрудника " + employee.getSurname() + " составляет " + taxAmount + " рублей.");
                        break;
                    case "PROGRESSIVE":
                        if (salary <= 150) {
                            taxAmount = salary * 0.13;
                            System.out.println("Налог для сотрудника " + employee.getSurname() + " составляет " + taxAmount + " рублей.");
                        } else if (salary <= 350) {
                            taxAmount = salary * 0.17;
                            System.out.println("Налог для сотрудника " + employee.getSurname() + " составляет " + taxAmount + " рублей.");
                        } else {
                            taxAmount = salary * 0.21;
                            System.out.println("Налог для сотрудника " + employee.getSurname() + " составляет " + taxAmount + " рублей.");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Неправильно указан тип налогового режима");
                }
            }
        }
    }

    public void makeIndexation(int enterDepartment, double persent) {
        for (Employee department : employees) {
            if (department != null) {
                int d = department.getDepartment();
                double s = department.getSalary();
                if (d == enterDepartment) {
                    s += s * persent;
                    System.out.println("Зарплата сотрудника " + department.getSurname() + " после индексации составляет " + s + " рублей.");
                    continue;
                }
            }
        }
    }

public void findSalary(int numberOfDepartment, int enterSalaryToSearch) {
    for (int i = 0; i < employees.length; i++) {
        Employee employee = employees[i];
        if (employee != null) {
        int needDepartment = employee.getDepartment();
        int needSalary = employee.getSalary();
        boolean needEmployee = needDepartment == numberOfDepartment && needSalary > enterSalaryToSearch;
        if (needEmployee == true) {
                employee.printShortInfo();
                } else {
                System.out.println("В отделе " + numberOfDepartment + " не найден сотрудник с зарплатой больше " + enterSalaryToSearch);
                break;
            }
        }
    }
}

    public void findEmployeeNumber (int wage, int employeeNumber) {
        int count = 0;
        int index = 0;

        while (count < employeeNumber && index < employees.length) {
            Employee emp = employees[index++];
            if (emp != null && emp.getSalary() < wage) {
                System.out.println("Номер сотрудника с зарплатой меньше " + wage + " : " + index);
                emp.printShortInfo();
                count++;
                if (count == employeeNumber) {
                }
            }
        }
    }

    public boolean findEmployee(Employee salary) {
        for (Employee needEmployee : employees) {
            if (needEmployee != null && needEmployee.equals(salary)) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public Employee searchId(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}