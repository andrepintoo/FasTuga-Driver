package ipleiria.taes.fastugadriver.fragments;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import ipleiria.taes.fastugadriver.MainActivity;
import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.model.order.OrderModelArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableOrdersFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_available_orders, container, false);
        LinearLayout layout = view.findViewById(R.id.LinearLayoutOrders);

        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);
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
                    Button buttonOrder = new Button(getActivity());
                    buttonOrder.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
                    buttonOrder.setText(buttonText);
                    buttonOrder.setId(orderID);
                    buttonOrder.setGravity(Gravity.LEFT);

                    System.out.println("DEBUGGGGGGG");
                    System.out.println("TEXTO:" +buttonOrder.getText());
                    System.out.println("ID:"+buttonOrder.getId());
                    System.out.println(buttonOrder);

                    //add button to the layout
                    layout.addView(buttonOrder);

                    buttonOrder.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           /* Intent intent = new Intent(MainActivity.this, OrderDetailsActivity.class);
                            intent.putExtra("orderID",String.valueOf(orderID));
                            startActivity(intent);*/
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<List<OrderModelArray>> call, Throwable t) {
                Log.e(TAG, "onFailure : " + t.getMessage());
            }

        });

        return view;
    }
}