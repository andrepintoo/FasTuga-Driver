package ipleiria.taes.fastugadriver.model.order;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import org.json.JSONObject;

import java.util.List;

public class OrderModelArray {
    int ticket_number;
    char status;
    int customer_id;
    double total_price;
    double total_paid;
    double total_paid_with_points;
    int points_gained;
    int points_used_to_pay;
    String payment_type;
    String payment_reference;
    String date;
    int delivered_by;
    JsonElement custom;
    String updated_at;

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public void setTotal_paid(double total_paid) {
        this.total_paid = total_paid;
    }

    public void setTotal_paid_with_points(double total_paid_with_points) {
        this.total_paid_with_points = total_paid_with_points;
    }

    public void setPoints_gained(int points_gained) {
        this.points_gained = points_gained;
    }

    public void setPoints_used_to_pay(int points_used_to_pay) {
        this.points_used_to_pay = points_used_to_pay;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public void setPayment_reference(String payment_reference) {
        this.payment_reference = payment_reference;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDelivered_by(int delivered_by) {
        this.delivered_by = delivered_by;
    }

    public void setCustom(JsonElement custom) {
        this.custom = custom;
    }

    public int getTicket_number() {
        return ticket_number;
    }

    public char getStatus() {
        return status;
    }

    public double getTotal_price() {
        return total_price;
    }

    public double getTotal_paid() {
        return total_paid;
    }

    public double getTotal_paid_with_points() {
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

    public int getCustomer_id() {
        return customer_id;
    }

    public int getDelivered_by() {
        return delivered_by;
    }

    public JsonElement getCustom() {
        return custom;
    }
}
