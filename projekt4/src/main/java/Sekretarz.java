import java.util.ArrayList;
public class Sekretarz {
    public ArrayList<String> list;

    public Sekretarz() {
        list = new ArrayList<>();
    }

    public void addString(String str) {
        list.add(str);
    }

    public void printList() {
        for (String str : list) {
            System.out.println(str);
        }
    }
}
