package com.example.meap.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.meap.R;
import com.example.meap.UiUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        TextInputEditText phone = view.findViewById(R.id.inputPhone);
        TextInputEditText email = view.findViewById(R.id.inputEmail);
        TextInputEditText smsCode = view.findViewById(R.id.inputSmsCode);
        TextInputEditText emailCode = view.findViewById(R.id.inputEmailCode);

        MaterialButton sendCodes = view.findViewById(R.id.btnSendCodes);
        MaterialButton verify = view.findViewById(R.id.btnVerifyLogin);

        sendCodes.setOnClickListener(v -> UiUtils.toast(requireContext(),
                "Verification codes sent to " + phone.getText() + " and " + email.getText()));
        verify.setOnClickListener(v -> UiUtils.toast(requireContext(),
                "Login verified. SMS: " + smsCode.getText() + " | Email: " + emailCode.getText()));
        return view;
    }
}
