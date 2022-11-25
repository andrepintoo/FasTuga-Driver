package ipleiria.taes.fastugadriver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.transition.Slide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import ipleiria.taes.fastugadriver.activities.LoginActivity;
//import ipleiria.taes.fastugadriver.activities.OrderDetailsActivity;
import ipleiria.taes.fastugadriver.activities.RegisterActivity;
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

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        //LinearLayout layout = findViewById(R.id.LinearLayoutOrders);

       /* OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);
        Call<List<OrderModelArray>> orders = service.getOrderByStatus('R');

        orders.enqueue(new Callback<List<OrderModelArray>>() {
            @SuppressLint("RtlHardcoded")
            @Override
            public void onResponse(Call<List<OrderModelArray>> call, Response<List<OrderModelArray>> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
                List<OrderModelArray> data = response.body();
                for (OrderModelArray order : data) {
                    int orderID = order.getId();
                    char orderStatus = order.getStatus();
                    Log.e(TAG, "onResponse: " + orderID);
                    Log.e(TAG, "onResponse: " + orderStatus);
                    String buttonText = "Order: " + orderID + "\n" +
                            "Location: " + "<Street>" + "\n" +
                            "Distance: " + "<Number>" + " km\n" +
                            "Earning: " + "<Number>" + " €\n" +
                            "Status: " + orderStatus;

                    //set the properties for button
                    Button buttonOrder = new Button(MainActivity.this);
                    buttonOrder.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    buttonOrder.setText(buttonText);
                    buttonOrder.setId(orderID);
                    buttonOrder.setGravity(Gravity.LEFT);

                    //add button to the layout
                    layout.addView(buttonOrder);

                    buttonOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           /* Intent intent = new Intent(MainActivity.this, OrderDetailsActivity.class);
                            intent.putExtra("orderID",String.valueOf(orderID));
                            startActivity(intent);*/
                        //}
                  /*  });
                }

            }

            @Override
            public void onFailure(Call<List<OrderModelArray>> call, Throwable t) {
                Log.e(TAG, "onFailure : "+ t.getMessage());
            }
        });*/


    }
}