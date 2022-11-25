package ipleiria.taes.fastugadriver.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.model.order.OrderModelArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Layout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Retrofit
        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);
        Call<List<OrderModelArray>> orders = service.getOrderByStatus('R');

        orders.enqueue(new Callback<List<OrderModelArray>>() {
            @Override
            public void onResponse(Call<List<OrderModelArray>> call, Response<List<OrderModelArray>> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
                List<OrderModelArray> data = response.body();
                for (OrderModelArray order : data) {
                    Log.e(TAG, "onResponse: " + order.getId());
                    Log.e(TAG, "onResponse: " + order.getStatus());
                    String buttonText = "Order: " + order.getId() + "\n" +
                            "Location: " + "\n" +
                            "Distance: " + " km\n" +
                            "Earning: " + " €\n" +
                            "Status: " + order.getStatus();
                    Button buttonOrder = new Button(MainActivity.this);
                    buttonOrder.setText(buttonText);
                    buttonOrder.setId(order.getId());
                    buttonOrder.setLayoutParams(params);
                    layout.addView(buttonOrder);

                    buttonOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this,OrderDetailsActivity.class);
                            intent.putExtra("orderID", String.valueOf(order.getId()));
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<OrderModelArray>> call, Throwable t) {
                Log.e(TAG, "onFailure : "+ t.getMessage());
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        this.addContentView(layout,layoutParams);
    }
}