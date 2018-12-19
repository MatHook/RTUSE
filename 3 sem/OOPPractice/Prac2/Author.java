package OOPPractice.Prac2;

public class Author {
    private String name;
    private String mail;
    private char sex;

    Author(String name, String mail, char sex) {
        this.name = name;
        this.mail = mail;
        if (sex != 'M' && sex != 'F' && sex != 'U') {
            throw new ExceptionInInitializerError("Wrong gender!");
        }
        this.sex = sex;
    }

    String getName() {
        return name;
    }

    String getMail() {
        return mail;
    }

    char getSex() {
        return sex;
    }

    public String toString() {
        return String.format("Name: %s is %c gender. Meet via %s", name, sex, mail);
    }
}
