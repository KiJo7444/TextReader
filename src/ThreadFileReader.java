import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class ThreadFileReader extends Thread{

    @Override
    public void run(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Main.getFilePath()));
            String line;
            line = reader.lines().collect(Collectors.joining("\n"));
            //System.out.println(line);
            Thread.sleep(1500);
            Main.setTEXT(line);
            MainPanel.setResultingText(line);
            MainPanel.update();
            MainPanel.setThreadCreated(false);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
