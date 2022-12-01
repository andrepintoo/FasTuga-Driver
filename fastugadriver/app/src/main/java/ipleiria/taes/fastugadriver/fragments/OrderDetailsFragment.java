package ipleiria.taes.fastugadriver.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.model.order.OrderModelObject;
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
    private Button buttonAccept;
    private Button buttonClaim;
    private Button buttonComplete;

    private int orderID;
    private String clientName;
    private String clientPhoneNumber;
    private String clientAddress;
    private double distance;
    private int earning;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_order_details, container, false);
        Fragment map_fragment = new MapFragment();
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, map_fragment).commit();

        defineLayoutElements();
        setLayoutElementsText();

        showOrder();

        goBackButton();
        return view;
    }

    private void showOrder() {
        // Receive Previous Data
        Bundle bundle = getArguments();
        if (bundle == null)
            return;

        // Values received from AvailableOrdersFragment
        orderID = bundle.getInt("orderID");
        clientName = bundle.getString("clientName");
        clientPhoneNumber = bundle.getString("clientPhoneNumber");
        clientAddress = bundle.getString("clientAddress");
        distance = bundle.getDouble("distance");
        earning = bundle.getInt("earning");

        fetchOrder();
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
                setOrderDetailsText(orderID,clientName,clientPhoneNumber,clientAddress,distance,earning);
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

    private void showAcceptOrderButton() {
        buttonAccept.setVisibility(View.VISIBLE);
        buttonComplete.setVisibility(View.GONE);
        buttonClaim.setVisibility(View.GONE);
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
        buttonAccept = (Button) view.findViewById(R.id.buttonAccept);
        buttonClaim = (Button) view.findViewById(R.id.buttonClaim);
        buttonComplete = (Button) view.findViewById(R.id.buttonComplete);
    }

}