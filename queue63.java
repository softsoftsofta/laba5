import java.util.Queue;

public class queue63 {
    public static boolean hasConsecutiveEquals(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) {
            return false; // Недостаточно элементов для сравнения
        }

        int size = queue.size();
        int[] arr = new int[size]; // Преобразуем очередь в массив для удобства
        int i = 0;
        for (Integer item : queue) {
            arr[i++] = item;
        }

        for (int j = 0; j < size; j++) {
            int nextIndex = (j + 1) % size; // Индекс следующего элемента по кругу
            if (arr[j] == arr[nextIndex]) {
                return true; // Найдены два равных соседних элемента
            }
        }
        return false; // Равных соседних элементов не найдено
    }
}
