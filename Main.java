import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.println("Введите номер задания: ");
        int n = in.nextInt();
        in.nextLine();
        switch(n) {
            case 11:
                System.out.println("Введем дроби 1/2 и -1/-2");
                Decimal decimal1 = new Decimal(1, 2);
                Decimal decimal2 = new Decimal(-1, -2);

                System.out.println("fraction1 equals fraction2: " + decimal1.equals(decimal2)); // true

                System.out.println("Получаем вещесвенное значение дроби 1/2");
                DecimalCache decimalCache1 = new DecimalCache(decimal1);
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());

                System.out.println("Получаем вещесвенное значение дроби 3/5");
                decimalCache1.setNumeratorDenominator(3,5);
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());

                System.out.println("Сравниваем 1/2 и 3/5");
                System.out.println("fraction1 equals fraction2: " + decimal1.equals(decimal2)); // false

                break;
            case 21:
                MeowForAll cats = new MeowForAll();
                out.println("Задаем котов: \n");
                Cat barsik = new Cat("Барсик");
                Cat murzik = new Cat("Мурзик");

                MeowManager barsikManager = new MeowManager(barsik, cats);
                MeowManager murzikManager = new MeowManager(murzik, cats);

                MeowManager.meowsCare(barsikManager); // Мяукает 5 раз

                out.println(barsik + ", количество мяуканий: " + barsikManager.getMeowCount());
                out.println(murzik + ", количество мяуканий: " + murzikManager.getMeowCount());

                MeowForAll.makeAllCatsMeow(cats);

                out.println(barsik + ", количество мяуканий: " + barsikManager.getMeowCount());
                out.println(murzik + ", количество мяуканий: " + murzikManager.getMeowCount());

                break;
            case 38:
                System.out.println("список L, в котором эл-ты входящие в список L1, но не входящие в список L2");
                List<Integer> L1 = Arrays.asList(1,2,3,4,5);
                System.out.println("L1: "+L1);
                List<Integer> L2 = Arrays.asList(5,6,7,8,9);
                System.out.println("L2: "+L2);
                System.out.println("L:" + Element.element(L1,L2));
                break;
            case 48:
                out.println("Введите размер списка учеников разных школ: ");
                int n48 = Integer.parseInt(in.nextLine());

                Map<Integer, List<String>> scoreMap = new HashMap<>(); // Map<Score, List<Name>>

                out.println("Заполните список в следующем формате: <Фамилия> <Имя> <Школа> <Балл>");
                for (int i = 0; i < n48; i++) {
                    String line = in.nextLine();
                    String[] parts = line.split(" ");
                    String lastName = parts[0];
                    String firstName = parts[1];
                    int school = Integer.parseInt(parts[2]);
                    int score = Integer.parseInt(parts[3]);

                    if (school == 50) {
                        String fullName = lastName + " " + firstName;
                        scoreMap.computeIfAbsent(score, k -> new ArrayList<>()).add(fullName);
                    }
                }

                if (scoreMap.isEmpty()) {
                    return; // Нет студентов - нет программы
                }

                List<Integer> scoresSorted = new ArrayList<>(scoreMap.keySet());
                scoresSorted.sort(Collections.reverseOrder());

                int bestScore = scoresSorted.getFirst();
                List<String> bestStudents = scoreMap.get(bestScore);


                if (bestStudents.size() > 2) {
                    out.println("Количество лучших учеников: "+bestStudents.size());
                } else if (bestStudents.size() == 2) {
                    out.println("Двое лучших учеников: ");
                    for (String student : bestStudents) {
                        out.println(student);
                    }
                } else { // size == 1
                    out.println("Лучший ученик: ");
                    if (scoresSorted.size() > 1)
                    {
                        int secondScore = scoresSorted.get(1);
                        if (scoreMap.get(secondScore).size() > 1)
                        {
                            out.println(bestStudents.getFirst());
                        } else {
                            out.println(bestStudents.getFirst());
                        }
                    } else {
                        out.println(bestStudents.getFirst());
                    }

                }
                break;


            case 58:
                String filename = "filetoread38.txt";

                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    Set<Character> russianAlphabet = new HashSet<>();
                    for (char c = 'а'; c <= 'я'; c++) {
                        russianAlphabet.add(c);
                    }
                    String line;
                    while ((line = reader.readLine()) != null) {
                        line = line.toLowerCase(); // Приводим к нижнему регистру
                        for (char c : line.toCharArray()) {
                            if (Character.isLetter(c) && Character.UnicodeScript.of(c) == Character.UnicodeScript.CYRILLIC) {
                                russianAlphabet.remove(c);
                            }
                        }
                    }

                    System.out.println("Количество отсутствующих букв русского алфавита: " + russianAlphabet.size());
                    System.out.println("Отсутствующие буквы: " + russianAlphabet);

                } catch (IOException e) {
                    System.err.println("Ошибка при чтении файла: " + e.getMessage());
                }
                break;
            case 63:
                System.out.println("Определить, есть ли в очереди L хотя бы один элемент, который равен следующему за ним (по\n" +
                        "кругу) элементу (первый элемент считать следующим для последнего).\n");
                Queue<Integer> queue1 = new LinkedList<>();
                queue1.add(1);
                queue1.add(2);
                queue1.add(3);
                queue1.add(4);
                queue1.add(1);
                out.println("Очередь 1: " + queue63.hasConsecutiveEquals(queue1)); // true


                Queue<Integer> queue2 = new LinkedList<>();
                queue2.add(1);
                queue2.add(2);
                queue2.add(3);
                queue2.add(4);
                queue2.add(5);
                out.println("Очередь 2: " + queue63.hasConsecutiveEquals(queue2)); // false

                Queue<Integer> queue3 = new LinkedList<>();
                queue3.add(1);
                queue3.add(1);
                out.println("Очередь 3: " + queue63.hasConsecutiveEquals(queue3)); //true

                Queue<Integer> queue4 = new LinkedList<>();
                out.println("Очередь 4: " + queue63.hasConsecutiveEquals(queue4)); // false (пустая очередь)

                Queue<Integer> queue5 = new LinkedList<>();
                queue5.add(5);
                out.println("Очередь 5: " + queue63.hasConsecutiveEquals(queue5)); // false (один элемент)
                break;

            case 71:
                List<Point> points = Arrays.asList(
                        new Point(1.0, 2.5),
                        new Point(4.0, -6.0),
                        new Point(1.0, 2.5),
                        new Point(7.5, -1.0),
                        new Point(4.0, -6.0),
                        new Point(2.0,-3),
                        new Point(4, 4)
                );

                Polyline polyline = points.stream()
                        .distinct()
                        .sorted(Comparator.comparingDouble(Point::getX))  // Сортируем по X
                        .map(p -> new Point(p.getX(), Math.abs(p.getY())))  // Делаем Y положительным
                        .distinct()
                        .collect(Collectors.collectingAndThen(Collectors.toList(),
                                list -> new Polyline(list.toArray(new Point[0])))); // Собираем в Polyline

                out.println(polyline); // Вывод полученной ломаной
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }

    }
}
