package ipleiria.taes.fastugadriver.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ipleiria.taes.fastugadriver.MainActivity;
import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.managers.UserManager;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private TextView errorText;
    private String email, password;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        goToRegisterActivity();
        setLoginElements();
        loginUser();
    }

    private void loginUser() {
        Button buttonToLogin = findViewById(R.id.buttonToLogin);
        buttonToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                UserManager INSTANCE = UserManager.getManager();

                if (!validateLogin(email, password, INSTANCE)) {
                    return;
                }

                INSTANCE.setUserLogged(email);
                goToMainActivity();
            }
        });
    }

    private boolean validateLogin(String email, String password, UserManager INSTANCE) {
        if (email.trim().isEmpty()) {
            setErrorMessage(editTextEmail, "Email field cannot be empty");
            return false;
        }

        if (password.trim().isEmpty()) {
            setErrorMessage(editTextPassword, "Password field cannot be empty");
            return false;
        }

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.matches()) {
            setErrorMessage(editTextEmail, "Wrong email format");
            return false;
        }

        if (!INSTANCE.logInUser(email, password)) {
            errorText.setVisibility(View.VISIBLE);
            return false;
        }
        return true;
    }

    private void goToMainActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    private void setLoginElements() {
        editTextEmail = findViewById(R.id.editTextLoginEmail);
        editTextPassword = findViewById(R.id.editTextLoginPassword);
        errorText = findViewById(R.id.textViewErrorLogin);
        errorText.setVisibility(View.INVISIBLE);
    }

    private void goToRegisterActivity() {
        Button buttonGoToRegisterActivity = findViewById(R.id.buttonGoToRegisterActivity);
        buttonGoToRegisterActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void setErrorMessage(EditText textField, String message) {
        textField.setError(message);
        textField.setContentDescription(message);
    }
}