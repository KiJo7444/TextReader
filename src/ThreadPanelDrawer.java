import java.awt.*;

public class ThreadPanelDrawer extends Thread {

    private MainPanel panel;
    @Override
    public void run(){
        panel = new MainPanel();
    }

    public void update(){

    }
}
