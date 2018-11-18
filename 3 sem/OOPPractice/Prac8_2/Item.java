package OOPPractice.Prac8_2;

public interface Item {
    int getCost();
    String getLablel();
    String getDiscription();
}

class Dish implements Item {
    private final int _cost;
    private final String _label;
    private final String _description;
    Dish(int cost, String label, String description){
        this._cost = cost;
        this._label = label;
        this._description= description;
    }
    @Override
    public int getCost() {
        return _cost;
    }

    @Override
    public String getLablel() {
        return _label;
    }

    @Override
    public String getDiscription() {
        return _description;
    }
}

class Drink implements Item {

    @Override
    public int getCost() {
        return 5;
    }

    @Override
    public String getLablel() {
        return "FuzeTea";
    }

    @Override
    public String getDiscription() {
        return "Nice ;D";
    }
}