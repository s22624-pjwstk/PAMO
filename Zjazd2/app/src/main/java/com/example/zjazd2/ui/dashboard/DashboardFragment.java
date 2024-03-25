package com.example.zjazd2.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.zjazd2.R;

public class DashboardFragment extends Fragment {

    private EditText weightEditText;
    private EditText heightEditText;
    private Button calculateButton;
    private TextView resultTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        weightEditText = root.findViewById(R.id.weight);
        heightEditText = root.findViewById(R.id.height);
        calculateButton = root.findViewById(R.id.button);
        resultTextView = root.findViewById(R.id.result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        return root;
    }

    private void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            resultTextView.setText("Please enter both weight and height");
            return;
        }

        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr);

        float bmi = calculateBMIValue(weight, height);

        resultTextView.setText("Your BMI is: " + bmi);
    }

    private float calculateBMIValue(float weight, float height) {
        // Przeliczanie względem wzoru BMI
        return weight / (height * height);
    }
}