package com.example.fragmentcodelab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondExampleFragment extends Fragment {


    private RegisterResult registerResult;
    private Button b;
    private EditText etMail,etPassword;
    public interface RegisterResult {
        void dataFromRegister(String mail,String password);

    }
    public SecondExampleFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_second_example, container, false);

        etMail = view.findViewById(R.id.frgusername);
        etPassword = view.findViewById(R.id.frgpassword);
        b= view.findViewById(R.id.frgBtnlogin);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etMail.getText().toString();
                String password = etPassword.getText().toString();
                // pass data to activity
                if(registerResult!=null)
                    registerResult.dataFromRegister(email,password);
            }
        });
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    @Override
    public void onResume() {
        super.onResume();
        if(getActivity() instanceof RegisterResult)
            this.registerResult = (RegisterResult) getActivity();
    }


}