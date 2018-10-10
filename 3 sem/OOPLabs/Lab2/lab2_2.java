package OOPLabs.Lab2;

public class lab2_2 {
    public static void main(String[] args) {
        Human h1 = new Human();
        Head h2 = new Head();
        Hand h3 = new Hand();
        Leg h4 = new Leg();
        System.out.println("Id is " + h1.getPerson_id());
        System.out.println("Id of person is " + h2.getPerson_id()
                + " and brain of this person is " + h2.status_brain());
        System.out.println("Id is " + h3.getPerson_id()
                + " quantity of hands is " + h3.quntity_hands());
        System.out.println("Id is " + h4.getPerson_id()
                + " quantity of legs is " + h4.quantity_legs());
    }
}

class Human {
    private int person_id = 1;
    Human() {
    }
    int getPerson_id() {
        return person_id;
    }
}

class Head extends Human {
    public boolean status_brain() {
        return true;
    }

}

class Leg extends Human {
    public int quantity_legs() {
        return 2;
    }
}

class Hand extends Human {
    public int quntity_hands() {
        return 2;
    }
}