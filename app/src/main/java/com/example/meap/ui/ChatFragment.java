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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class ChatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        TextInputEditText person = view.findViewById(R.id.inputPersonName);
        TextInputEditText message = view.findViewById(R.id.inputChatMessage);
        TextInputEditText whatsappDelegate = view.findViewById(R.id.inputWhatsappDelegate);
        MaterialButton send = view.findViewById(R.id.btnSendMessage);
        MaterialButton voice = view.findViewById(R.id.btnVoiceChat);
        FloatingActionButton mic = view.findViewById(R.id.btnMicInput);

        send.setOnClickListener(v -> UiUtils.toast(requireContext(),
                "Sent to " + person.getText() + ": " + message.getText()));
        voice.setOnClickListener(v -> UiUtils.toast(requireContext(),
                "Starting voice chat with " + person.getText()));
        mic.setOnClickListener(v -> UiUtils.toast(requireContext(), "Voice-to-text input active"));
        whatsappDelegate.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                UiUtils.toast(requireContext(), "WhatsApp delegation set: " + whatsappDelegate.getText());
            }
        });
        return view;
    }
}
