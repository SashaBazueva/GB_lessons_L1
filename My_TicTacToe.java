import java.util.Random;
import java.util.Scanner;

public class My_TicTacToe {
    public static void main(String[] args) {
        char[][] field = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        System.out.println("% Крестики-Нолики %");
        drawGameField(field);

        while (true) {
            System.out.println("Ваш ход:");
            inputUserMove(field);
            drawGameField(field);
            if (isWin(field, 'X')) {
                System.out.println("Вы выйграли!");
                break;
            }
            if (!isNextMoveAvailable(field)) {
                System.out.println("Ничья");
                break;
            }
            System.out.println("Ход противника:");
            inputAIMove(field);
            drawGameField(field);
            if (isWin(field, 'O')) {
                System.out.println("Вы проиграли");
                break;
            }
            if (!isNextMoveAvailable(field)) {
                System.out.println("Ничья");
                break;
            }
        }

        System.out.println("Конец игры");
    }

    public static char[][] drawGameField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            System.out.print("     ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        return field;
    }

    public static void inputUserMove(char[][] field) {
        Scanner input = new Scanner(System.in);
        int x, y;
        do {
            System.out.print(">введите Х... ");
            x = input.nextInt();
            x = checkCoordinate(x, input, 'X', field);
            System.out.print(">введите Y... ");
            y = input.nextInt();
            y = checkCoordinate(y, input, 'Y', field);
            x -= 1;
            y -= 1;
            if (isCellFree(field, x, y)) System.out.println("Эта клетка занята, выберите другое место");
        } while (isCellFree(field, x, y));
        field[y][x] = 'X';
    }

    public static void inputAIMove(char[][] field) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
        } while (isCellFree(field, x, y));
        field[y][x] = 'O';
    }

    public static boolean isCellFree(char[][] field, int x, int y) {
        return field[y][x] != '-';
    }

    public static int checkCoordinate(int coordinate, Scanner input, char sign, char[][] field) {
        if (coordinate < 1 || coordinate > field.length) {
            System.out.printf("Ошибка: вы ввели некорректный %s %n", sign);
            System.out.printf(">введите %s... ", sign);
            coordinate = input.nextInt();
            return checkCoordinate(coordinate, input, sign, field);
        } else return coordinate;
    }

    public static boolean isNextMoveAvailable(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '-') return true;
            }
        }
        return false;
    }

    public static boolean isWin(char[][] field, char sign) {
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == sign && field[i][1] == sign && field[i][2] == sign) return true;
            if (field[0][i] == sign && field[1][i] == sign && field[2][i] == sign) return true;
        }
        if (field[0][0] == sign && field[1][1] == sign && field[2][2] == sign) return true;
        else if (field[2][0] == sign && field[1][1] == sign && field[0][2] == sign) return true;
        else return false;
    }
}
