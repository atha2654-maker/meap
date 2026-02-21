package com.example.meap.ui;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meap.R;
import com.example.meap.UiUtils;
import com.example.meap.adapter.MemberAdapter;
import com.example.meap.model.Member;
import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MembersFragment extends Fragment {
    private final List<Member> members = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_members, container, false);
        seedMembers();
        exportCsv();

        RecyclerView recyclerView = view.findViewById(R.id.memberRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new MemberAdapter(members));

        MaterialButton export = view.findViewById(R.id.btnExportExcel);
        export.setOnClickListener(v -> exportCsv());
        return view;
    }

    private void seedMembers() {
        if (!members.isEmpty()) return;
        members.add(new Member("Aarav", "Finance", "Core"));
        members.add(new Member("Diya", "Media", "Organizing"));
        members.add(new Member("Ishaan", "Logistics", "Operations"));
    }

    private void exportCsv() {
        try {
            File dir = requireContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            if (dir == null) return;
            File file = new File(dir, "member_portfolio_committee.csv");
            FileWriter writer = new FileWriter(file);
            writer.write("Series,Name,Portfolio,Committee\n");
            for (int i = 0; i < members.size(); i++) {
                Member m = members.get(i);
                writer.write((i + 1) + "," + m.name + "," + m.portfolio + "," + m.committee + "\n");
            }
            writer.close();
            UiUtils.toast(requireContext(), "Excel-compatible CSV updated: " + file.getName());
        } catch (Exception e) {
            UiUtils.toast(requireContext(), "Export failed: " + e.getMessage());
        }
    }
}
