package ipleiria.taes.fastugadriver.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import ipleiria.taes.fastugadriver.R;
import ipleiria.taes.fastugadriver.entities.User;
import ipleiria.taes.fastugadriver.managers.UserManager;

public class MyProfileFragment extends Fragment {
    private View view;

    private Button buttonChangePassword;
    private Button buttonChangeName;
    private TextView textName;
    private TextView textEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        UserManager INSTANCE = UserManager.getManager();
        User userLogged = INSTANCE.getUserLogged();

        buttonChangePassword = (Button) view.findViewById(R.id.buttonChangePassword);
        buttonChangeName= (Button) view.findViewById(R.id.buttonChangeName);
        textName = (TextView) view.findViewById(R.id.textNameInputProfile);
        textEmail = (TextView) view.findViewById(R.id.textEmailInputProfile);

        textName.setText(userLogged.getFirstName() + " " + userLogged.getLastName());
        textEmail.setText(userLogged.getEmail());

        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ChangePassword();
                replaceFragment(fragment);
            }

        });

        buttonChangeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ChangeName();
                replaceFragment(fragment);
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


}
