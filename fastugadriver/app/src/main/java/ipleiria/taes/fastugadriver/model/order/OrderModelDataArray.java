package ipleiria.taes.fastugadriver.model.order;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class OrderModelDataArray {
    ArrayList<OrderModelDataArray.data> data;

    public ArrayList<OrderModelDataArray.data> getOrders() {
        return data;
    }

    public class data {
        int id;
        int ticket_number;
        char status;
        JsonElement customer_id;
        float total_price;
        float total_paid;
        float total_paid_with_points;
        int points_gained;
        int points_used_to_pay;
        String payment_type;
        String payment_reference;
        String date;
        String updated_at;
        JsonElement delivered_by;
        JsonElement custom;

        public String getUpdated_at() {
            return updated_at;
        }

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

        public JsonElement getCustom() {
            return custom;
        }

        public JsonElement getCustomer_id() {
            if (customer_id.isJsonNull()) {
                JsonObject emptyJson = new JsonObject();
                emptyJson.add("id",null);
                return emptyJson;
            }
            return (JsonObject) customer_id;
        }

        public JsonElement getDelivered_by() {
            if (delivered_by.isJsonNull()) {
                JsonObject emptyJson = new JsonObject();
                emptyJson.add("id",null);
                return emptyJson;
            }
            return (JsonObject) delivered_by;
        }
    }
}
