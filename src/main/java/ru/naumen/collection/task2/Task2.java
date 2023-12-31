package ru.naumen.collection.task2;

import java.util.HashMap;

/**
 * Дано:
 * <pre>
 * public class Ticket {
 *     private long id;
 *     private String client;
 *     …
 * }</pre>
 * <p>Разработать программу для бармена в холле огромного концертного зала.
 * Зрители в кассе покупают билет (класс Ticket), на котором указан идентификатор билета (id) и имя зрителя.
 * При этом, есть возможность докупить наборы разных товаров (комбо-обед): нет товаров, напитки, еда и напитки.
 * Доп. услуги оформляются через интернет и привязываются к билету, но хранятся отдельно от билета
 * (нельзя добавить товары в класс Ticket).</p>
 * <p>Бармен сканирует билет и получает объект Ticket. По этому объекту нужно уметь
 * находить необходимые товары по номеру билета. И делать это нужно очень быстро,
 * ведь нужно как можно быстрее всех накормить.</p>
 * <p>
 * См. {@link Ticket}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */

/**
 * 1. HashMap выбрана так как мы можем одновременно хранить id билета, и то какую еду мы купили. А также за счёт того, что операция доступа по ключу и добавления
 * выполняются за константу.
 * 2. Для всех зрителей - O(N).
 * 3. Так как у нас всего две операции и они выполняются за константу.
 */
public class Task2 {

    HashMap<Ticket, String> combos = new HashMap<>();

    public void buyFood(String food, Ticket ticket){
        combos.put(ticket, food);
    }

    public String getFood(Ticket ticket){
        return combos.get(ticket);
    }
}