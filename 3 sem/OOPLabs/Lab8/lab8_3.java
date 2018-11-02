package OOPLabs.Lab8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class lab8_3 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("textfile");
            Scanner in = new Scanner(new FileInputStream(file));

            String line = "";

            while(in.hasNextLine()) {
                line += in.nextLine();
            }
            FileOutputStream out = new FileOutputStream(file);
            out.write((line.equals("oqjfdoiew") ? "texttest" : "oqjfdoiew").getBytes());
        }
        catch (Exception e) {
            //
        }
    }
}
