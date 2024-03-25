package com.example.zjazd2.ui.notifications;

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

public class NotificationsFragment extends Fragment {

    private EditText ageEditText;
    private EditText weightEditText;
    private EditText heightEditText;
    private Button calculateButton;
    private TextView resultTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        ageEditText = root.findViewById(R.id.age);
        weightEditText = root.findViewById(R.id.weight1);
        heightEditText = root.findViewById(R.id.height1);
        calculateButton = root.findViewById(R.id.calculate_button1);
        resultTextView = root.findViewById(R.id.result1);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDailyCalories();
            }
        });

        return root;
    }

    private void calculateDailyCalories() {
        String ageStr = ageEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (ageStr.isEmpty() || weightStr.isEmpty() || heightStr.isEmpty()) {
            resultTextView.setText("Please enter age, weight, and height");
            return;
        }

        int age = Integer.parseInt(ageStr);
        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr);

        // Obliczanie kalorii na podstawie wzoru Benedykta-Harrisa
        double bmr = calculateBMR(age, weight, height);

        // Ustalanie zakresu kalorii na podstawie aktywności
        double calories = calculateCalories(bmr);

        resultTextView.setText("Your daily calorie intake is: " + calories + " calories");
    }

    private double calculateBMR(int age, float weight, float height) {
        // Wzór Benedykta-Harrisa dla mężczyzn: 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
        // Wzór Benedykta-Harrisa dla kobiet: 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)
        // Załóżmy, że zakładamy płeć męską w poniższym przykładzie
        return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
    }

    private double calculateCalories(double bmr) {
        // Ustalanie zakresu kalorii na podstawie aktywności
        // Przykładowo, dla osoby prowadzącej mało aktywny tryb życia, kalorie mogą być mnożone przez 1.2
        return bmr * 1.2;
    }
}