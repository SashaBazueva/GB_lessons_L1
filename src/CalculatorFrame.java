import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        setTitle("Калькулятор (´・ω・｀)");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 500);

        setLayout(new BorderLayout());

        TopFrame top = new TopFrame();
        add(top.getTop(), BorderLayout.NORTH);

        BottomFrame bottom = new BottomFrame(top.getTextField());
        add(bottom.getBottom(), BorderLayout.CENTER);

        setVisible(true);

    }
}



