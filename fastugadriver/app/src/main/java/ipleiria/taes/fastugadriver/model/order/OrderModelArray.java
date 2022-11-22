package ipleiria.taes.fastugadriver.model.order;

public class OrderModelArray {
    int id;
    int ticket_number;
    char status;
    int customer_id;
    float total_price;
    float total_paid;
    float total_paid_with_points;
    int points_gained;
    int points_used_to_pay;
    String payment_type;
    String payment_reference;
    String date;
    int delivered_by;
    String custom;

    public int getId() {
        return id;
    }

    public int getTicket_number() {
        return ticket_number;
    }

    public char getStatus() {
        return status;
    }

    public float getTotal_price() {
        return total_price;
    }

    public float getTotal_paid() {
        return total_paid;
    }

    public float getTotal_paid_with_points() {
        return total_paid_with_points;
    }

    public int getPoints_gained() {
        return points_gained;
    }

    public int getPoints_used_to_pay() {
        return points_used_to_pay;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public String getPayment_reference() {
        return payment_reference;
    }

    public String getDate() {
        return date;
    }

    public String getCustom() {
        return custom;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getDelivered_by() {
        return delivered_by;
    }
}
