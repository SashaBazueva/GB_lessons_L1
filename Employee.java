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

    public void outputInformation(String fio, String post, String email, String phoneNumber, int salary, int age) {
        System.out.println(fio);
        System.out.println();
        System.out.println("Возраст: " + age);
        System.out.println("Должность: " + post + " (" + salary + " ₽)");
        System.out.println("Эл. почта: " + email);
        System.out.println("Контактный номер телефона: " + phoneNumber);//номер телефона для связи
    }

    public int setAge() {
        return age;
    }

    public int setSalary() {
        return salary;
    }

    public String setFio() {
        return fio;
    }

    public String setPost() {
        return post;
    }

    public String setEmail() {
        return email;
    }

    public String setPhoneNumber() {
        return phoneNumber;
    }
}

