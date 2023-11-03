package ru.naumen.collection.task3;

import java.nio.file.Path;
import java.util.*;

/**
 * <p>Написать консольное приложение, которое принимает на вход произвольный текстовый файл в формате txt.
 * Нужно собрать все встречающийся слова и посчитать для каждого из них количество раз, сколько слово встретилось.
 * Морфологию не учитываем.</p>
 * <p>Вывести на экран наиболее используемые (TOP) 10 слов и наименее используемые (LAST) 10 слов</p>
 * <p>Проверить работу на романе Льва Толстого “Война и мир”</p>
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */

/**
 * 1. Выбрана HasMap потому что добавление и поиск за O(1). Выбрана PriorityQueue так как она всегда хранит свое состояние отсортированным,
 * а добавление всего за O(logN).
 * 2. Сложность O(NlogN)
 * 3. Сложность такова так, как при проходе всего текста и записи в HashMap нам потребуется N операций, так как запись в HashMap O(1).
 * Затем ещё 2N для добавления в каждую из очередей каждое из которых O(log(N)).
 */
public class WarAndPeace {

    private static final Path WAR_AND_PEACE_FILE_PATH = Path.of("src/main/resources", "Лев_Толстой_Война_и_мир_Том_1,_2,_3,_4_(UTF-8).txt");

    public static void main(String[] args) {
        Map<String, Integer> count = new LinkedHashMap<>();
        new WordParser(WAR_AND_PEACE_FILE_PATH).forEachWord(word -> {
            count.put(word, count.getOrDefault(word, 0) + 1);
        });
        Queue<String> pq = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (String word : count.keySet()) {
            pq.offer(word);
            if (pq.size() > 10)
                pq.poll();
        }
        System.err.println("Первые 10");
        for (int i = 0; i < 10; i++) {
            String word = pq.poll();
            System.err.println(word + " " + count.get(word));
        }
        pq = new PriorityQueue<>((w1, w2) -> count.get(w2) - count.get(w1));
        for (String word : count.keySet()) {
            pq.offer(word);
            if (pq.size() > 10)
                pq.poll();
        }
        System.err.println(" Последние 10");
        for (int i = 0; i < 10; i++) {
            String word = pq.poll();
            System.err.println(word + " " + count.get(word));
        }
    }
}
