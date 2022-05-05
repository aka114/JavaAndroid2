package homework5;

public class Employee {
    String name;
    String position;
    String email;
    String phone;
    double salary;
    int age;

    public Employee(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return String.format("Имя - %s, должность - %s, email %s, телефон %s, оклад - %f, возраст - %d", name, position, email, phone, salary, age);
    }

    public void printInfo() {
        System.out.println(this);
    }
}
