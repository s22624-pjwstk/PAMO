package com.example.bmi_callculator2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {
        //Author Dariusz Karasiewicz s22624
        private EditText weightEditText;
        private EditText heightEditText;
        private Button calculateButton;
        private TextView resultTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Inicjalizacja pól tekstowych, przycisku i widoku tekstowego
            weightEditText = findViewById(R.id.Weight);
            heightEditText = findViewById(R.id.Height);
            calculateButton = findViewById(R.id.button);
            resultTextView = findViewById(R.id.Result);

            // Obsługa kliknięcia przycisku
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateBMI();
                }
            });
        }

        // Metoda do obliczenia BMI i wyświetlenia wyniku
        private void calculateBMI() {
            String weightStr = weightEditText.getText().toString();
            String heightStr = heightEditText.getText().toString();

            // Sprawdzenie czy pola są puste
            if (weightStr.isEmpty() || heightStr.isEmpty()) {
                resultTextView.setText("Please enter both weight and height");
                return;
            }

            // Pobranie wartości z pól tekstowych i konwersja na liczby
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr);

            // Obliczenie BMI
            float bmi = calculateBMIValue(weight, height);

            // Wyświetlenie wyniku
            resultTextView.setText("Your BMI is: " + bmi);
        }

        // Metoda do obliczenia wartości BMI
        private float calculateBMIValue(float weight, float height) {
            return weight / (height * height);
        }
    }