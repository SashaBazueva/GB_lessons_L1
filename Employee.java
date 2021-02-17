public class Employee {
    public String fio;
    public String post;
    public String email;
    public String phoneNumber;
    public int salary;
    public int age;

    public Employee(String fio, String post, String email, String phoneNumber, int salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public static void outputInformation(String fio, String post, String email, String phoneNumber, int salary, int age) {
        System.out.println(fio);
        System.out.println();
        System.out.println("Возраст: " + age);
        System.out.println("Должность: " + post + " (" + salary + " ₽)");
        System.out.println("Эл. почта: " + email);
        System.out.println("Контактный номер телефона: " + phoneNumber);//номер телефона для связи
    }
}

