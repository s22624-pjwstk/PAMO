package com.example.zjazd2.ui.food_giver;

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

public class FoodRecommender extends Fragment {

    private EditText weightEditText;
    private EditText heightEditText;
    private Button recommendButton;
    private TextView recipeTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.food_recommender, container, false);

        return root;
    }
}