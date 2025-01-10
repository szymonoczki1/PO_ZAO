public class NowyKapral extends Soldier {
    public NowyKapral(int experience) {
        this.rank = "Kapral";
        this.exp = experience;
        this.power_multiplier = 2;
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
