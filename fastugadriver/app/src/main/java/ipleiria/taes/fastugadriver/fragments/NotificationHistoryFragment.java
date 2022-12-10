package ipleiria.taes.fastugadriver.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.LinkedList;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.entities.OrderNotification;
import ipleiria.taes.fastugadriver.managers.NotificationManager;

public class NotificationHistoryFragment extends Fragment {

    private View view;

    private TextView textOrderReadyNotification;
    private TextView textOrderCancelledNotification;

    private GridLayout readyOrdersNotificationGrid;
    private GridLayout cancelledOrdersNotificationGrid;

    private LinkedList<OrderNotification> readyOrdersNotificationList;
    private LinkedList<OrderNotification> cancelledOrdersNotificationList;

    private Button notificationButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_notification_history, container, false);

        // Setup of attributes
        layoutAttributesSetup();

        // Get Notification Data from Manager
        readyOrdersNotificationList = NotificationManager.getManager().getOrdersReadyNotification();
        cancelledOrdersNotificationList = NotificationManager.getManager().getOrdersCancelledNotification();

        showReadyOrderNotificationOnLayout(readyOrdersNotificationList);
        showCancelledOrderNotificationOnLayout(cancelledOrdersNotificationList);

        return view;
    }

    private void showCancelledOrderNotificationOnLayout(LinkedList<OrderNotification> cancelledOrdersNotificationList) {
        for (OrderNotification order: cancelledOrdersNotificationList) {
            String buttonText = order.getTitle() + "\n" + order.getContext() + "\n" + order.getDate();
            setButtonProperties(buttonText);
            cancelledOrdersNotificationGrid.addView(notificationButton);
        }
    }

    @SuppressLint("SetTextI18n")
    private void showReadyOrderNotificationOnLayout(LinkedList<OrderNotification> readyOrdersNotificationList) {
        for (OrderNotification order: readyOrdersNotificationList) {
            String buttonText = order.getTitle() + "\n" + order.getContext() + "\n" + order.getDate();
            setButtonProperties(buttonText);
            readyOrdersNotificationGrid.addView(notificationButton);
        }
    }

    @SuppressLint("RtlHardcoded")
    private void setButtonProperties(String buttonText) {
        notificationButton = new Button(getActivity());

        notificationButton.setText(buttonText);

        notificationButton.setBackgroundColor(Color.BLACK);
        notificationButton.setTextColor(Color.WHITE);

        ViewGroup.MarginLayoutParams marginParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        marginParams.setMargins(0, 30, 30, 40);

        notificationButton.setLayoutParams(marginParams);
        notificationButton.setPadding(0, 30, 0, 40);
    }

    private void layoutAttributesSetup() {
        textOrderReadyNotification = view.findViewById(R.id.textOrderReadyNotification);
        textOrderCancelledNotification = view.findViewById(R.id.textOrderCancelledNotification);
        readyOrdersNotificationGridLayout();
        cancelledOrdersNotificationGridLayout();
    }

    private void readyOrdersNotificationGridLayout() {
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.ScrollViewReadyOrdersNotification);
        readyOrdersNotificationGrid = new GridLayout(scrollView.getContext());
        readyOrdersNotificationGrid.setColumnCount(1);
        scrollView.addView(readyOrdersNotificationGrid);
    }

    private void cancelledOrdersNotificationGridLayout() {
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.ScrollViewCancelledOrdersNotification);
        cancelledOrdersNotificationGrid = new GridLayout(scrollView.getContext());
        cancelledOrdersNotificationGrid.setColumnCount(1);
        scrollView.addView(cancelledOrdersNotificationGrid);
    }
}