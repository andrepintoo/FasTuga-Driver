package ipleiria.taes.fastugadriver.activities;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ipleiria.taes.fastugadriver.MainActivity;
import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.api.UserService;
import ipleiria.taes.fastugadriver.managers.UserManager;
import ipleiria.taes.fastugadriver.model.order.OrderModelDataArray;
import ipleiria.taes.fastugadriver.model.user.UserModelArray;
import ipleiria.taes.fastugadriver.model.user.UserModelObject;
import ipleiria.taes.fastugadriver.preferences.SharedPreferences;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                    i.putExtra("newLogin","yes");
                    startActivity(i);
                }
            }
        });
    }

    private boolean validateRegister() {
        String errorMessage;

        boolean valid = true;
        boolean validEmail = true;
        boolean validLicensePlate = true;

        if (firstName.length() <= 0) {
            errorMessage = "Enter First Name.";
            editTextFirstName.setError(errorMessage);
            setErrorMessage(editTextFirstName, errorMessage);
            valid = false;
        }
        if (lastName.length() <= 0) {
            errorMessage = "Enter Last Name.";
            editTextLastName.setError(errorMessage);
            setErrorMessage(editTextLastName, errorMessage);
            valid = false;
        }
        if (email.length() <= 0) {
            errorMessage = "Enter Email.";
            editTextEmail.setError(errorMessage);
            setErrorMessage(editTextEmail, errorMessage);
            valid = false;
            validEmail = false;
        } else if (!VALID_EMAIL_ADDRESS_REGEX.matcher(email).matches()) {
            errorMessage = "Wrong Email Format - AA@BB.CC.";
            editTextEmail.setError(errorMessage);
            setErrorMessage(editTextEmail, errorMessage);
            valid = false;
            validEmail = false;
        }else if (getUserByEmail(email)) {
            valid = false;
            validEmail = false;
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_administrator, null);

            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.setElevation(40);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

            Button ok_button = popupWindow.getContentView().findViewById(R.id.button_ok);

            ok_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
        }
        if (password.length() <= 0) {
            errorMessage = "Enter Password.";
            editTextPassword.setError(errorMessage);
            setErrorMessage(editTextPassword, errorMessage);
            valid = false;
        } else if (password.length() < 8) {
            errorMessage = "Password too short, at least 8 characters.";
            editTextPassword.setError(errorMessage);
            setErrorMessage(editTextPassword, errorMessage);
            valid = false;
        }
        if (passwordConfirmation.length() <= 0) {
            errorMessage = "Enter Password Confirmation.";
            editTextPasswordConfirmation.setError(errorMessage);
            setErrorMessage(editTextPasswordConfirmation, errorMessage);
            valid = false;
        } else if (!passwordConfirmation.equals(password)) {
            errorMessage = "Passwords don't match.";
            editTextPasswordConfirmation.setError(errorMessage);
            setErrorMessage(editTextPasswordConfirmation, errorMessage);
            valid = false;
        }
        if (phoneNumber.length() <= 0) {
            errorMessage = "Enter Phone Number.";
            editTextPhoneNumber.setError(errorMessage);
            setErrorMessage(editTextPhoneNumber, errorMessage);
            valid = false;
        } else if (!VALID_PHONE_NUMBER_REGEX.matcher(phoneNumber).matches()) {
            errorMessage = "Wrong Phone Number Format - 9xxxxxxxx.";
            editTextPhoneNumber.setError(errorMessage);
            setErrorMessage(editTextPhoneNumber, errorMessage);
            valid = false;
        }
        if (licensePlate.length() <= 0) {
            errorMessage = "Enter License Plate.";
            editTextLicensePlate.setError(errorMessage);
            setErrorMessage(editTextLicensePlate, errorMessage);
            valid = false;
            validLicensePlate = false;
        } else if (!VALID_LICENSE_PLATE_REGEX.matcher(licensePlate).matches()) {
            errorMessage = "Wrong License Format - AA-00-AA.";
            editTextLicensePlate.setError(errorMessage);
            setErrorMessage(editTextLicensePlate, errorMessage);
            valid = false;
            validLicensePlate = false;
        }

        if(validEmail || validLicensePlate) {
            UserManager INSTANCE = UserManager.getManager();
            int resultCode = INSTANCE.registerUser(firstName, lastName, email, password, phoneNumber, licensePlate);
            if(resultCode == -3){
                errorMessage = "Email already exists!";
                editTextEmail.setError(errorMessage);
                setErrorMessage(editTextEmail, errorMessage);
                errorMessage = "License plate already exists!";
                editTextLicensePlate.setError(errorMessage);
                setErrorMessage(editTextLicensePlate, errorMessage);
                valid = false;
            }
            if (resultCode == -1) {
                errorMessage = "Email already exists!";
                editTextEmail.setError(errorMessage);
                setErrorMessage(editTextEmail, errorMessage);
                valid = false;
            }
            if (resultCode == -2) {
                errorMessage = "License plate already exists!";
                editTextLicensePlate.setError(errorMessage);
                setErrorMessage(editTextLicensePlate, errorMessage);
                valid = false;
            }
        }
        return valid;
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

    private boolean getUserByEmail(String email) {
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);
        final ArrayList<UserModelArray.data>[] users = new ArrayList[]{null};

        Call<UserModelArray> call = service.getUserByEmail(email);
        try
        {
            Response<UserModelArray> response = call.execute();

            users[0] = response.body().getUsers();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        if (users[0] != null) {
            if (users[0].size() > 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}