package com.example.meap.ui;

import android.content.Intent;
import android.net.Uri;
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

public class EventsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        MaterialButton enroll = view.findViewById(R.id.btnEnrollLatestEvent);
        enroll.setOnClickListener(v -> {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://example.com/enroll")));
            } catch (Exception e) {
                UiUtils.toast(requireContext(), "Open enrollment link failed");
            }
        });
        return view;
    }
}
