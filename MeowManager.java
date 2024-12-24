public class MeowManager implements Meowable{
    final private Cat cat;
    private int MeowCounter;

    MeowManager(Cat cat, MeowForAll cats) {
        this.cat = cat;
        MeowCounter = 0;
        cats.addCat(this);
    }

    public void meow() {
        cat.meow();
        MeowCounter++;
    }

    public int getMeowCount() {
        return MeowCounter;
    }

    public String getCat() { return cat.getName(); }

    public static void meowsCare(Meowable cat) {
        // Вызываем метод meow() несколько раз
        for (int i = 0; i < 5; i++) {
            cat.meow();
        }
    }
}