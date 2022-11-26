package ipleiria.taes.fastugadriver.fragments;

import android.content.Intent;
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

import com.google.gson.JsonObject;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.OrderService;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.model.order.OrderModelObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailsFragment extends Fragment {

    private static final String TAG = "OrderDetailsActivity";

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_order_details, container, false);
        Fragment map_fragment = new MapFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, map_fragment).commit();

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

        //textOrderNumberInput.setText("OrderID");
        textClientInput.setText("Information");
        textClientPhoneInput.setText("Phone Number");
        textLocationInput.setText("Client Location");
        textDistanceInput.setText("Distance km");
        textEarningInput.setText("Earning €");

        //receives the data
        Bundle bundle = getArguments();
        int orderID = 0;
        Character orderStatus = null;
        //stores in orderID
        if (bundle != null) {
            orderID = bundle.getInt("orderID");
            orderStatus = bundle.getChar("orderStatus");
        }

        if(orderStatus == 'R'){
            buttonAccept.setVisibility(View.VISIBLE);
            buttonComplete.setVisibility(View.GONE);
            buttonClaim.setVisibility(View.GONE);
        }

        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);
        Call<OrderModelObject> order = service.getOrder(5);


        int finalOrderID = orderID;
        order.enqueue(new Callback<OrderModelObject>() {
            @Override
            public void onResponse(Call<OrderModelObject> call, Response<OrderModelObject> response) {
                textOrderNumberInput.setText(""+finalOrderID);
            }

            @Override
            public void onFailure(Call<OrderModelObject> call, Throwable t) {
                Log.e(TAG, "onFailure : "+ t.getMessage());
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle sends data to the other fragment
                Fragment fragment = new AvailableOrdersFragment();
                replaceFragment(fragment);
            }

            public void replaceFragment(Fragment someFragment) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.remove(AvailableOrdersFragment.this);
                transaction.replace(R.id.navHostFragment, someFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;


    }

}