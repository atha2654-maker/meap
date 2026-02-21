package com.example.meap.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.meap.R;
import com.example.meap.UiUtils;
import com.google.android.material.button.MaterialButton;

public class ProfileFragment extends Fragment {
    private Uri selectedImageUri;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView profilePhoto = view.findViewById(R.id.profileImage);
        MaterialButton upload = view.findViewById(R.id.btnUploadPhoto);
        MaterialButton save = view.findViewById(R.id.btnSaveProfile);

        ActivityResultLauncher<String> picker = registerForActivityResult(
                new ActivityResultContracts.GetContent(), uri -> {
                    if (uri != null) {
                        selectedImageUri = uri;
                        profilePhoto.setImageURI(uri);
                    }
                });

        upload.setOnClickListener(v -> picker.launch("image/*"));
        save.setOnClickListener(v -> UiUtils.toast(requireContext(),
                "Profile updated" + (selectedImageUri != null ? " with new photo" : "")));

        return view;
    }
}
