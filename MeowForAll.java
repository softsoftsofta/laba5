import java.util.ArrayList;
import java.util.List;

public class MeowForAll {
    static List<MeowManager> cats;

    MeowForAll() { cats = new ArrayList<>(); }

    void addCat(MeowManager cat) {
        cats.add(cat);
    }

    public List<MeowManager> getCatList() { return cats; }

    public static void makeAllCatsMeow(MeowForAll cats) {
        System.out.println("Сейчас мяукнут все коты, которые были добавлены в MeowManager: ");
        for (MeowManager cat : cats.getCatList()) {
            cat.meow();
        }
    }
}
