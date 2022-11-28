package ipleiria.taes.fastugadriver.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.model.order.OrderModelArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableOrdersFragment extends Fragment {

    private static final String TAG = "AvailableOrdersFragment";
    private LinearLayout layout;
    private Button buttonOrder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_available_orders, container, false);

        // Define Layout
        layout = view.findViewById(R.id.LinearLayoutOrders);

        // Gets Available Orders
        fetchOrders();

        return view;
    }

    private void fetchOrders() {
        // Creates Service
        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);

        // Creates Call interface for API (Retrofit)
        Call<List<OrderModelArray>> orders = service.getOrderByStatus('R');

        // Calls API
        orders.enqueue(new Callback<List<OrderModelArray>>() {
            @SuppressLint("RtlHardcoded")
            @Override
            public void onResponse(@NonNull Call<List<OrderModelArray>> call, @NonNull Response<List<OrderModelArray>> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
                displayOrders(response);
            }

            @Override
            public void onFailure(@NonNull Call<List<OrderModelArray>> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure : " + t.getMessage());
            }

        });
    }

    private void displayOrders(Response<List<OrderModelArray>> response) {
        List<OrderModelArray> orders = response.body();

        assert orders != null;
        for (OrderModelArray order : orders) {
            int orderID = order.getId();
            char orderStatus = order.getStatus();

            String buttonText = "Order: " + orderID + "\n" +
                    "Location: " + "<Street>" + "\n" +
                    "Distance: " + "<Number>" + " km\n" +
                    "Earning: " + "<Number>" + " €\n" +
                    "Status: " + orderStatus;

            setButtonProperties(buttonText, orderID);

            // Add Button to Layout
            layout.addView(buttonOrder);

            buttonOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Bundle sends data to the other fragment
                    Bundle args = new Bundle();
                    args.putInt("orderID", orderID);
                    args.putChar("orderStatus", orderStatus);
                    Fragment fragment = new OrderDetailsFragment();
                    fragment.setArguments(args);
                    replaceFragment(fragment);
                }

                public void replaceFragment(Fragment someFragment) {
                    assert getFragmentManager() != null;
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    //transaction.remove(AvailableOrdersFragment.this);
                    transaction.replace(R.id.navHostFragment, someFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }
    }

    @SuppressLint("RtlHardcoded")
    private void setButtonProperties(String buttonText, int orderID) {
        buttonOrder = new Button(getActivity());
        buttonOrder.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        buttonOrder.setText(buttonText);
        buttonOrder.setId(orderID);
        buttonOrder.setGravity(Gravity.LEFT);
    }
}