package ipleiria.taes.fastugadriver.entities;

import android.widget.Button;

public class OrderButton {
    private Button button;
    private final String status;
    private final double distance;

    public OrderButton(Button button, String status, double distance) {
        this.button = button;
        this.status = status;
        this.distance = distance;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getStatus() {
        return status;
    }

    public double getDistance() {
        return distance;
    }
}
