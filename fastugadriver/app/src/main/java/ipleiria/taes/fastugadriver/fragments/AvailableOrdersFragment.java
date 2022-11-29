package ipleiria.taes.fastugadriver.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.List;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.model.order.OrderModelArray;
import ipleiria.taes.fastugadriver.model.order.OrderModelDataArray;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableOrdersFragment extends Fragment {

    private static final String TAG = "AvailableOrdersFragment";
    private View view;
    private Button buttonOrder;
    private GridLayout availableOrdersGrid;
    private GridLayout assignedOrdersGrid;
    private ScrollView scrollViewAvailableOrders;
    private ScrollView scrollViewAssignedOrders;

    private int orderID;
    private char orderStatus;
    private String[] customClientDetailsString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_available_orders, container, false);

        //Define Available Orders Scroll View with Grid Layout
        availableOrdersLayout();

        //Define Assigned Orders Scroll View with Grid Layout
        assignedOrdersLayout();

        // Gets Orders that are Ready
        fetchOrders('R');

        // Gets Orders that are Preparing
        fetchOrders('P');

        return view;
    }

    private void assignedOrdersLayout() {
        scrollViewAssignedOrders = (ScrollView) view.findViewById(R.id.ScrollViewAssignedOrders);
        assignedOrdersGrid = new GridLayout(scrollViewAssignedOrders.getContext());
        assignedOrdersGrid.setColumnCount(2);
        scrollViewAssignedOrders.addView(assignedOrdersGrid);
    }

    private void availableOrdersLayout() {
        scrollViewAvailableOrders = (ScrollView) view.findViewById(R.id.ScrollViewAvailableOrders);
        availableOrdersGrid = new GridLayout(scrollViewAvailableOrders.getContext());
        availableOrdersGrid.setColumnCount(2);
        scrollViewAvailableOrders.addView(availableOrdersGrid);
    }

    private void fetchOrders(char orderStatus) {
        // Creates Service
        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);

        // Creates Call interface for API (Retrofit)
        Call<OrderModelDataArray> orders = service.getOrderByStatus(orderStatus);

        // Calls API
        orders.enqueue(new Callback<OrderModelDataArray>() {
            @SuppressLint("RtlHardcoded")
            @Override
            public void onResponse(@NonNull Call<OrderModelDataArray> call, @NonNull Response<OrderModelDataArray> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
                displayOrders(response);
            }

            @Override
            public void onFailure(@NonNull Call<OrderModelDataArray> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure : " + t.getMessage());
            }

        });
    }

    private void displayOrders(Response<OrderModelDataArray> response) {

        assert response.body() != null;
        ArrayList<OrderModelDataArray.data> orders = response.body().getOrders();
        for (OrderModelDataArray.data order : orders) {
            orderID = order.getId();
            orderStatus = order.getStatus();
            // Not how I like it but it works
            JsonElement customClientDetails = order.getCustom();
            customClientDetailsString = customClientDetails.getAsString().split("\"");

            String buttonText = getAvailableOrdersText();

            setButtonProperties(buttonText, orderID);
            // Add Button to Layout
            assignedOrdersGrid.addView(buttonOrder);

            buttonOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = goToOrderDetailsFragment();
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

    private String getAvailableOrdersText() {
        return "Order: " + getOrderID() + "\n" +
                 "Location: " + getCustomClientDetailsString(3) + "\n" +
                 "Distance: " + "<Number>" + " km\n" +
                 "Earning: " + "<Number>" + " €\n" +
                 "Status: " + getOrderStatus();
    }

    private Fragment goToOrderDetailsFragment() {
        Bundle args = new Bundle();
        args.putInt("orderID", orderID);
        args.putChar("orderStatus", orderStatus);
        args.putString("orderAddress", getCustomClientDetailsString(3));
        Fragment fragment = new OrderDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getOrderStatus() {
        if (orderStatus == 'R') {
            return "Ready to pick up";
        } else if (orderStatus == 'P') {
            return "Preparing...";
        }
        return "Not Defined";
    }

    public String getCustomClientDetailsString(int index) {
        return customClientDetailsString[index];
    }

    @SuppressLint("RtlHardcoded")
    private void setButtonProperties(String buttonText, int orderID) {
        buttonOrder = new Button(getActivity());

        buttonOrder.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        buttonOrder.setText(buttonText);
        buttonOrder.setId(orderID);
        buttonOrder.setGravity(Gravity.LEFT);

        buttonOrder.setBackgroundColor(Color.BLACK);
        buttonOrder.setTextColor(Color.WHITE);

        ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        marginParams.setMargins(0,30,30,40);

        buttonOrder.setLayoutParams(marginParams);
        buttonOrder.setPadding(0,30,0,40);
    }
}