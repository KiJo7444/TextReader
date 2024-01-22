import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static final int CORES_AMOUNT = Runtime.getRuntime().availableProcessors();
    private static final String FILE_PATH = "text";
    private static volatile String TEXT;

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            Thread panelDrawer = new ThreadPanelDrawer();
            panelDrawer.start();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static String getTEXT() {
        return TEXT;
    }

    public static void setTEXT(String TEXT) {
        Main.TEXT = TEXT;
    }


}