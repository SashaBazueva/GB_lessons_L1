import javax.swing.*;

public class Result {
    private String s;
    private String[] numbersByString;
    private int[] numbers;
    private int result;

    public Result(JTextField textField) {
        int index = 0;
        s = textField.getText();
        numbersByString = s.split(" ");
        numbers = new int[numbersByString.length];
        for (int i = 0; i < numbersByString.length; i++) {
            if (!numbersByString[i].equals("+") && !numbersByString[i].equals("-")) {
                numbers[index] = Integer.parseInt(numbersByString[i]);
                index++;
            }
        }
        calculateResult(numbers, numbersByString);
    }

    public void calculateResult(int[] numbers, String[] numbersByString) {
        if (numbersByString[1].equals("+")) {
            for (int i = 0; i < numbers.length; i++) {
                result += numbers[i];
            }
        } else if (numbersByString[1].equals("-")) {
            result = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                result -= numbers[i];
            }
        }
    }

    public int getResult() {
        return result;
    }
}
