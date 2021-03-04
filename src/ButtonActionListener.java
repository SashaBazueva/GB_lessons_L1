import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    private JTextField textField;
    private StringBuilder sb;

    public ButtonActionListener(JTextField textField) {
        this.textField = textField;
        sb = new StringBuilder(textField.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sb.append(textField.getText());
        JButton btn = (JButton) e.getSource();
        sb.append(btn.getText());
        textField.setText(sb.toString());
        sb.setLength(0);
    }


}
