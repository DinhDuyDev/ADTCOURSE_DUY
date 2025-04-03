import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {
    public static void main(String[] args) {
        String inputFilePath = "Frankenstein.txt";
        File inputFile = new File(inputFilePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        HashMap<String, Integer> keySet = new HashMap<>(5);
        String scanString;
        for (int i=0; i<20; i++) {
            scanString = scanner.next();
            if (!keySet.containsKey(scanString)) {
                keySet.put(scanString, 1);
            } else {
                keySet.put(scanString, keySet.get(scanString) + 1);
            }
        }
        System.out.println(keySet.get("of"));
    }
}