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

public class PublicFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_public, container, false);
        MaterialButton publicChat = view.findViewById(R.id.btnJoinPublicChat);
        MaterialButton conference = view.findViewById(R.id.btnStartPublicConference);
        MaterialButton shareScreen = view.findViewById(R.id.btnShareScreen);
        MaterialButton whiteboard = view.findViewById(R.id.btnOpenWhiteboard);

        publicChat.setOnClickListener(v -> UiUtils.toast(requireContext(), "Public chat joined"));
        conference.setOnClickListener(v -> UiUtils.toast(requireContext(), "Public conference started"));
        shareScreen.setOnClickListener(v -> UiUtils.toast(requireContext(), "Screen sharing requested"));
        whiteboard.setOnClickListener(v -> UiUtils.toast(requireContext(), "Whiteboard opened"));
        return view;
    }
}
