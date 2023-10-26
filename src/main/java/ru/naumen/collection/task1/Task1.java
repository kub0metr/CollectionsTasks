package ru.naumen.collection.task1;

import ru.naumen.collection.task2.Ticket;

import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно написать утилитный метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 * <p>
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */

/**
 * 1. Выбран HashSet так как операция contains и add всего за O(1).
 * 2. Сложность операции O(N).
 * 3. Сложность такова так как мы всего один раз проходим по коллекции и при проверке и при добавлении требуется всего O(1) операций.
 */
public class Task1 {

    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        List<User> duplicates = new ArrayList<>();
        Set<User> setA = new HashSet<>(collA);
        for (User user : collB) {
            if (setA.contains(user))
                duplicates.add(user);
        }
        return duplicates;
    }
}
