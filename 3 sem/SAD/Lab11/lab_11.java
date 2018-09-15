package SAD.Lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;
import java.util.Comparator;

public class lab_11 {
    public static void main(String[] args){
        File file = new File("/Users/matvey/IdeaProjects/Labs/3 sem/SAD/Lab11/text.txt");
        ArrayList<PersonInfo> peoples = new ArrayList<PersonInfo>();
        Scanner sc = null;

        try {
            sc = new Scanner(file);
            int i = 0;

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                peoples.add(new PersonInfo(line.substring(0, line.indexOf("|")), line.substring(line.indexOf("|"), line.lastIndexOf("|")), line.substring(line.lastIndexOf("|"), line.length())));
                System.out.println(peoples);
                i++;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            sc.close();
        }
        Collections.sort(peoples, PersonInfo.PersonComparator);
        for (PersonInfo str: peoples) {
            System.out.println(str);
        }
    }
}
class PersonInfo {
    public String name;
    public String tnumber;
    public String dbirth;
    public PersonInfo(String tnumber, String name, String dbirth) {
        this.name = name;
        this.tnumber = tnumber;
        this.dbirth = dbirth;
    }
    public String getTnumber() {
        return tnumber;
    }
    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }
    public String getDbirth() {
        return dbirth;
    }
    public void setDbirth(String dbirth) {
        this.dbirth = dbirth;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static Comparator<PersonInfo> PersonComparator = new Comparator<PersonInfo>() {
        @Override
        public int compare(PersonInfo s1, PersonInfo s2) {
            String personName1 = s1.getName().toUpperCase();
            String personName2 = s2.getName().toUpperCase();
            return personName1.compareTo(personName2);
        }
    };
}
