package com.example.pamo2.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pamo2.R;
import com.example.pamo2.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    //Fields declaration
    EditText editTextWeight, editTextHeight;
    Button buttonCalculate;
    TextView textViewResult;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        editTextWeight = root.findViewById(R.id.weightTextField);
        editTextHeight = root.findViewById(R.id.heightTextField);
        buttonCalculate = root.findViewById(R.id.calculateButton);
        textViewResult = root.findViewById(R.id.resultInfoBox);
        WebView myWebView = root.findViewById(R.id.bmichart);
        myWebView.loadUrl("file:///android_asset/chart.html");

        // Set click listener to call calculateBMI on click
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        return root;
    }

    private void calculateBMI() {
        // Get values from fields
        String weightString = editTextWeight.getText().toString();
        String heightString = editTextHeight.getText().toString();

        // Check if weight and height fields are not empty
        if (weightString.isEmpty() || heightString.isEmpty()) {
            textViewResult.setText("Enter your weight and height.");
            return;
        }

        // Convert values to float
        float weight = Float.parseFloat(weightString);
        float height = Float.parseFloat(heightString) / 100;

        // Calculate BMI
        float bmi = weight / (height * height);

        // Display BMI result and label
        textViewResult.setText(String.format("Your BMI: %.2f", bmi));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}