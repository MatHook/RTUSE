package OOPLabs.Lab8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class lab8_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/Users/matvey/IdeaProjects/Labs/Souce/textfile"));
        String line = in.readLine();
        while (line != null) {
            System.out.println(line);
            line = in.readLine();
        }
        in.close();
    }
}
