package ipleiria.taes.fastugadriver.managers;

import java.util.LinkedList;

import ipleiria.taes.fastugadriver.entities.OrderNotification;

public class NotificationManager {
    private static final NotificationManager instance = new NotificationManager();
    private final LinkedList<OrderNotification> ordersReadyNotification;
    private final LinkedList<OrderNotification> ordersCancelledNotification;

    public NotificationManager() {
        ordersReadyNotification = new LinkedList<>();
        ordersCancelledNotification = new LinkedList<>();
    }

    public static NotificationManager getManager() {
        return instance;
    }

    public void removeFromOrdersReadyNotification(int id) {
        ordersReadyNotification.removeIf(order -> order.getOrderID() == id);
    }

    public void addToOrdersReadyNotification(OrderNotification orderNotification) {
        int newOrderID = orderNotification.getOrderID();
        for (OrderNotification order : ordersReadyNotification) {
            if (order.getOrderID() == newOrderID) {
                return;
            }
        }
        ordersReadyNotification.addFirst(orderNotification);
    }

    public LinkedList<OrderNotification> getOrdersReadyNotification() {
        return ordersReadyNotification;
    }

    public LinkedList<OrderNotification> getOrdersCancelledNotification() {
        return ordersCancelledNotification;
    }
}
