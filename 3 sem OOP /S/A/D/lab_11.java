package S.A.D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class lab_11 {
    public static void main(String[] args){
        File file = new File("/Users/matvey/IdeaProjects/Labs/3 sem OOP /S/A/D/text.txt");
        ArrayList<String> peoples = new ArrayList<String>();
        Scanner sc = null;

        try {
            sc = new Scanner(file);

            while(sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                peoples.add(line);
                System.out.println(peoples);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
        peoples.add(new PersonInfo(peoples.subList(0,10),peoples.subList(peoples.indexOf("|"), peoples.lastIndexOf("|"),peoples.subList(peoples.lastIndexOf("|"),peoples.toString().length()))));
    }
}
