import base.Animal;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Cat[] cats = {new Cat("Борис"), new Cat("Пушок")};
        Dog[] dogs = {new Dog("Буся")};

        int countCat = countAndOutputInfo(cats, cats, dogs);
        int countDog = countAndOutputInfo(dogs, cats, dogs);

        System.out.println("----------");
        System.out.println
                ("Кошек было создано: " + countCat +
                        "\nСобак было создано: " + countDog +
                        "\nВсего животных: " + (countDog + countCat));

    }

    public static int countAndOutputInfo(Animal[] arrayOfAnimal, Cat[] cats, Dog[] dogs) {
        int count = 0;
        for (int i = 0; i < arrayOfAnimal.length; i++) {
            arrayOfAnimal[i].run(setRangeForRun(arrayOfAnimal, cats, dogs));
            arrayOfAnimal[i].swim(setRangeForSwim(arrayOfAnimal, cats, dogs));
            count++;
        }
        return count;
    }

    public static int setRangeForRun(Animal[] arrayOfAnimal, Cat[] cats, Dog[] dogs) {
        Random random = new Random();
        if(arrayOfAnimal==cats){
            return random.nextInt(201);
        }
        if (arrayOfAnimal==dogs){
            return random.nextInt(501);
        }
        return 0;
    }
    public static int setRangeForSwim(Animal[] arrayOfAnimal, Cat[] cats, Dog[] dogs) {
        Random random = new Random();
        if(arrayOfAnimal==cats){
            return random.nextInt(1);
        }
        if (arrayOfAnimal==dogs){
            return random.nextInt(11);
        }
        return 0;
    }
}