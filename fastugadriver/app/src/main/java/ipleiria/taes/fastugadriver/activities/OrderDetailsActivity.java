package ipleiria.taes.fastugadriver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonObject;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.model.order.OrderModelObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailsActivity extends AppCompatActivity {

    private static final String TAG = "OrderDetailsActivity";
    TextView receivedOrderID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        // Receive Order
        Intent intent = getIntent();
        int orderID = Integer.parseInt(intent.getStringExtra("orderID"));

        // Retrofit
        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);
        Call<OrderModelObject> order = service.getOrder(5);

        order.enqueue(new Callback<OrderModelObject>() {
            @Override
            public void onResponse(Call<OrderModelObject> call, Response<OrderModelObject> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
                JsonObject order = response.body().getOrder();
                JsonObject delivered_by = order.getAsJsonObject("delivered_by");
                Log.e(TAG, "onResponse: order : " +  delivered_by.get("name"));

                receivedOrderID = findViewById(R.id.textViewOrderDetails);
                String orderDetails = "Order: " + orderID + "\n" +
                        "Client: <name>" + "\n" +
                        "Client Phone Number: <Number>" + "\n" +
                        "Location: <Address>" + "\n" +
                        "Distance: <Value> km" + "\n" +
                        "Earning: <Value> €" + "\n";
                receivedOrderID.setText(orderDetails);
            }

            @Override
            public void onFailure(Call<OrderModelObject> call, Throwable t) {
                Log.e(TAG, "onFaulure : "+ t.getMessage());
            }
        });


    }
}