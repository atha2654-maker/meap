package com.example.meap.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.meap.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;

public class PlannerFragment extends Fragment {
    private final ArrayList<String> plans = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planner, container, false);
        TextInputEditText dateInput = view.findViewById(R.id.inputPlanDate);
        TextInputEditText noteInput = view.findViewById(R.id.inputPlanNote);
        MaterialButton addPlan = view.findViewById(R.id.btnAddPlan);
        ListView listView = view.findViewById(R.id.planList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, plans);
        listView.setAdapter(adapter);

        dateInput.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(requireContext(), (d, y, m, day) ->
                    dateInput.setText(day + "/" + (m + 1) + "/" + y),
                    c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
        });

        addPlan.setOnClickListener(v -> {
            plans.add(dateInput.getText() + " - " + noteInput.getText());
            adapter.notifyDataSetChanged();
            noteInput.setText("");
        });
        return view;
    }
}
