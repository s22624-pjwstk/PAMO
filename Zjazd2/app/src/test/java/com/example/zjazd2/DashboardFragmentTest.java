package com.example.zjazd2;

import static org.junit.Assert.assertEquals;

import com.example.zjazd2.ui.dashboard.DashboardFragment;

import org.junit.Test;

public class DashboardFragmentTest {

    @Test
    public void testCalculateBMIValue() {
        // Arrange
        DashboardFragment dashboardFragment = new DashboardFragment();
        float weight = 70; // przyjmujemy wagę w kilogramach
        float height = 1.75f; // przyjmujemy wzrost w metrach

        // Act
        float result = dashboardFragment.calculateBMIValue(weight, height);

        // Assert
        float expected = 22.86f; // oczekiwany wynik BMI
        assertEquals(expected, result, 0.01f); // tolerancja 0.01
    }
}
