package ipleiria.taes.fastugadriver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import ipleiria.taes.fastugadriver.activities.LoginActivity;
import ipleiria.taes.fastugadriver.preferences.SharedPreferences;

import ipleiria.taes.fastugadriver.managers.UserManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        boolean isEmailSaved = SharedPreferences.getUserEmail(MainActivity.this).length() != 0;
        Bundle extras = getIntent().getExtras();
        boolean isNewLogin = false;

        if (extras != null) {
            isNewLogin = extras.getString("newLogin") != null;
        }
        if(!isNewLogin && !isEmailSaved)
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.getMenu().findItem(R.id.logout).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                UserManager INSTANCE = UserManager.getManager();
                INSTANCE.logOutUser();
                SharedPreferences.setUserName(MainActivity.this, "");
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                return true;
            }
        });

        navigationView.getMenu().findItem(R.id.optOut).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_optout, null);

                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.setElevation(40);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                Button yes_button = popupWindow.getContentView().findViewById(R.id.button_yes);
                Button no_button = popupWindow.getContentView().findViewById(R.id.button_no);

                yes_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        UserManager INSTANCE = UserManager.getManager();
                        INSTANCE.optOut();
                        popupWindow.dismiss();

                        SharedPreferences.setUserName(MainActivity.this, "");
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    }
                });

                no_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
                return true;
            }
        });

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void showToastMessage(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

}