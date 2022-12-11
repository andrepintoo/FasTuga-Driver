package ipleiria.taes.fastugadriver.fragments;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.osmdroid.bonuspack.routing.OSRMRoadManager;
import org.osmdroid.bonuspack.routing.Road;
import org.osmdroid.bonuspack.routing.RoadManager;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.entities.OrderButton;
import ipleiria.taes.fastugadriver.entities.OrderNotification;
import ipleiria.taes.fastugadriver.managers.UserManager;
import ipleiria.taes.fastugadriver.model.order.OrderModelArray;
import ipleiria.taes.fastugadriver.model.order.OrderModelDataArray;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AvailableOrdersFragment extends Fragment {

    private static final String TAG = "AvailableOrdersFragment";
    private View view;
    private Button buttonOrder;
    private GridLayout assignedOrdersGrid;
    private GridLayout availableOrdersGrid;
    private TextView textViewBalance;

    private final GeoPoint restaurantPoint = new GeoPoint(39.73240919913415, -8.824827700055856);
    int countClicks;
    private static int FASTUGADRIVER = 15;

    private String claimedIDString;
    private String clientAddress;
    private double clientLongitude;
    private double clientLatitude;

    private boolean hasAssignedOrders;
    private boolean hasAvailableOrders;

    private Button buttonFilterFurthestAssigned;
    private Button buttonFilterClosestAssigned;

    private Button buttonFilterFurthestAvailable;
    private Button buttonFilterClosestAvailable;

    LinkedList<OrderButton> orderButtons = new LinkedList<>();
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Need to add this to connect to map network
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_available_orders, container, false);

        //Define Available Orders Scroll View with Grid Layout
        availableOrdersLayout();

        //Define Assigned Orders Scroll View with Grid Layout
        assignedOrdersLayout();

        // Define buttons
        buttonFilterFurthestAssigned = view.findViewById(R.id.buttonFilterFurthestAssigned);
        buttonFilterFurthestAvailable = view.findViewById(R.id.buttonFilterFurthestAvailable);
        buttonFilterClosestAvailable = view.findViewById(R.id.buttonFilterClosestAvailable);
        buttonFilterClosestAssigned = view.findViewById(R.id.buttonFilterClosestAssigned);

        //Balance Update for logged user
        updateBalance();

        // Gets Orders that are Ready and Preparing
        fetchOrders();

        if (!hasAvailableOrders) {
            TextView noAvailableOrders = new TextView(getContext());
            noAvailableOrders.setText("No orders Available");
            availableOrdersGrid.addView(noAvailableOrders);
        }
        if (!hasAssignedOrders) {
            TextView noAssignedOrders = new TextView(getContext());
            noAssignedOrders.setText("No assigned Orders");
            assignedOrdersGrid.addView(noAssignedOrders);
        }

        buttonFilterFurthestAssigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeButtonsFromView();
                sortListByFurthest();
                addButtonsToView();
            }
        });

        buttonFilterClosestAssigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeButtonsFromView();
                sortListByClosest();
                addButtonsToView();
            }
        });

        buttonFilterFurthestAvailable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeButtonsFromView();
                sortListByFurthest();
                addButtonsToView();
            }
        });

        buttonFilterClosestAvailable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeButtonsFromView();
                sortListByClosest();
                addButtonsToView();
            }
        });

        // Swipe Refresh
        swipeRefreshLayout = view.findViewById(R.id.availableOrdersFragment);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            Fragment fragment = new AvailableOrdersFragment();
            replaceFragment(fragment);

            swipeRefreshLayout.setRefreshing(false);
        });

        return view;
    }

    private void addButtonsToView() {
        for (OrderButton orderButton : orderButtons) {
            if (orderButton.getStatus().equals("Available")) {
                availableOrdersGrid.addView(orderButton.getButton());
            } else {
                assignedOrdersGrid.addView(orderButton.getButton());
            }
        }
    }

    private void removeButtonsFromView() {
        for (OrderButton orderButton : orderButtons) {
            GridLayout layout = (GridLayout) orderButton.getButton().getParent();
            layout.removeView(orderButton.getButton());
        }
    }

    private void sortListByFurthest() {
        Collections.sort(orderButtons, new Comparator<OrderButton>() {
            @Override
            public int compare(OrderButton o1, OrderButton o2) {
                return (int) Math.ceil(o2.getDistance()) - (int) Math.ceil(o1.getDistance());
            }
        });
    }

    private void sortListByClosest() {
        Collections.sort(orderButtons, new Comparator<OrderButton>() {
            @Override
            public int compare(OrderButton o1, OrderButton o2) {
                return (int) Math.ceil(o1.getDistance()) - (int) Math.ceil(o2.getDistance());
            }
        });
    }

    public void replaceFragment(Fragment someFragment) {
        assert getFragmentManager() != null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.navHostFragment, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void updateBalance() {
        textViewBalance = (TextView) view.findViewById(R.id.textViewBalance);
        int balance = UserManager.getManager().getLoggedUserBalance();
        textViewBalance.setText(String.valueOf(balance));
    }

    private void assignedOrdersLayout() {
        ScrollView scrollViewAssignedOrders = (ScrollView) view.findViewById(R.id.ScrollViewAssignedOrders);
        assignedOrdersGrid = new GridLayout(scrollViewAssignedOrders.getContext());
        assignedOrdersGrid.setColumnCount(2);
        scrollViewAssignedOrders.addView(assignedOrdersGrid);

        hasAssignedOrders = false;
    }

    private void availableOrdersLayout() {
        ScrollView scrollViewAvailableOrders = (ScrollView) view.findViewById(R.id.ScrollViewAvailableOrders);
        availableOrdersGrid = new GridLayout(scrollViewAvailableOrders.getContext());
        availableOrdersGrid.setColumnCount(2);
        scrollViewAvailableOrders.addView(availableOrdersGrid);

        hasAvailableOrders = false;
    }

    private void fetchOrders() {
        // Creates Service
        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);

        // Creates Call interface for API (Retrofit)
        Call<OrderModelDataArray> orders = service.getOrderByStatus();

        // Calls API
        try {
            Response<OrderModelDataArray> response = orders.execute();
            assert response.body() != null;
            displayOrders(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void displayOrders(Response<OrderModelDataArray> response) {
        assert response.body() != null;
        ArrayList<OrderModelDataArray.data> orders = response.body().getOrders();

        for (OrderModelDataArray.data order : orders) {

            // Get JSON Custom, not the best way but it works...
            JsonElement customClientDetails = order.getCustom();
            String[] customClientDetailsString = customClientDetails.getAsString().split("\"");

            // Setting variables
            int orderID = order.getId();
            char orderStatusChar = order.getStatus();
            int index = 0;
            for (String word : customClientDetailsString) {
                if (word.equals("address")) {
                    clientAddress = customClientDetailsString[index + 2];
                }
                if (word.equals("claim")) {
                    claimedIDString = customClientDetailsString[index + 2];
                }
                if (word.equals("latitude")) {
                    clientLatitude = Double.parseDouble(customClientDetailsString[index + 2]);
                }
                if (word.equals("longitude")) {
                    clientLongitude = Double.parseDouble(customClientDetailsString[index + 2]);
                }
                index++;
            }
            int claimedID = claimedIDString.equals("null") ? 0 : Integer.parseInt(claimedIDString);

            double[] distanceKmAndTimeMinutes = getDistanceKmAndTimeInMinutesFromRestaurantToClient(restaurantPoint.getLatitude(), restaurantPoint.getLongitude(), clientLatitude, clientLongitude);
            double distance = distanceKmAndTimeMinutes[0];
            double duration = distanceKmAndTimeMinutes[1];

            String clientName = setClientName((JsonObject) order.getCustomer_id());
            String clientPhoneNumber = setClientPhoneNumber((JsonObject) order.getCustomer_id());
            JsonObject deliveredByUser = (JsonObject) order.getDelivered_by();

            String status;
            switch (orderStatusChar) {
                case 'P':
                    if (deliveredByUser.get("id").isJsonNull()) {
                        status = "Available";
                        hasAvailableOrders = true;
                    } else {
                        status = "Preparing";
                        hasAssignedOrders = true;
                    }
                    break;
                case 'R':
                    if (deliveredByUser.get("id").isJsonNull()) {
                        status = "Available";
                        hasAvailableOrders = true;
                    } else if (claimedID == 0) { //&& deliveredByUser.get("id").getAsInt()==FASTUGADRIVER
                        status = "Ready to Claim";
                        hasAssignedOrders = true;
                    } else {
                        status = "Delivering";
                        hasAssignedOrders = true;
                    }
                    break;
                default:
                    status = "";
                    break;
            }

            int earning = setEarning(distance);
            String buttonText = getAvailableOrdersText(orderID, duration, distance, earning, status);

            setButtonProperties(buttonText, orderID);

            if (orderStatusChar == 'R') {
                String buttonTitleText = "Order " + orderID + " is Ready to be Claimed";
                String buttonContextText = "Please Claim the following order to be delivered";
                showNotification(buttonTitleText, buttonContextText);

                // Add Ready Notification to Notification Manager
                OrderNotification readyNotification = new OrderNotification(orderID, buttonTitleText, buttonContextText, new Date());
                ipleiria.taes.fastugadriver.managers.NotificationManager.getManager().addToOrdersReadyNotification(readyNotification);
            }

            // Add Buttons to LinkedList
            OrderButton orderButton = new OrderButton(buttonOrder, status, distance);
            orderButtons.add(orderButton);

            countClicks = 0;
            buttonOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    countClicks++;

                    Handler handler = new Handler();
                    handler.postDelayed(() -> {
                        if (countClicks == 1) { // If button is pressed once

                            JsonObject deliveredByUser = (JsonObject) order.getDelivered_by();
                            int deliveredId = 0;
                            if (!deliveredByUser.get("id").isJsonNull()) {
                                deliveredId = deliveredByUser.get("id").getAsInt();
                            }

                            JsonElement customer = !order.getCustomer_id().isJsonNull() ? ((JsonObject) order.getCustomer_id()).get("id") : null;

                            assert customer != null;
                            Fragment fragment = goToOrderDetailsFragment(orderID, clientName, clientPhoneNumber, clientAddress, distance,
                                    earning, clientLatitude, clientLongitude, restaurantPoint.getLatitude(), restaurantPoint.getLongitude(),
                                    deliveredId, claimedID, order.getTicket_number(), orderStatusChar, customer.getAsInt(), order.getTotal_price(),
                                    order.getTotal_paid(), order.getTotal_paid_with_points(), order.getPoints_gained(),
                                    order.getPoints_used_to_pay(), order.getPayment_type(), order.getPayment_reference(), order.getDate(), order.getUpdated_at());

                            replaceFragment(fragment);
                        } else if (countClicks == 2) { // If button is pressed twice
                            // Creates JSON
                            OrderModelArray updateOrder = new OrderModelArray();
                            JsonElement customerID = ((JsonObject) order.getCustomer_id()).get("id");

                            updateOrder.setTicket_number(order.getTicket_number());
                            updateOrder.setStatus(orderStatusChar);
                            updateOrder.setCustomer_id(customerID.getAsInt());
                            updateOrder.setTotal_price(order.getTotal_price());
                            updateOrder.setTotal_paid(order.getTotal_paid());
                            updateOrder.setTotal_paid_with_points(order.getTotal_paid_with_points());
                            updateOrder.setPoints_gained(order.getPoints_gained());
                            updateOrder.setPoints_used_to_pay(order.getPoints_used_to_pay());
                            updateOrder.setPayment_type(order.getPayment_type());
                            updateOrder.setPayment_reference(order.getPayment_reference());
                            updateOrder.setDate(order.getDate());
                            updateOrder.setDelivered_by(FASTUGADRIVER);
                            JsonObject custom = new JsonObject();
                            custom.addProperty("claim", "null");
                            custom.addProperty("address", customClientDetailsString[7]);
                            custom.addProperty("latitude", customClientDetailsString[11]);
                            custom.addProperty("longitude", customClientDetailsString[15]);
                            updateOrder.setCustom(custom);

                            updateOrder(orderID, updateOrder);

                            Fragment fragment = new AvailableOrdersFragment();
                            replaceFragment(fragment);
                        }
                        countClicks = 0;
                    }, 500);
                }


            });
        }

        for (OrderButton orderButton : orderButtons) {
            if (orderButton.getStatus().equals("Available")) {
                availableOrdersGrid.addView(orderButton.getButton());
            } else {
                assignedOrdersGrid.addView(orderButton.getButton());
            }
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

    private double[] getDistanceKmAndTimeInMinutesFromRestaurantToClient(double restaurantLatitude, double restaurantLongitude,
                                                                         double clientLatitude, double clientLongitude) {
        Configuration.getInstance().setUserAgentValue("MyOwnUserAgent/1.0");
        ArrayList<GeoPoint> waypoints = new ArrayList<>();
        GeoPoint restaurant = new GeoPoint(restaurantLatitude, restaurantLongitude);
        GeoPoint client = new GeoPoint(clientLatitude, clientLongitude);

        waypoints.add(restaurant);
        waypoints.add(client);

        RoadManager roadManager = new OSRMRoadManager(getContext(), Configuration.getInstance().getUserAgentValue());
        Road road = roadManager.getRoad(waypoints);

        double totalSecs = road.mDuration;
        double minutes = (totalSecs % 3600) / 60;

        double[] distanceAndMinutes = new double[2];
        distanceAndMinutes[0] = road.mLength;
        distanceAndMinutes[1] = minutes;
        return distanceAndMinutes;
    }

    @SuppressLint("DefaultLocale")
    private String getAvailableOrdersText(int orderId, double minutes, double distance,
                                          int earning, String status) {
        return "Order: " + orderId + "\n" +
                "Distance: " + String.format("%.2f", distance) + " km\n" +
                "Duration: " + String.format("%.2f", minutes) + " min\n" +
                "Earning: " + earning + "€\n" +
                "Status: " + status;
    }

    private int setEarning(double distance) {
        if (distance < 3) {
            return 2;
        } else if (distance < 10) {
            return 3;
        }
        return 4;
    }

    private Fragment goToOrderDetailsFragment(int orderId, String clientName, String clientPhoneNumber, String clientAddress,
                                              double distance, int earning, double clientLatitude, double clientLongitude,
                                              double restaurantLatitude, double restaurantLongitude, int deliveredId, int claimedId,
                                              int ticketNumber, char orderStatus, int customerId, double totalPrice,
                                              double totalPaid, double totalPaidWithPoints, int pointsGained,
                                              int pointsUsedToPay, String paymentType, String paymentReference, String date, String updated_at) {
        Bundle args = new Bundle();
        args.putInt("orderID", orderId);
        args.putString("clientName", clientName);
        args.putString("clientPhoneNumber", clientPhoneNumber);
        args.putString("clientAddress", clientAddress);
        args.putDouble("distance", distance);
        args.putInt("earning", earning);
        args.putDouble("clientLatitude", clientLatitude);
        args.putDouble("clientLongitude", clientLongitude);
        args.putDouble("restaurantLatitude", restaurantLatitude);
        args.putDouble("restaurantLongitude", restaurantLongitude);
        args.putInt("deliveredId", deliveredId);
        args.putInt("claimedId", claimedId);
        args.putInt("ticketNumber", ticketNumber);
        args.putChar("orderStatus", orderStatus);
        args.putInt("customerId", customerId);
        args.putDouble("totalPrice", totalPrice);
        args.putDouble("totalPaid", totalPaid);
        args.putDouble("totalPaidWithPoints", totalPaidWithPoints);
        args.putInt("pointsGained", pointsGained);
        args.putInt("pointsUsedToPay", pointsUsedToPay);
        args.putString("paymentType", paymentType);
        args.putString("paymentReference", paymentReference);
        args.putString("date", date);
        args.putString("updated_at", updated_at);
        Fragment fragment = new OrderDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void showNotification(String title, String context) {
        String CHANNEL_ID = "ReadyOrderNotification";
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Ready Order", NotificationManager.IMPORTANCE_DEFAULT);
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

    public String setClientName(JsonObject customer) {
        JsonObject user = customer.getAsJsonObject("user_id");
        String name = user.get("name").toString();
        return name.replace("\"", "");
    }

    private String setClientPhoneNumber(JsonObject customer) {
        String number = customer.get("phone").toString();
        return number.replace("\"", "");
    }

    public String setOrderStatus(char orderStatus) {
        if (orderStatus == 'R') {
            return "Ready to pick";
        } else if (orderStatus == 'P') {
            return "Preparing...";
        }
        return "Not Defined";
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
        marginParams.setMargins(0, 30, 30, 40);

        buttonOrder.setLayoutParams(marginParams);
        buttonOrder.setPadding(0, 30, 0, 40);
    }
}