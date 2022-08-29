package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText weight, height;
    String tinh, BMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.inputw);
        height = findViewById(R.id.inputh);
        result = findViewById(R.id.result1);

    }

    public void tinhBMI(View view) {
        String s1 = weight.getText().toString();
        String s2 = height.getText().toString();
        if (s1.isEmpty() || s2.isEmpty()){
            Toast.makeText(MainActivity.this, "Nhập lại đê!", Toast.LENGTH_SHORT).show();
        }else {
            float giatriweight = Float.parseFloat(s1);
            float giatriheight = Float.parseFloat(s2) / 100;
            float chisobmi = giatriweight / (giatriheight * giatriheight);
            if (chisobmi < 18.5) {
                BMI = "Suy dinh dưỡng nặng";
            } else if (chisobmi >= 18.5 && chisobmi <= 22.9) {
                BMI = "Bình thường";
            } else if (chisobmi >= 22.9 && chisobmi <= 29.9) {
                BMI = "Hơi béo";
            } else {
                BMI = "Quá béo";
            }

            tinh = "" + chisobmi + "\n" + BMI;
            result.setText(tinh);
        }
    }
}