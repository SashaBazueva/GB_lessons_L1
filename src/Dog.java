import base.Animal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int runLength) {
        if (runLength > 500)
            System.out.printf("Ошибка!! --> Собака не может пробежать больше чем 500 м (Вы указали: %s м)%n", runLength);
        else if (runLength < 0)
            System.out.printf("Ошибка!! --> Проверьте введеное значение, оно не может быть отрицательным (Вы указали: %s м)%n", runLength);
        else System.out.printf("Собака %s пробежала %d м%n", name, runLength);
    }

    @Override
    public void swim(int swimLength) {
        if (swimLength > 10)
            System.out.printf("Ошибка!! --> Собака не может проплыть больше чем 10 м (Вы указали: %s м)%n", swimLength);
        else if (swimLength < 0)
            System.out.printf("Ошибка!! --> Проверьте введеное значение, оно не может быть отрицательным (Вы указали: %s м)%n", swimLength);
        else System.out.printf("Собака %s проплыла %d м%n", name, swimLength);
    }
}