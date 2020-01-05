import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;

public class Main {

    public static void main (String [] args) {
        try {
            String clipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            String url = clipboardData;
            if (url.startsWith("https://") && !url.contains("\n")) {
                launchYoutubeDL(url);
            } else {
                System.out.println("Clipboard does not contain a valid URL: " + url);
            }
        } catch (Exception ex) {
            System.out.println("An exception was thrown, probably because clipboard contained something which we were unable to parse.");
            System.out.println("The full exception is shown below:");
            ex.printStackTrace();
        }
    }

    public static void launchYoutubeDL(String url) throws IOException {
        Runtime.getRuntime().exec(new String[]
                {
                        "cmd","/k","start",
                        "cmd","/k","youtube-dl.exe",url
                }
        );
    }
}
