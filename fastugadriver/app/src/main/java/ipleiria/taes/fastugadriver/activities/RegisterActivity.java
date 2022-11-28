package ipleiria.taes.fastugadriver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

import ipleiria.taes.fastugadriver.MainActivity;
import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.managers.UserManager;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword, editTextFirstName, editTextLastName, editTextPasswordConfirmation, editTextPhoneNumber, editTextLicensePlate;
    private TextView textRegisterError;
    private String email, password, firstName, lastName, passwordConfirmation, phoneNumber, licensePlate;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_LICENSE_PLATE_REGEX = Pattern.compile("^[A-Z]{2}+-[0-9]{2}+-[A-Z]{2}$");
    public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("9[0-9]{8}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        goToLoginActivity();
        defineLayoutElements();
        registerUser();
    }

    private void registerUser() {
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

                if (validateRegister()) {
                    showToastMessage("Welcome! " + email);

                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }
            }
        });
    }

    private boolean validateRegister() {
        String errorMessage;

        if (firstName.length() <= 0) {
            errorMessage = "Enter First Name.";
            editTextFirstName.setError(errorMessage);
            setErrorMessage(editTextFirstName, errorMessage);
            return false;
        }
        if (lastName.length() <= 0) {
            errorMessage = "Enter Last Name.";
            editTextLastName.setError(errorMessage);
            setErrorMessage(editTextLastName, errorMessage);
            return false;
        }
        if (email.length() <= 0) {
            errorMessage = "Enter Email.";
            editTextEmail.setError(errorMessage);
            setErrorMessage(editTextEmail, errorMessage);
            return false;
        } else if (!VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
            errorMessage = "Wrong Email Format - AA@BB.CC.";
            editTextEmail.setError(errorMessage);
            setErrorMessage(editTextEmail, errorMessage);
            return false;
        }
        if (password.length() <= 0) {
            errorMessage = "Enter Password.";
            editTextPassword.setError(errorMessage);
            setErrorMessage(editTextPassword, errorMessage);
            return false;
        } else if (password.length() < 8) {
            errorMessage = "Password too short, at least 8 characters.";
            editTextPassword.setError(errorMessage);
            setErrorMessage(editTextPassword, errorMessage);
            return false;
        }
        if (passwordConfirmation.length() <= 0) {
            errorMessage = "Enter Password Confirmation.";
            editTextPasswordConfirmation.setError(errorMessage);
            setErrorMessage(editTextPasswordConfirmation, errorMessage);
            return false;
        } else if (!passwordConfirmation.equals(password)) {
            errorMessage = "Passwords don't match.";
            editTextPasswordConfirmation.setError(errorMessage);
            setErrorMessage(editTextPasswordConfirmation, errorMessage);
            return false;
        }
        if (phoneNumber.length() <= 0) {
            errorMessage = "Enter Phone Number.";
            editTextPhoneNumber.setError(errorMessage);
            setErrorMessage(editTextPhoneNumber, errorMessage);
            return false;
        } else if (!VALID_PHONE_NUMBER_REGEX.matcher(phoneNumber).matches()) {
            errorMessage = "Wrong Phone Number Format - 9xxxxxxxx.";
            editTextPhoneNumber.setError(errorMessage);
            setErrorMessage(editTextPhoneNumber, errorMessage);
            return false;
        }
        if (licensePlate.length() <= 0) {
            errorMessage = "Enter License Plate.";
            editTextLicensePlate.setError(errorMessage);
            setErrorMessage(editTextLicensePlate, errorMessage);
            return false;
        } else if (!VALID_LICENSE_PLATE_REGEX.matcher(licensePlate).matches()) {
            errorMessage = "Wrong License Format - AA-00-AA.";
            editTextLicensePlate.setError(errorMessage);
            setErrorMessage(editTextLicensePlate, errorMessage);
            return false;
        }

        UserManager INSTANCE = UserManager.getManager();
        int resultCode = INSTANCE.registerUser(firstName, lastName, email, password, phoneNumber, licensePlate);
        if (resultCode == -3) {
            errorMessage = "Email already exists!";
            editTextEmail.setError(errorMessage);
            setErrorMessage(editTextEmail, errorMessage);
            errorMessage = "License plate already exists!";
            editTextLicensePlate.setError(errorMessage);
            setErrorMessage(editTextLicensePlate, errorMessage);
            return false;
        }
        if (resultCode == -1) {
            errorMessage = "Email already exists!";
            editTextEmail.setError(errorMessage);
            setErrorMessage(editTextEmail, errorMessage);
            return false;
        }
        if (resultCode == -2) {
            errorMessage = "License plate already exists!";
            editTextLicensePlate.setError(errorMessage);
            setErrorMessage(editTextLicensePlate, errorMessage);
            return false;
        }
        return true;
    }

    private void defineLayoutElements() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPasswordConfirmation = findViewById(R.id.editTextPasswordConfirmation);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextLicensePlate = findViewById(R.id.editTextLicensePlate);
        textRegisterError = findViewById(R.id.textError);
        textRegisterError.setVisibility(View.INVISIBLE);
    }

    private void goToLoginActivity() {
        Button buttonBackToLogin = findViewById(R.id.buttonBackToLogin);
        buttonBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }

    private void showToastMessage(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    private void setErrorMessage(EditText textField, String message) {
        textField.setError(message);
        textField.setContentDescription(message);
    }
}