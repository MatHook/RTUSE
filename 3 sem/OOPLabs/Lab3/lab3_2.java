package OOPLabs.Lab3;

public class lab3_2 {
    public static void main(String[] main) {
        Hasky hasky = new Hasky(false, "Robin",4);
        Bulldog bulldog = new Bulldog(true,"Boxer",3);
        hasky.displayInfo();
        bulldog.displayInfo();
    }
}

abstract class Dog {
    private boolean alive_check;

    boolean isAlive_check() {
        return alive_check;
    }

    public Dog(boolean alive_check) {
        this.alive_check = alive_check;
    }

    public abstract void displayInfo();
}

class Hasky extends Dog {
    private String name;
    private int age;

    public Hasky(boolean alive_check, String h_name, int h_age) {
        super(alive_check);
        this.age = h_age;
        this.name = h_name;
    }

    public void displayInfo() {
        System.out.println("Age is " + age
                + " name is " + name
                + " alive: " + super.isAlive_check());
    }
}


class Bulldog extends Dog {
    private String name;
    private int age;

    public Bulldog(boolean alive_check, String b_name, int b_age) {
        super(alive_check);
        this.age = b_age;
        this.name = b_name;
    }

    public void displayInfo() {
        System.out.println("Age is " + age
                + " name is " + name
                + " alive: " + super.isAlive_check());
    }
}