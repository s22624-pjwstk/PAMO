package com.example.pamo2.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pamo2.R;
import com.example.pamo2.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    //Fields declaration
    EditText editTextWeight, editTextHeight, editTextAge;
    RadioGroup editGroupAge;
    Button buttonCalculate;
    TextView textViewResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        editTextWeight = root.findViewById(R.id.weightTextField);
        editTextHeight = root.findViewById(R.id.heightTextField);
        editTextAge = root.findViewById(R.id.ageTextField);
        editGroupAge = root.findViewById(R.id.genderRadioGroup);
        buttonCalculate = root.findViewById(R.id.calculateButton);
        textViewResult = root.findViewById(R.id.resultInfoBox);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateKcal();
            }
        });

        return root;
    }

    private void calculateKcal() {
        // Get values from fields
        String weightString = editTextWeight.getText().toString();
        String heightString = editTextHeight.getText().toString();
        String ageString = editTextAge.getText().toString();

        // Get selected gender
        int selectedGenderId = editGroupAge.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = getView().findViewById(selectedGenderId);
        String selectedGender = selectedGenderRadioButton.getText().toString();

        // Parse age as integer
        int age = Integer.parseInt(ageString);

        // Check if weight and height fields are not empty
        if (weightString.isEmpty() || heightString.isEmpty() || ageString.isEmpty()) {
            textViewResult.setText("Enter your weight, height and age.");
            return;
        }

        // Check if gender fields are not empty
        if (selectedGenderId == -1) {
            textViewResult.setText("Select your gender.");
            return;
        }

        // Convert values to float
        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString);

        // Based on selected gender calculate PPM
        String genderResult;
        if (selectedGender.equals("Man")) {
            genderResult = String.valueOf(calculateMalePPM(weight, height, age));
        } else {
            genderResult = String.valueOf(calculateFemalePPM(weight, height, age));;
        }

        // Display PPM result and label
        textViewResult.setText(String.format("Your PPM: %s", genderResult));
    }

    private int calculateMalePPM(float weight, float height, int age) {
        return (int) (66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age));
    }

    private int calculateFemalePPM(float weight, float height, int age) {
        return (int) (655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}