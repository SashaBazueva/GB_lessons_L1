import base.Animal;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int runLength) {
        if (runLength > 200)
            System.out.printf("Ошибка!! --> Кот не может пробежать больше чем 200 м (Вы указали: %d м)%n", runLength);
        else if (runLength < 0)
            System.out.printf("Ошибка!! --> Проверьте введеное значение, оно не может быть отрицательным (Вы указали: %d м)%n", runLength);
        else System.out.printf("Кот %s пробежал %d м%n", getName(), runLength);
    }

    @Override
    public void swim(int swimLength) {
        if (swimLength > 0)
            System.out.printf("Ошибка!! --> Кошки не умеют плавать, поэтому кот %s не сможет проплыть %d м%n", getName(), swimLength);
        else if (swimLength < 0)
            System.out.printf("Ошибка!! --> Проверьте введеное значение, оно не может быть отрицательным (Вы указали: %d м)%n", swimLength);
        else System.out.printf("Кошки не умеют плавать, поэтому кот %s ничего не проплыл%n", getName());
    }
}
