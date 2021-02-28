import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte answer = 1;

        String catMessage = "Сколько котов покормить? ";
        String dogMessage = "Сколько собак покормить? ";


        Cat[] cats = {new Cat("Пушок"), new Cat("Барсик"), new Cat("Федя")};
        Dog[] dogs = {new Dog("Вольт"), new Dog("Рекс")};


        Animal[] fullAnimals;
        Cat[] fullCats;
        Dog[] fullDogs;

        Animal[] hungryAnimals = new Animal[1];
        Cat[] hungryCats;
        Dog[] hungryDogs;

        System.out.println("У нас имеются:");

        outputArrayOfAnimals(cats, "коты");
        outputArrayOfAnimals(dogs, "собаки");

        Plate plate = new Plate(50);

        System.out.print(
                "Один кот съедает 15 ед. корма\n" +
                        "Одна собака съедает 25 ед. корма\n" +
                        "В тарелке: " + plate.getFullness() + " ед. корма \n");
        System.out.println("----------");


        hungryCats = cats;
        hungryDogs = dogs;

        while (plate.getFullness() >= 15 && hungryAnimals.length != 0 && answer == 1) {

            feedAnimals(hungryCats, plate, catMessage, "коты");
            feedAnimals(hungryDogs, plate, dogMessage, "собаки");


            catMessage = "Сколько котов еще покормить? ";
            dogMessage = "Сколько собак еще покормить? ";


            System.out.println("----------");


            fullCats = createFullAnimalArray(cats, setArrayLengthForFullAnimal(cats));
            fullDogs = createFullAnimalArray(dogs, setArrayLengthForFullAnimal(dogs));

            hungryCats = createHungryAnimalArray(cats, setArrayLengthForHungryAnimal(cats));
            hungryDogs = createHungryAnimalArray(dogs, setArrayLengthForHungryAnimal(dogs));

            fullAnimals = mergeArrays(fullCats, fullDogs);
            hungryAnimals = mergeArrays(hungryCats, hungryDogs);

            printResult(fullAnimals, hungryAnimals, plate);

            if (hungryAnimals.length != 0) {
                System.out.print("Хотите покормить животных еще?  1 - да / 0 - нет  ");
                answer = input.nextByte();

                if (plate.getFullness() < 15 && answer == 1) {
                    System.out.print("Корм закончился, сколько корма хотите добавить?   ");
                    plate.addFood(input.nextInt());
                    System.out.println("--> корм успешно добавлен, в миске сейчас: " + plate.getFullness() + " ед. корма");
                    System.out.println("----------");
                    printResult(fullAnimals, hungryAnimals, plate);
                }
            }

        }
        if (hungryAnimals.length == 0) System.out.println("Все животные сытые!");
        else System.out.println("Некоторые животные остались голодными");

    }

    public static Animal[] mergeArrays(Cat[] cats, Dog[] dogs) {
        Animal[] animals = new Animal[cats.length + dogs.length];
        for (int i = 0; i < cats.length; i++) {
            animals[i] = cats[i];
        }
        for (int i = 0; i < dogs.length; i++) {
            animals[cats.length + i] = dogs[i];
        }
        return animals;
    }

    public static void outputArrayOfAnimals(Animal[] arrayOfAnimals, String category) {
        System.out.print("        " + category + "(" + arrayOfAnimals.length + "шт): ");

        for (int i = 0; i < arrayOfAnimals.length; i++) {
            System.out.print(arrayOfAnimals[i].getName() + " ");
        }
        System.out.println();
    }

    public static void feedAnimals(Animal[] arrayOfAnimals, Plate plateOfFood, String message, String category) {
        Scanner input = new Scanner(System.in);
        byte quantity;
        if (arrayOfAnimals.length != 0) {
            do {
                System.out.print(message);
                quantity = input.nextByte();
                if (quantity > arrayOfAnimals.length || quantity < 0)
                    System.out.println("Ошибка!!! --> проверьте введеное число, оно должно быть от 0 до " + arrayOfAnimals.length + " (Вы ввели:" + quantity + ")");
            } while (quantity > arrayOfAnimals.length || quantity < 0);
            for (int i = 0; i < quantity; i++) {
                arrayOfAnimals[i].eat(plateOfFood);
            }
        } else System.out.println("Все " + category + " сытые!");

    }

    public static byte setArrayLengthForFullAnimal(Animal[] arrayOfAnimals) {
        byte count = 0;
        for (int i = 0; i < arrayOfAnimals.length; i++) {
            if (arrayOfAnimals[i].getSatiety() == true) count++;
        }
        return count;
    }

    public static Cat[] createFullAnimalArray(Cat[] arrayOfCats, byte length) {
        Cat[] fullAnimals = new Cat[length];
        byte index = 0;
        for (int i = 0; i < arrayOfCats.length; i++) {
            if (arrayOfCats[i].getSatiety() == true) {
                fullAnimals[index] = arrayOfCats[i];
                index++;
            }
        }
        return fullAnimals;
    }

    public static Dog[] createFullAnimalArray(Dog[] arrayOfDogs, byte length) {
        Dog[] fullAnimals = new Dog[length];
        byte index = 0;
        for (int i = 0; i < arrayOfDogs.length; i++) {
            if (arrayOfDogs[i].getSatiety() == true) {
                fullAnimals[index] = arrayOfDogs[i];
                index++;
            }
        }
        return fullAnimals;
    }

    public static byte setArrayLengthForHungryAnimal(Animal[] arrayOfAnimals) {
        byte count = 0;
        for (int i = 0; i < arrayOfAnimals.length; i++) {
            if (arrayOfAnimals[i].getSatiety() == false) count++;
        }
        return count;
    }

    public static Cat[] createHungryAnimalArray(Cat[] arrayOfCats, byte length) {
        Cat[] hungryAnimals = new Cat[length];
        byte index = 0;
        for (int i = 0; i < arrayOfCats.length; i++) {
            if (arrayOfCats[i].getSatiety() == false) {
                hungryAnimals[index] = arrayOfCats[i];
                index++;
            }
        }
        return hungryAnimals;
    }

    public static Dog[] createHungryAnimalArray(Dog[] arrayOfDogs, byte length) {
        Dog[] hungryAnimals = new Dog[length];
        byte index = 0;
        for (int i = 0; i < arrayOfDogs.length; i++) {
            if (arrayOfDogs[i].getSatiety() == false) {
                hungryAnimals[index] = arrayOfDogs[i];
                index++;
            }
        }
        return hungryAnimals;
    }

    public static void printResult(Animal[] fullAnimals, Animal[] hungryAnimals, Plate plate) {
        System.out.print("Сытые: ");
        if (fullAnimals.length == 0) System.out.print("-");
        for (int i = 0; i < fullAnimals.length; i++) {
            if (i != fullAnimals.length - 1)
                System.out.print(fullAnimals[i].getCategory() + " " + fullAnimals[i].getName() + ", ");
            else System.out.print(fullAnimals[i].getCategory() + " " + fullAnimals[i].getName());
        }

        System.out.println();

        System.out.print("Голодные: ");
        for (int i = 0; i < hungryAnimals.length; i++) {
            if (i != hungryAnimals.length - 1)
                System.out.print(hungryAnimals[i].getCategory() + " " + hungryAnimals[i].getName() + ", ");
            else System.out.print(hungryAnimals[i].getCategory() + " " + hungryAnimals[i].getName());
        }

        System.out.println();
        System.out.println("В миске осталось: " + plate.getFullness() + " ед. корма");

        System.out.println("----------");
    }
}
