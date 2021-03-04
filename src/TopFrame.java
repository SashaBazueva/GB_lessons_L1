import javax.swing.*;
import java.awt.*;

public class TopFrame {
    private JPanel top;
    private JTextField textField;

    public TopFrame(){
        top = new JPanel();
        textField = new JTextField();
        textField.setEditable(false);
        top.setLayout(new BorderLayout());
        top.add(textField, BorderLayout.CENTER);
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JPanel getTop() {
        return top;
    }
}