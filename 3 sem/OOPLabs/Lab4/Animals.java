package OOPLabs.Lab4;

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
