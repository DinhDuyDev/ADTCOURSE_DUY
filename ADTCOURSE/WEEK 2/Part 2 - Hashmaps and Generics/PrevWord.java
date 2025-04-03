import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PrevWord {
    public static void main(String[] args) {
        String inputFilePath = "Frankenstein.txt";
        File inputFile = new File(inputFilePath);
        Map<String, ArrayList<String>> nearbyWords = new HashMap<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        String previousWords;
        String newWord = scanner.next();
        for (int i=0; i<500; i++) {
            previousWords = newWord;
            newWord = scanner.next();
            if (!nearbyWords.containsKey(newWord)) {
                nearbyWords.put(newWord, new ArrayList<>());
            } else {
                nearbyWords.get(newWord).add(previousWords);
            }
        }
        scanner.close();
        System.out.println(nearbyWords.get("of").toString());
    }
}
