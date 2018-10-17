package OOPLabs.Lab4.Lab4_1;

public class Animals {
    private String name;

    String getName() {
        return name;
    }

    Animals(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println("Name is: " + name);
    }
}
