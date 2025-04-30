package com.example.prof_silem;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fourclass extends AppCompatActivity {

    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourclass); // تأكد أن اسم الصفحة صحيح

        scoreText = findViewById(R.id.scoreText); // الربط مع TextView الخاص بالنتيجة

        // استلام السكور من الإنتنت
        int score = getIntent().getIntExtra("SCORE", 0);

        // عرض النتيجة
        scoreText.setText("Congratulations!\nYour score is: " + score);
    }
}
