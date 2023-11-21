package yandexPracticum.javaCoreIntroduction.theme_11_list_hash.lesson_7;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_7 {
    public static void lesson_7() {
        printSection("Lesson_1. Операции с хеш-таблицами");

        OrdersManager ordersManager = new OrdersManager();

        ordersManager.printAllOrders();
        System.out.println("Всего заказов на сумму: " + ordersManager.getOrdersSum());

        String maxOrderCustomerName = ordersManager.getMaxOrderCustomerName();
        System.out.println("Самая большая сумма заказов у " + maxOrderCustomerName);
        ordersManager.printCustomerOrders(maxOrderCustomerName);

        ordersManager.removeUnprofitableOrders();

        printSectionEnding();
    }
}
