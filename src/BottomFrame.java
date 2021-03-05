import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BottomFrame {
    private JPanel bottom;
    private ButtonActionListener btnActionListener;

    public BottomFrame(JTextField textField) {
        btnActionListener = new ButtonActionListener(textField);
        bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 3));
        for (int i = 0; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(btnActionListener);
            bottom.add(btn);
        }

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        bottom.add(clear);

        JButton plus = new JButton(" + ");
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append(textField.getText());
                JButton plus = (JButton) e.getSource();
                sb.append(plus.getText());
                textField.setText(sb.toString());
                sb.setLength(0);
            }
        });
        bottom.add(plus);

        JButton minus = new JButton(" - ");
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append(textField.getText());
                JButton minus = (JButton) e.getSource();
                sb.append(minus.getText());
                textField.setText(sb.toString());
                sb.setLength(0);
            }
        });
        bottom.add(minus);

        JButton equalSign = new JButton(" = ");
        equalSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result result = new Result(textField);
                StringBuilder sb = new StringBuilder();
                sb.append(textField.getText());
                JButton equalSign = (JButton) e.getSource();
                sb.append(equalSign.getText());
                textField.setText(sb.toString() + result.getResult());
                sb.setLength(0);
            }
        });
        bottom.add(equalSign);

    }

    public JPanel getBottom() {
        return bottom;
    }
}
