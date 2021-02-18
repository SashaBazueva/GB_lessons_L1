public class Main {
    public static void main(String[] args){
        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Базуева Александра Сергеевна", "Босс", "bestBoss@mail.ru", "315-77-65", 300000, 49);
        emplArray[1] = new Employee("Алмазова Елизовета Антоновна", "Босс#2", "hieveryone@mail.ru", "388-12-01", 300000, 49);
        emplArray[2] = new Employee("Базуев Ярослав Сергеевич", "Старший помощник", "fortniteforever@mail.ru", "88-54-33", 120000, 40);
        emplArray[3] = new Employee("Алмазова Алина Антоновна", "танцор", "ledybagismylove@mail.ru", "11-202-10", 75000, 39);
        emplArray[4] = new Employee("Базуева Ирина Сергеевна", "художник", "lalalaa@mail.ru", "-", 75000, 35);
        for (int i = 0; i < emplArray.length; i++) {
            if (emplArray[i].getAge()>40){
                emplArray[i].outputInformation();
                System.out.println("--------");
            }
        }
    }
}
