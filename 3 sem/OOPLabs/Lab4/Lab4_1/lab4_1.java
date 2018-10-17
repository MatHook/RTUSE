package OOPLabs.Lab4.Lab4_1;

public class lab4_1 {
    public static void main(String[] args) {
        Nameable nameable = createNameable("unknown", false);
        nameable.print();
        Animals animals = new Animals("Lion");
        animals.print();

        read(new Planets("Jupiter"));
        read(new Cars("Mercedes"));
    }

    private static void read(Nameable n) {
        n.print();
    }

    private static Nameable createNameable(String name, boolean option) {
        if(option) {
            return new Planets("Mars");
        }
        else
            return new Cars("BMW");
    }
}

class Planets implements Nameable {
    String name;

    Planets(String name){
        this.name = name;
    }

    public void print() {
        System.out.println("Name: " + name);
    }
}


