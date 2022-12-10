package ipleiria.taes.fastugadriver.entities;

import java.util.Date;

public class OrderNotification {
    private int orderID;
    private String title;
    private String context;
    private Date date;

    public OrderNotification(int orderID, String title, String context, Date date) {
        this.orderID = orderID;
        this.title = title;
        this.context = context;
        this.date = date;
    }

    public void setCancellationReason(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public int getOrderID() {
        return orderID;
    }
}
