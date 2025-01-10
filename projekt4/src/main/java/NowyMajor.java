public class NowyMajor extends Soldier {
    public NowyMajor(int experience) {
        this.rank = "Major";
        this.exp = experience;
        this.power_multiplier = 4;
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
