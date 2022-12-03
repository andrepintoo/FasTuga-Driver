package ipleiria.taes.fastugadriver.fragments;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import ipleiria.taes.fastugadriver.MainActivity;
import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.model.order.OrderModelArray;
import ipleiria.taes.fastugadriver.model.order.OrderModelObject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailsFragment extends Fragment {

    private static final String TAG = "OrderDetailsActivity";

    private View view;
    private TextView textOrderNumberInput;
    private TextView textClientInput;
    private TextView textClientPhoneInput;
    private TextView textLocationInput;
    private TextView textDistanceInput;
    private TextView textEarningInput;
    private Button buttonBack;
    private Button buttonAssign;
    private Button buttonDelivered;
    private Button buttonCancelOrder;

    private int orderID;
    private String clientName;
    private String clientPhoneNumber;
    private String clientAddress;
    private double distance;
    private int earning;
    private int driverID;
    private Bundle bundle;
    private int ticketNumber;
    private char orderStatus;
    private int customerId;
    private double totalPrice;
    private double totalPaid;
    private double totalPaidWithPoints;
    private int pointsGained;
    private int pointsUsedToPay;
    private String paymentType;
    private String paymentReference;
    private String date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order_details, container, false);

        // Receive Previous Data
        bundle = getArguments();

        showMapFragment();

        defineLayoutElements();
        setLayoutElementsText();

        showOrder();

        goBackButton();
        return view;
    }

    private void showMapFragment() {
        Bundle mapArgs = new Bundle();
        mapArgs.putDouble("clientLatitude", bundle.getDouble("clientLatitude"));
        mapArgs.putDouble("clientLongitude", bundle.getDouble("clientLongitude"));
        mapArgs.putDouble("restaurantLatitude", bundle.getDouble("restaurantLatitude"));
        mapArgs.putDouble("restaurantLongitude", bundle.getDouble("restaurantLongitude"));
        Fragment map_fragment = new MapFragment();
        map_fragment.setArguments(mapArgs);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, map_fragment).commit();
    }

    private void showOrder() {
        // Values received from AvailableOrdersFragment
        receiveSpecificOrderValuesFromChoosenOrder();

        showButtons(driverID);

        fetchOrder();
    }

    private void receiveSpecificOrderValuesFromChoosenOrder() {
        orderID = bundle.getInt("orderID");
        clientName = bundle.getString("clientName");
        clientPhoneNumber = bundle.getString("clientPhoneNumber");
        clientAddress = bundle.getString("clientAddress");
        distance = bundle.getDouble("distance");
        earning = bundle.getInt("earning");
        driverID = bundle.getInt("driverId");
        ticketNumber = bundle.getInt("ticketNumber");
        orderStatus = bundle.getChar("orderStatus");
        customerId = bundle.getInt("customerId");
        totalPrice = bundle.getDouble("totalPrice");
        totalPaid = bundle.getDouble("totalPaid");
        totalPaidWithPoints = bundle.getDouble("totalPaidWithPoints");
        pointsGained = bundle.getInt("pointsGained");
        pointsUsedToPay = bundle.getInt("pointsUsedToPay");
        paymentType = bundle.getString("paymentType");
        paymentReference = bundle.getString("paymentReference");
        date = bundle.getString("date");
    }

    private void showButtons(int driverID) {
        if (driverID == 0) {
            buttonBack.setVisibility(View.VISIBLE);
            buttonAssign.setVisibility(View.VISIBLE);
            buttonAssign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OrderModelArray updateOrder = new OrderModelArray();

                    updateOrder.setTicket_number(ticketNumber);
                    updateOrder.setStatus(orderStatus);
                    updateOrder.setCustomer_id(customerId);
                    updateOrder.setTotal_price(totalPrice);
                    updateOrder.setTotal_paid(totalPaid);
                    updateOrder.setTotal_paid_with_points(totalPaidWithPoints);
                    updateOrder.setPoints_gained(pointsGained);
                    updateOrder.setPoints_used_to_pay(pointsUsedToPay);
                    updateOrder.setPayment_type(paymentType);
                    updateOrder.setPayment_reference(paymentReference);
                    updateOrder.setDate(date);
                    updateOrder.setDelivered_by(15);
                    JsonObject custom = new JsonObject();
                    custom.addProperty("address", clientAddress);
                    custom.addProperty("latitude", String.valueOf(bundle.getDouble("clientLatitude")));
                    custom.addProperty("longitude", String.valueOf(bundle.getDouble("clientLongitude")));
                    updateOrder.setCustom(custom);

                    updateOrder(orderID, updateOrder);

                    // Goes back to AvailableOrders, shows order on Assigned Orders
                    Fragment fragment = new AvailableOrdersFragment();
                    assert getFragmentManager() != null;
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.navHostFragment, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        } else {
            buttonBack.setVisibility(View.VISIBLE);
            buttonDelivered.setVisibility(View.VISIBLE);
        }
    }

    private void updateOrder(int id, OrderModelArray body) {
        // Creates Service
        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);

        // Creates Call interface for API (Retrofit)
        Call<ResponseBody> call = service.updateOrder(id, body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure : " + t.getMessage());
            }
        });
    }

    private void fetchOrder() {
        // Creates Service
        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);

        // Creates Order
        Call<OrderModelObject> order = service.getOrder(orderID);

        // Calls API
        order.enqueue(new Callback<OrderModelObject>() {
            @Override
            public void onResponse(@NonNull Call<OrderModelObject> call, @NonNull Response<OrderModelObject> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
                setOrderDetailsText(orderID, clientName, clientPhoneNumber, clientAddress, distance, earning);
            }

            @Override
            public void onFailure(@NonNull Call<OrderModelObject> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure : " + t.getMessage());
            }
        });
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    private void setOrderDetailsText(int orderID, String clientName, String clientPhoneNumber, String clientAddress, double distance, int earning) {
        textOrderNumberInput.setText(String.valueOf(orderID));
        textClientInput.setText(clientName);
        textClientPhoneInput.setText(clientPhoneNumber);
        textLocationInput.setText(clientAddress);
        textDistanceInput.setText(String.format("%.2f", distance) + " Km");
        textEarningInput.setText(earning + " €");
    }

    private void goBackButton() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle sends data to the other fragment
                Fragment fragment = new AvailableOrdersFragment();
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

    private boolean isOrderReady(char orderStatus) {
        return orderStatus == 'R';
    }

    @SuppressLint("SetTextI18n")
    private void setLayoutElementsText() {
        //textOrderNumberInput.setText("OrderID");
        textClientInput.setText("Information");
        textClientPhoneInput.setText("Phone Number");
        textLocationInput.setText("Client Location");
        textDistanceInput.setText("Distance km");
        textEarningInput.setText("Earning €");
    }

    private void defineLayoutElements() {
        textOrderNumberInput = (TextView) view.findViewById(R.id.textOrderNumberInput);
        textClientInput = (TextView) view.findViewById(R.id.textClientInput);
        textClientPhoneInput = (TextView) view.findViewById(R.id.textClientPhoneInput);
        textLocationInput = (TextView) view.findViewById(R.id.textLocationInput);
        textDistanceInput = (TextView) view.findViewById(R.id.textDistanceInput);
        textEarningInput = (TextView) view.findViewById(R.id.textEarningInput);
        buttonBack = (Button) view.findViewById(R.id.buttonBack);
        buttonAssign = (Button) view.findViewById(R.id.buttonAssign);
        buttonDelivered = (Button) view.findViewById(R.id.buttonDelivered);
        buttonCancelOrder = (Button) view.findViewById(R.id.buttonCancelOrder);
    }
}