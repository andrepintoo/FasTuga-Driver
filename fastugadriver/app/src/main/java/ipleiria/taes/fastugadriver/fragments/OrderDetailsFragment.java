package ipleiria.taes.fastugadriver.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ipleiria.taes.fastugadriver.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderDetailsFragment extends Fragment {
    private TextView textOrderNumberInput;
    private TextView textClientInput;
    private TextView textClientPhoneInput;
    private TextView textLocationInput;
    private TextView textDistanceInput;
    private TextView textEarningInput;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AvailableOrdersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderDetailsFragment newInstance(String param1, String param2) {
        OrderDetailsFragment fragment = new OrderDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Fragment fragment = new MapFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_order_details, container, false);

        textOrderNumberInput = (TextView) view.findViewById(R.id.textOrderNumberInput);
        textClientInput = (TextView) view.findViewById(R.id.textClientInput);
        textClientPhoneInput = (TextView) view.findViewById(R.id.textClientPhoneInput);
        textLocationInput = (TextView) view.findViewById(R.id.textLocationInput);
        textDistanceInput = (TextView) view.findViewById(R.id.textDistanceInput);
        textEarningInput = (TextView) view.findViewById(R.id.textEarningInput);
        textOrderNumberInput.setText("OrderID");
        textClientInput.setText("Information");
        textClientPhoneInput.setText("Phone Number");
        textLocationInput.setText("Client Location");
        textDistanceInput.setText("Distance km");
        textEarningInput.setText("Earning €");
        return view;


    }

}