package ipleiria.taes.fastugadriver.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.managers.UserManager;

public class StatisticsFragment extends Fragment {
    private TextView textViewBalance;
    private TextView textViewTotalTime;
    private TextView textViewAverageTime;
    private TextView textViewClientsServed;
    private TextView textViewAssignedDelivered;
    private TextView textViewAverageSpeed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        updateBalance(view);

        updateAssignedOrdersDelivered(view);

        updateTotalTime(view);

        updateAverageTime(view);

        updateClientsServed(view);

        updateAverageSpeed(view);

        // Inflate the layout for this fragment
        return view;
    }

    private void updateBalance(View view) {
        textViewBalance = (TextView) view.findViewById(R.id.textViewBalanceStatistics);
        int balance = UserManager.getManager().getLoggedUserBalance();
        textViewBalance.setText(String.valueOf(balance));
    }

    private void updateTotalTime(View view) {
        textViewTotalTime = (TextView) view.findViewById(R.id.textViewTotalTimeStatistics);
        long total = UserManager.getManager().getLoggedUserTotalDeliveryTime();
        textViewTotalTime.setText(String.valueOf(total));
    }

    private void updateAverageTime(View view) {
        textViewAverageTime = (TextView) view.findViewById(R.id.textViewAverageTimeStatistics);
        long average = UserManager.getManager().getLoggedUserAverageDeliveryTime();
        textViewAverageTime.setText(String.valueOf(average));
    }

    private void updateClientsServed(View view) {
        textViewClientsServed = (TextView) view.findViewById(R.id.textViewClientsServedStatistics);
        long average = UserManager.getManager().getLoggedUserClientsServed();
        textViewClientsServed.setText(String.valueOf(average));
    }

    private void updateAssignedOrdersDelivered(View view) {
        textViewAssignedDelivered = (TextView) view.findViewById(R.id.textViewAssignedDelivered);
        int total = UserManager.getManager().getLoggedUserTotalDeliveries();
        textViewAssignedDelivered.setText(String.valueOf(total));
    }

    private void updateAverageSpeed(View view){
        textViewAverageSpeed = (TextView) view.findViewById(R.id.textViewAverageSpeed);
        double average = UserManager.getManager().getLoggedUserAverageSpeed();
        textViewAverageSpeed.setText(String.format("%.2f", average));
    }
}