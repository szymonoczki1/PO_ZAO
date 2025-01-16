import java.util.ArrayList;

public class Wojna {
    public General general1;
    public General general2;
    public Sekretarz sekretarz;

    public Wojna(){
        ArrayList<Soldier> army1 = new ArrayList<>();
        ArrayList<Soldier> army2 = new ArrayList<>();
        sekretarz = new Sekretarz();
        general1 = new General(100,"General1",army1,sekretarz);
        general2 = new General(100,"General2",army2,sekretarz);
    }

    public void General1SaveStatus(){
        general1.saveStatus();
    }

    public void General1LoadStatus(){
        general1.loadStatus();
    }

    public void General2SaveStatus(){
        general2.saveStatus();
    }

    public void General2LoadStatus(){
        general2.loadStatus();
    }

    public void General1KupujeZolnierza(int rank){
        general1.buySoldier(rank);
    }

    public void General2KupujeZolnierza(int rank){
        general2.buySoldier(rank);
    }

    public void General1WypowiadaWojne(){
        general1.atak(general2);
    }

    public void General2WypowiadaWojne(){
        general2.atak(general1);
    }

    public void General1WykonujeManewry(int... indexes){
        general1.manewry(indexes);
    }

    public void General2WykonujeManewry(int... indexes){
        general2.manewry(indexes);
    }

    public void printSekretarza(){
        sekretarz.printList();
    }


}
