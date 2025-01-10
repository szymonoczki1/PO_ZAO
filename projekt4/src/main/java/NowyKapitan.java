public class NowyKapitan extends Soldier {
    public NowyKapitan(int experience) {
        this.rank = "Kapitan";
        this.exp = experience;
        this.power_multiplier = 3;
        this.power = power_multiplier * experience;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public int getRankValue() {
        //powermultiplier jako wartosc rangi
        return this.power_multiplier;
    }
}
