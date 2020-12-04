import Window.Window;

import javax.swing.*;

/**
 * Created by Oscar Norman <br>
 * Date: 2020-11-24   <br>
 * Time: 13:59   <br>
 * Project: JAVA20-OOAD-Projektarbete-Grupp-10 <br>
 */
public class Yatzy extends JFrame {

    Window yatzyPanel = new Window();

    public Yatzy(){
        add(yatzyPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Yatzy();
    }
}
