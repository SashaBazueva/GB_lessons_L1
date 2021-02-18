public class Employee {
    private String fio;
    private String post;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fio, String post, String email, String phoneNumber, int salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void outputInformation() {
        System.out.printf("%s", fio);
        System.out.println();
        System.out.printf("Возраст: %d%n", age);
        System.out.printf("Должность: %s (%d ₽)%n", post, salary);
        System.out.printf("Эл. почта: %s%n", email);
        System.out.printf("Контактный номер телефона: %s%n", phoneNumber);//номер телефона для связи
    }


    public int getAge() {
        return age;
    }
}

