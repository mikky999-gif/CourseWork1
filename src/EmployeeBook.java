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
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

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

    public void indexation (int enterDepartment, double persent) {
        for (Employee dep : employees) {
            if (dep != null) {
                int d = dep.getDepartment();
                double s = dep.getSalary();
                if (d == enterDepartment) {
                    s = s + s * persent;
                    System.out.println("Зарплата сотрудника " + dep.getSurname() + " после индексации составляет " + s + " рублей.");
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
                break;
            } else {
                System.out.println("В отделе " + numberOfDepartment + " не найден сотрудник с зарплатой больше " + enterSalaryToSearch);
                break;
            }
        }
    }
}

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

    public boolean findEmployee(Employee sal) {
        for (Employee ex : employees) {
            if (ex != null && ex.equals(sal)) {
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
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}