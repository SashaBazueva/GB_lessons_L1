import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    /*
    1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
     При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
     После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Ираем? 1 – да / 0 – нет");
        byte game = input.nextByte();
        while (game==1){
            int count;
            int number = makeNumber();
            int userNumber;
            for (count = 3;count >= 1;count--){
                userNumber = inputUserNumber(count, input);
                if (number==userNumber){
                    System.out.println("Вы выйграли!");
                    break;
                }
                compareNumbers(number, userNumber);
            }
            if (count==0) System.out.println("Вы проиграли :с");
            System.out.println();
            System.out.println("--------");
            System.out.println("Повторить игру еще раз? 1 - да / 0 - нет");
            game = input.nextByte();
        }

    }

    public static int makeNumber(){
        Random random = new Random();
        return random.nextInt(10);
    }
    public static int inputUserNumber(int count, Scanner input) {
        System.out.println("Введите число... Попыток: " + count);
        return input.nextInt();
    }
    public static void compareNumbers(int number, int userNumber){
        if (number > userNumber)  System.out.println(">> Загаданное число больше");
        else System.out.println(">> Загаданное число меньше");
    }
}
