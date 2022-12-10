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
import ipleiria.taes.fastugadriver.model.user.UserNameModelArray;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class ChangeName extends Fragment {
    private View view;

    private Button buttonChangeName;
    private Button buttonBack;
    private EditText editFirstName;
    private EditText editLastName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_change_name, container, false);

        buttonChangeName = (Button) view.findViewById(R.id.buttonChangeNameChange);
        buttonBack = (Button) view.findViewById(R.id.buttonBackChangeName);
        editFirstName = view.findViewById(R.id.editTextFirstNameChange);
        editLastName = view.findViewById(R.id.editTextLastNameChange);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle sends data to the other fragment
                Fragment fragment = new MyProfileFragment();
                replaceFragment(fragment);
            }
        });

        buttonChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManager INSTANCE = UserManager.getManager();
                String firstName = editFirstName.getText().toString();
                String lastName = editLastName.getText().toString();

                if (validate(firstName, lastName)) {

                    String name = firstName + " " + lastName;
                    UserNameModelArray updateUserName = new UserNameModelArray();
                    updateUserName.setName(name);

                    setUserName(INSTANCE.getUserLogged().getEmail(), updateUserName);

                    Boolean response = INSTANCE.updateName(firstName, lastName);

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

    private boolean validate(String firstName, String lastName) {
        boolean valid = true;
        String errorMessage;
        if(firstName.isEmpty()){
            errorMessage = "Enter First Name.";
            editFirstName.setError(errorMessage);
            setErrorMessage(editFirstName, errorMessage);
            valid = false;
        }
        if(lastName.isEmpty()){
            errorMessage = "Enter Last Name.";
            editLastName.setError(errorMessage);
            setErrorMessage(editLastName, errorMessage);

            valid = false;
        }
        return valid;
    }

    private void setErrorMessage(EditText textField, String message) {
        textField.setError(message);
        textField.setContentDescription(message);
    }

    private boolean setUserName(String email,  UserNameModelArray body) {
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);
        final ArrayList<UserModelArray.data>[] users = new ArrayList[]{null};

        Call<ResponseBody> call = service.updateUserName(email, body);
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
