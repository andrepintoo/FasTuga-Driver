package ipleiria.taes.fastugadriver.fragments;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.api.RetrofitClient;
import ipleiria.taes.fastugadriver.api.UserService;
import ipleiria.taes.fastugadriver.managers.UserManager;
import ipleiria.taes.fastugadriver.model.user.UserModelArray;
import ipleiria.taes.fastugadriver.model.user.UserPasswordModelArray;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class ChangePassword extends Fragment {
    private View view;

    private Button buttonChangePassword;
    private Button buttonBack;
    private EditText editAtualPassword;
    private EditText editNewPassword;
    private EditText editConfirmPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_change_password, container, false);

        buttonChangePassword = (Button) view.findViewById(R.id.buttonChangePasswordChange);
        buttonBack = (Button) view.findViewById(R.id.buttonBackChangePassword);
        editAtualPassword = view.findViewById(R.id.editTextAtualPassword);
        editNewPassword = view.findViewById(R.id.editTextNewPassword);
        editConfirmPassword = view.findViewById(R.id.editTextConfirmPassword);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle sends data to the other fragment
                Fragment fragment = new MyProfileFragment();
                replaceFragment(fragment);
            }
        });

        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManager INSTANCE = UserManager.getManager();
                String atualPassword = editAtualPassword.getText().toString();
                String newPassword = editNewPassword.getText().toString();
                String confirmPassword = editConfirmPassword.getText().toString();

                if(validate(atualPassword, newPassword, confirmPassword, INSTANCE)){
                    String password = newPassword;
                    String oldpassword = atualPassword;
                    UserPasswordModelArray updatePassword = new UserPasswordModelArray();
                    updatePassword.setPassword(password);
                    updatePassword.setOldPassword(oldpassword);

                    setPassword(INSTANCE.getUserLogged().getEmail(), updatePassword);

                    Boolean response = INSTANCE.updatePassword(newPassword);

                    if (response) {
                        LayoutInflater inflater = (LayoutInflater)
                                getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupView = inflater.inflate(R.layout.popup_success, null);

                        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                        boolean focusable = true; // lets taps outside the popup also dismiss it
                        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                        // show the popup window
                        // which view you pass in doesn't matter, it is only used for the window tolken
                        popupWindow.setElevation(40);
                        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

                        Button ok_button = popupWindow.getContentView().findViewById(R.id.button_ok_change_details);

                        ok_button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                popupWindow.dismiss();
                                Fragment fragment = new MyProfileFragment();
                                replaceFragment(fragment);
                            }
                        });
                    }
                }
            }
        });
        return view;
    }

    public void replaceFragment(Fragment someFragment) {
        assert getFragmentManager() != null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.navHostFragment, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private boolean validate(String atualPassword, String newPassword, String confirmPassword, UserManager INSTANCE) {
        boolean valid = true;
        String errorMessage;
        if(atualPassword.isEmpty()){
            errorMessage = "Enter Atual Password.";
            editAtualPassword.setError(errorMessage);
            setErrorMessage(editAtualPassword, errorMessage);
            valid = false;
        }else if(!atualPassword.equals(INSTANCE.getUserLogged().getPassword())){
            errorMessage = "Atual Password is not correct.";
            editAtualPassword.setError(errorMessage);
            setErrorMessage(editAtualPassword, errorMessage);
            valid = false;
        }
        if(newPassword.isEmpty()){
            errorMessage = "Enter New Password.";
            editNewPassword.setError(errorMessage);
            setErrorMessage(editNewPassword, errorMessage);

            valid = false;
        }else if (newPassword.length() < 8) {
            errorMessage = "New Password too short, at least 8 characters.";
            editNewPassword.setError(errorMessage);
            setErrorMessage(editNewPassword, errorMessage);
            valid = false;
        }
        if(confirmPassword.isEmpty()){
            errorMessage = "Enter Confirmation Password.";
            editConfirmPassword.setError(errorMessage);
            setErrorMessage(editConfirmPassword, errorMessage);

            valid = false;
        }else if (confirmPassword.length() < 8) {
            errorMessage = "Confirmation Password too short, at least 8 characters.";
            editConfirmPassword.setError(errorMessage);
            setErrorMessage(editConfirmPassword, errorMessage);
            valid = false;
        } else if (!confirmPassword.equals(newPassword)) {
            errorMessage = "Passwords don't match.";
            editConfirmPassword.setError(errorMessage);
            setErrorMessage(editConfirmPassword, errorMessage);
            valid = false;
        }
        return valid;
    }

    private void setErrorMessage(EditText textField, String message) {
        textField.setError(message);
        textField.setContentDescription(message);
    }

    private boolean setPassword(String email,  UserPasswordModelArray body) {
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);
        final ArrayList<UserModelArray.data>[] users = new ArrayList[]{null};

        Call<ResponseBody> call = service.updateUserPassword(email, body);
        try
        {
            Response<ResponseBody> response = call.execute();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return true;
    }
}
