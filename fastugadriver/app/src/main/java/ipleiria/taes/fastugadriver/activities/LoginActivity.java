package ipleiria.taes.fastugadriver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ipleiria.taes.fastugadriver.MainActivity;
import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.entities.User;
import ipleiria.taes.fastugadriver.managers.UserManager;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private String email, password;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonGoToRegisterActivity = findViewById(R.id.buttonGoToRegisterActivity);
        buttonGoToRegisterActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        editTextEmail = findViewById(R.id.editTextLoginEmail);
        editTextPassword = findViewById(R.id.editTextLoginPassword);
        Button buttonToLogin = findViewById(R.id.buttonToLogin);
        buttonToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();

                boolean valid = true;
                if(email.trim().isEmpty()){
                    editTextEmail.setError("Email field cannot be empty");
                    valid = false;
                }
                if(password.trim().isEmpty()){
                    editTextPassword.setError("Password field cannot be empty");
                    valid = false;
                }
                if(!valid){
                    return;
                }
                Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
                if(!matcher.matches()){
                    editTextEmail.setError("Wrong email format");
                    return;
                }

                UserManager INSTANCE = UserManager.getManager();
                if (!INSTANCE.logInUser(email, password)){
                    showToastMessage("Wrong credentials!");
                    return;
                }
                showToastMessage("Welcome! " + email);
                INSTANCE.setUserLogged(email);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void showToastMessage(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}