import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main (String [] args) {
        try {
            String clipboardData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            String url = clipboardData;
            if (url.startsWith("https://") && !url.contains("\n")) {
                launchYoutubeDL(url, args);
            } else {
                System.out.println("Clipboard does not contain a valid URL: " + url);
            }
        } catch (Exception ex) {
            System.out.println("An exception was thrown, probably because clipboard contained something which we were unable to parse.");
            System.out.println("The full exception is shown below:");
            ex.printStackTrace();
        }
    }

    public static String getPromptFlag(String[] args) {
        for (String arg : args) {
            if (arg.equals("--closeprompt")) {
                return "/c";
            }
        }
        return "/k";
    }

    public static String[] withoutPromptFlag(String[] args) {
        ArrayList<String> filteredArgs = new ArrayList<>();
        for (String arg : args) {
            if (!arg.equals("--closeprompt")) {
                filteredArgs.add(arg);
            }
        }
        return filteredArgs.toArray(new String[0]);
    }

    public static void launchYoutubeDL(String url, String[] args) throws IOException {
        String k = getPromptFlag(args);
        Runtime.getRuntime().exec(new String[]
                {
                        "cmd", k, "start",
                        "cmd", k, "youtube-dl.exe " + url + " " + String.join(" ", withoutPromptFlag(args))
                }
        );
    }
}
