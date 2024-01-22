import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private JButton readTextButton;
    //private static JLabel resultingText;
    private static JTextArea textField;
    private static volatile String text;
    private static boolean threadCreated = false;
    public MainPanel(){
        setPanelSize();
        readTextButton = new JButton();
        JButton clearBTN = new JButton();
        readTextButton.setText("Прочитать");
        //JFileChooser fileChooser = new JFileChooser();
        //resultingText = new JLabel();
        textField = new JTextArea();
        //resultingText.setText("Тут будет считанный текст");
        readTextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!threadCreated) {
                    threadCreated = true;
                    Thread fileReader = new ThreadFileReader();
                    fileReader.start();
                }
            }
        });
        clearBTN.setText("Очистить");
        clearBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text = "";
                update();
            }
        });
        //this.add(fileChooser);
        //this.add(resultingText);
        this.add(readTextButton);
        this.add(clearBTN);
        this.add(textField);
        MainWindow window = new MainWindow(this);
    }
    private void setPanelSize() {
        Dimension size = new Dimension(700, 360);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public static void setResultingText(String resultingText) {
        MainPanel.text = resultingText;
    }

    public static void update(){
        textField.setText(text);
        //resultingText.setText(text);
    }

    public static void setThreadCreated(boolean threadCreated) {
        MainPanel.threadCreated = threadCreated;
    }
}
