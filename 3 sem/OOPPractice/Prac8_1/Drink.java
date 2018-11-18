package OOPPractice.Prac8_1;

final class Drink {
    final int _count;
    private final String _label;
    final String _description;
    Drink(int count, String label, String descripcion) {
        this._count = count;
        this._label = label;
        this._description = descripcion;
    }
    Drink(String label, String description) {
        this._label = label;
        this._description = description;
        this._count = 0;
    }

    int get_count() {
        return _count;
    }
    String get_label() {
        return _label;
    }
    String get_description() {
        return _description;
    }
}

class DrinkTest {
    public static void main(String[] args) {
        Drink drink_1 = new Drink(100, "Coca-Cola", "This really tasty drink");
        Drink drink_2 = new Drink("Aqua", "Just a water");
        System.out.println(drink_1._count);
        System.out.println(drink_2._description);
    }
}