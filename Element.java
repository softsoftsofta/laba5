import java.util.ArrayList;
import java.util.List;

public class Element {
    public static <T> List<T> element(List<T> L1, List<T> L2) {
        if (L1 == null || L1.isEmpty()) {
            return new ArrayList<>();
        }
        List<T> L = new ArrayList<>();
        for (T item : L1) {
            if (!L2.contains(item) && !L.contains(item)) {
                L.add(item);
            }
        }
        return L;
    }
}