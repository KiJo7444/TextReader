import javax.swing.*;

public class MainWindow extends JWindow {
    private JFrame frame;

    public MainWindow(MainPanel mainPanel){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
