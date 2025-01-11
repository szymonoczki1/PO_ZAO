import java.util.ArrayList;
import java.util.Random;
public class General {
    public double gold;
    public String name;
    public ArrayList<Soldier> army;
    public Sekretarz sekretarz;
    public General(int starting_gold, String general_name, ArrayList<Soldier> army, Sekretarz sekretarz){
        this.gold = starting_gold;
        this.name = general_name;
        this.army = army;
        this.sekretarz = sekretarz;
    }

    public void addSoldier(Soldier soldier) {
        army.add(soldier);
        sekretarz.addString(soldier + "zostal dodany do armi" + name);
    }


    public void removeSoldier(Soldier soldier) {
        army.remove(soldier);
        sekretarz.addString(soldier + "zostal usuniety z armi" + name);
    }



    public boolean manewry(int... indexes) {
        int cost = 0;
        for (int index : indexes){
            if (index < army.size()){
                cost += army.get(index).getRankValue();
            }
        }

        if (cost > gold){
            sekretarz.addString(name + "probowal uzyc manewru ale nie bylo go stac");
            return false;
        } else {
            for (int index : indexes){
                Soldier soldier = army.get(index); 
                soldier.increaseExperience(1);
                sekretarz.addString(soldier.rank + "dostal +1 exp");
            }
            sekretarz.addString(name + "uzyl manewru");
            return true;
        }
    }

    public int getArmyPower(){
        int total_power = 0;
        for (Soldier soldier: army){
            total_power += soldier.getPower();
        }
        return total_power;
    }

    public void changeArmyExp(int change){
        for (int i=0; i < army.size(); i++){
            Soldier soldier = army.get(i);
            soldier.increaseExperience(change);
            sekretarz.addString(soldier.rank + "dostal" + change + "exp");

            if (soldier.isDead()){
                sekretarz.addString(soldier.rank + "umarl");
                army.remove(i);
                i--;
            }
        }
    }

    public Soldier removeRandomSoldier(){
        Random random = new Random();
        int randomIndex = random.nextInt(army.size());
        sekretarz.addString(army.get(randomIndex).rank + "zostal usuniety przez remis w wojnie");
        return army.remove(randomIndex);
    }

    public void atak(General general2) {
        sekretarz.addString(name + "zaatakowal" + general2.name);
        if (getArmyPower() > general2.getArmyPower()) {
            sekretarz.addString(name + "wygral wojne");
            sekretarz.addString(name + "dostal" + general2.gold * 0.1 + "zlota");
            sekretarz.addString(general2.name + "stracil" + general2.gold * 0.1 + "zlota");
            gold += general2.gold * 0.1;
            general2.gold = general2.gold * 0.9;

            changeArmyExp(1);
            general2.changeArmyExp(-1);
        } else if (getArmyPower() < general2.getArmyPower()) {
            sekretarz.addString(general2.name + "wygral wojne");
            sekretarz.addString(general2.name + "dostal" + gold * 0.1 + "zlota");
            sekretarz.addString(name + "stracil" + gold * 0.1 + "zlota");
            general2.gold += gold * 0.1;
            gold = gold * 0.9;

            changeArmyExp(-1);
            general2.changeArmyExp(1);
        } else {
            removeRandomSoldier();
            general2.removeRandomSoldier();
        }
    }

    public boolean buySoldier(int rank){
        if (gold < rank * 10){
            sekretarz.addString(name + "probowal kupic zolnierza ale nie bylo go na to stac");
            return false;
        } else {
            switch (rank) {
                case 1:
                    gold -= 1 * 10;
                    NowySzeregowy szeregowy = new NowySzeregowy(1);
                    army.add(szeregowy);
                    sekretarz.addString(name + "kupil" + szeregowy.rank);
                    return true;
                case 2:
                    gold -= 2 * 10;
                    NowyKapral kapral = new NowyKapral(1);
                    army.add(kapral);
                    sekretarz.addString(name + "kupil" + kapral.rank);
                    return true;
                case 3:
                    gold -= 3 * 10;
                    NowyKapitan kapitan = new NowyKapitan(1);
                    army.add(kapitan);
                    sekretarz.addString(name + "kupil" + kapitan.rank);
                    return true;
                case 4:
                    gold -= 4 * 10;
                    NowyMajor major = new NowyMajor(1);
                    army.add(major);
                    sekretarz.addString(name + "kupil" + major.rank);
                    return true;
                default:
                    return false;
            }
        }
    }
}
