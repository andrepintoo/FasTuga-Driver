package ipleiria.taes.fastugadriver.fragments;

import static android.content.Context.NOTIFICATION_SERVICE;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Date;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.entities.OrderNotification;
import ipleiria.taes.fastugadriver.managers.UserManager;
import ipleiria.taes.fastugadriver.model.order.OrderModelArray;
import ipleiria.taes.fastugadriver.model.order.OrderModelObject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailsFragment extends Fragment {

    private static final String TAG = "OrderDetailsActivity";
    private final char ORDER_CANCELED = 'C';
    private final char ORDER_DELIVERED = 'D';

    private static int FASTUGADRIVER = 15;

    private View view;
    private TextView textOrderNumberInput;
    private TextView textClientInput;
    private TextView textClientPhoneInput;
    private TextView textLocationInput;
    private TextView textDistanceInput;
    private TextView textEarningInput;
    private EditText textReasonCancel;
    private Button buttonBack;
    private Button buttonClaim;
    private Button buttonAssign;
    private Button buttonDelivered;
    private Button buttonCancelOrder;

    private int orderID;
    private String clientName;
    private String clientPhoneNumber;
    private String clientAddress;
    private double distance;
    private int earning;
    private int deliveredId;
    private int claimedId;
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
    private String updated_at;

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
        receiveSpecificOrderValuesFromChosenOrder();

        showButtons(deliveredId, claimedId, orderStatus);

        fetchOrder();
    }

    private void receiveSpecificOrderValuesFromChosenOrder() {
        orderID = bundle.getInt("orderID");
        clientName = bundle.getString("clientName");
        clientPhoneNumber = bundle.getString("clientPhoneNumber");
        clientAddress = bundle.getString("clientAddress");
        distance = bundle.getDouble("distance");
        earning = bundle.getInt("earning");
        claimedId = bundle.getInt("claimedId");
        deliveredId = bundle.getInt("deliveredId");
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
        updated_at = bundle.getString("updated_at");
    }

    private void showButtons(int deliveredId, int claimedId, char orderStatus) {
        if (deliveredId == 0) {
            buttonBack.setVisibility(View.VISIBLE);
            buttonAssign.setVisibility(View.VISIBLE);
            buttonAssign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OrderModelArray json = createJson(orderStatus);
                    updateOrder(orderID, json);
                    goBackToAvailableOrders();
                }
            });
        } else if (claimedId == 0 && orderStatus == 'R') {
            buttonBack.setVisibility(View.VISIBLE);
            buttonClaim.setVisibility(View.VISIBLE);
            buttonClaim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OrderModelArray json = createJson(orderStatus);
                    //atualizar updated_at
                    updateOrder(orderID, json);
                    goBackToAvailableOrders();
                }
            });
        } else if (orderStatus != 'P') {
            buttonBack.setVisibility(View.VISIBLE);
            buttonCancelOrder.setVisibility(View.VISIBLE);
            buttonDelivered.setVisibility(View.VISIBLE);

            // Button Cancel Action
            buttonCancelOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater inflater = getActivity().getLayoutInflater();
                    View popupView = inflater.inflate(R.layout.popup_cancel_order, null);
                    textReasonCancel = (EditText) popupView.findViewById(R.id.textReasonCancel);

                    int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                    int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    boolean focusable = true;
                    final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                    popupWindow.setElevation(40);
                    popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                    popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                    Button yes_button = popupWindow.getContentView().findViewById(R.id.buttonYesCancel);
                    Button no_button = popupWindow.getContentView().findViewById(R.id.buttonNoCancel);

                    yes_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String reason = textReasonCancel.getText().toString();
                            OrderModelArray json = createJson(ORDER_CANCELED);
                            updateOrder(orderID, json);

                            String buttonTitleText = "Order " + orderID + " has been CANCELLED";
                            showNotification(buttonTitleText, reason);

                            // Add Cancelled Notification to Notification Manager - Cancelled List
                            OrderNotification cancelledOrderNotification = new OrderNotification(orderID, buttonTitleText, reason, new Date());
                            LinkedList<OrderNotification> cancelledOrderNotificationLinkedList = ipleiria.taes.fastugadriver.managers.NotificationManager.getManager().getOrdersCancelledNotification();
                            cancelledOrderNotificationLinkedList.add(cancelledOrderNotification);
                            // Remove Order from Ready Notification List
                            ipleiria.taes.fastugadriver.managers.NotificationManager.getManager().removeFromOrdersReadyNotification(orderID);


                            popupWindow.dismiss();
                            goBackToAvailableOrders();
                        }
                    });

                    no_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupWindow.dismiss();
                        }
                    });
                }
            });

            // Button Delivered Action
            buttonDelivered.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OrderModelArray json = createJson(ORDER_DELIVERED);
                    UserManager INSTANCE = UserManager.getManager();
                    INSTANCE.addCustomerServed(json.getCustomer_id());
                    INSTANCE.incrementDeliveryTime(getClaimedOrderTime());
                    updateOrder(orderID, json);
                    INSTANCE.updateBalance(earning);
                    INSTANCE.incrementDeliveries();
                    INSTANCE.incrementAverageSpeed(distance, getClaimedOrderTime().getMinute());
                    goBackToAvailableOrders();
                }
            });
        } else {
            buttonBack.setVisibility(View.VISIBLE);
        }
    }

    private LocalDateTime getClaimedOrderTime() {
        //2022-12-08T21:11:36.000000Z
        String[] dateStrings = updated_at.split("T");
        String calendarDate = dateStrings[0];
        String hourMinuteSeconds = dateStrings[1].split("\\.")[0];
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s", Locale.ENGLISH);
        return LocalDateTime.parse(calendarDate + " " + hourMinuteSeconds, dateTimeFormatter);
    }

    private void showNotification(String title, String context) {
        String CHANNEL_ID = "CancelOrderNotification";
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Cancel Order", NotificationManager.IMPORTANCE_DEFAULT);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.setLockscreenVisibility(NotificationCompat.VISIBILITY_PRIVATE);

        NotificationManager notificationManager = (NotificationManager) getSystemService(requireContext(), NotificationManager.class);
        assert notificationManager != null;
        notificationManager.createNotificationChannel(notificationChannel);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID);
        Notification notification = builder.setOngoing(true)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setContentTitle(title)
                .setContentText(context)
                .build();
        notificationManager.notify(0, notification);
    }

    private void goBackToAvailableOrders() {
        Fragment fragment = new AvailableOrdersFragment();
        assert getFragmentManager() != null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.navHostFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private OrderModelArray createJson(char orderStatus) {
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
        updateOrder.setDelivered_by(FASTUGADRIVER);
        updateOrder.setUpdated_at(updated_at);
        JsonObject custom = new JsonObject();
        if (deliveredId != 0) {
            custom.addProperty("claim", String.valueOf(FASTUGADRIVER));
        } else {
            custom.addProperty("claim", "null");
        }
        custom.addProperty("address", clientAddress);
        custom.addProperty("latitude", String.valueOf(bundle.getDouble("clientLatitude")));
        custom.addProperty("longitude", String.valueOf(bundle.getDouble("clientLongitude")));
        updateOrder.setCustom(custom);
        return updateOrder;
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
    private void setOrderDetailsText(int orderID, String clientName, String
            clientPhoneNumber, String clientAddress, double distance, int earning) {
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
        buttonClaim = (Button) view.findViewById(R.id.buttonClaim);
    }
}