package ipleiria.taes.fastugadriver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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