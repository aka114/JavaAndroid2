package homework5;

public class HomeworkEmployee {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Вася", "директор", "vasya@company.com", "+79164345732", 100000, 34);
        Employee employee2 = new Employee("Петя", "бухгалтер", "petya@company.com", "+79164345733", 80000, 45);
        Employee employee3 = new Employee("Гриша", "менеджер", "grisha@company.com", "+79164345734", 50000, 27);
        Employee employee4 = new Employee("Толя", "кладовщик", "tolya@company.com", "+79164345735", 40000, 32);
        Employee employee5 = new Employee("Миша", "контроллер", "misha@company.com", "+79164345736", 35000, 35);

        Employee[] employee = {employee1, employee2, employee3, employee4, employee5};

        for (Employee emp: employee
             ) {
            if (emp.age > 40) {
                System.out.println(emp);
            }
        }

    }
}
