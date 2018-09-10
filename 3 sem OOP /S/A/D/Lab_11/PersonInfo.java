package S.A.D.Lab_11;

import java.util.Comparator;

public class PersonInfo {
    private String name;
    private int tnumber;
    private int dbirth;
    public PersonInfo(int tnumber, String name, int dbirth) {
        this.name = name;
        this.tnumber = tnumber;
        this.dbirth = dbirth;
    }
    public int getTnumber() {
        return tnumber;
    }
    public void setTnumber(int tnumber) {
        this.tnumber = tnumber;
    }
    public int getDbirth() {
        return dbirth;
    }
    public void setDbirth(int dbirth) {
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
