package com.example.meap.ui;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.meap.R;
import com.example.meap.UiUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Locale;

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
        MaterialButton call = view.findViewById(R.id.btnPersonVoiceCall);
        MaterialButton video = view.findViewById(R.id.btnPersonVideoCall);
        FloatingActionButton mic = view.findViewById(R.id.btnMicInput);

        ActivityResultLauncher<Intent> speechLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == android.app.Activity.RESULT_OK && result.getData() != null) {
                        ArrayList<String> matches = result.getData().getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        if (matches != null && !matches.isEmpty()) {
                            message.setText(matches.get(0));
                        }
                    }
                });

        send.setOnClickListener(v -> UiUtils.toast(requireContext(),
                "Sent to " + person.getText() + ": " + message.getText()));
        voice.setOnClickListener(v -> UiUtils.toast(requireContext(),
                "Starting voice chat with " + person.getText()));
        call.setOnClickListener(v -> UiUtils.toast(requireContext(), "Calling " + person.getText()));
        video.setOnClickListener(v -> UiUtils.toast(requireContext(), "Video calling " + person.getText()));
        mic.setOnClickListener(v -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak message");
            try {
                speechLauncher.launch(intent);
            } catch (Exception e) {
                UiUtils.toast(requireContext(), "Voice input unavailable on this device");
            }
        });
        whatsappDelegate.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                UiUtils.toast(requireContext(), "WhatsApp delegation set: " + whatsappDelegate.getText());
            }
        });
        return view;
    }
}
