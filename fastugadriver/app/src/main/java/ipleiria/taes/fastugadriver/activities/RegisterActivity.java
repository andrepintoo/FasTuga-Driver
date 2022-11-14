package ipleiria.taes.fastugadriver.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ipleiria.taes.fastugadriver.MainActivity;
import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.managers.UserManager;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword, editTextFirstName, editTextLastName, editTextPasswordConfirmation, editTextPhoneNumber, editTextLicensePlate;
    private String email, password, firstName, lastName, passwordConfirmation, phoneNumber, licensePlate;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);;
    public static final Pattern VALID_LICENSE_PLATE_REGEX = Pattern.compile("^[A-Z]{2}+-[0-9]{2}+-[A-Z]{2}$");
    public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("9[0-9]{8}$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button buttonBackToLogin = findViewById(R.id.buttonBackToLogin);
        buttonBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPasswordConfirmation = findViewById(R.id.editTextPasswordConfirmation);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextLicensePlate = findViewById(R.id.editTextLicensePlate);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                firstName = editTextFirstName.getText().toString();
                lastName = editTextLastName.getText().toString();
                passwordConfirmation = editTextPasswordConfirmation.getText().toString();
                phoneNumber = editTextPhoneNumber.getText().toString();
                licensePlate = editTextLicensePlate.getText().toString();

                boolean valid = true;
                if (firstName.length() <= 0) {
                    editTextFirstName.setError("Enter First Name.");
                    valid = false;
                }
                if (lastName.length() <= 0) {
                    editTextLastName.setError("Enter Last Name.");
                    valid = false;
                }
                if (email.length() <= 0) {
                    editTextEmail.setError("Enter Email.");
                    valid = false;
                } else if (!VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
                    editTextEmail.setError("Wrong Email Format.");
                    valid = false;
                }
                if (password.length() <= 0) {
                    editTextPassword.setError("Enter Password.");
                    valid = false;
                } else if (password.length() < 8) {
                    editTextPassword.setError("Password too short, at least 8 characters.");
                    valid = false;
                }
                if (passwordConfirmation.length() <= 0) {
                    editTextPasswordConfirmation.setError("Enter Password Confirmation.");
                    valid = false;
                } else if (!passwordConfirmation.equals(password)) {
                    editTextPasswordConfirmation.setError("Passwords don't match.");
                    valid = false;
                }
                if (phoneNumber.length() <= 0) {
                    editTextPhoneNumber.setError("Enter Phone Number.");
                    valid = false;
                } else if (!VALID_PHONE_NUMBER_REGEX.matcher(phoneNumber).matches()) {
                    editTextPhoneNumber.setError("Wrong Phone Number Format - 9xxxxxxxx.");
                    valid = false;
                }
                if (licensePlate.length() <= 0) {
                    editTextLicensePlate.setError("Enter License Plate.");
                    valid = false;
                } else if (!VALID_LICENSE_PLATE_REGEX.matcher(licensePlate).matches()) {
                    editTextLicensePlate.setError("Wrong License Format - AA-00-AA.");
                    valid = false;
                }
                if(valid){
                    showToastMessage("Welcome! " + email);

                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }
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