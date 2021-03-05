import javax.swing.*;

public class Result {
    private String s;
    private String[] numbersByString;
    private int[] numbers;
    private int result;

    public Result(JTextField textField) {
        int index = 0;
        if (!textField.getText().equals("")) {
            s = textField.getText();
            numbersByString = s.split(" ");
            numbers = new int[numbersByString.length / 2 + 1];
            for (int i = 0; i < numbersByString.length; i++) {
                if (!numbersByString[i].equals("+") && !numbersByString[i].equals("-")) {
                    numbers[index] = Integer.parseInt(numbersByString[i]);
                    index++;
                }
            }
            calculateResult(numbers, numbersByString);
        }

    }

    public void calculateResult(int[] numbers, String[] numbersByString) {
        result = numbers[0];
        int i = 1;
        for (int j = 1; j < numbersByString.length + 1; j++) {
            if (numbersByString[j - 1].equals("+")) {
                result += numbers[i++];
            } else if (numbersByString[j - 1].equals("-")) {
                result -= numbers[i++];
            }
        }
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
