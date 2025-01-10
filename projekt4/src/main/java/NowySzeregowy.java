public class NowySzeregowy extends Soldier {
    public NowySzeregowy(int experience) {
        this.rank = "Szeregowy";
        this.exp = experience;
        this.power_multiplier = 1;
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
