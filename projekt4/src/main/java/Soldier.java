public abstract class Soldier {
    public int exp = 1;
    public int power;
    public String rank;
    public int power_multiplier;

    public void levelUp(){
        switch (this.rank) {
            case "Szeregowy":
                this.rank = "Kapral";
                this.power_multiplier = 2;
                this.exp = 1;
                break;
            case "Kapral":
                this.rank = "Kapitan";
                this.power_multiplier = 3;
                this.exp = 1;
                break;
            case "Kapitan":
                this.rank = "Major";
                this.power_multiplier = 4;
                this.exp = 1;
                break;
        }
    }

    public abstract int getPower();
    public abstract int getRankValue();

    public boolean isDead(){
        return this.exp == 0;
    }

    public void increaseExperience(int amount) {
        exp += amount;
        if (exp >= 5 * getRankValue()) {
            levelUp();
        }
    }
}
