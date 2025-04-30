package com.example.prof_silem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class three_eme_class extends AppCompatActivity {

    private Button boton1, boton2, boton3, boton4, boton5;
    private Button correctButton;
    private Button nextButton;
    private TextView timerText;

    private boolean answerClicked = false;
    private int score = 0;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_eme_class);

        score = getIntent().getIntExtra("SCORE", 0);

        boton1 = findViewById(R.id.btun1);
        boton2 = findViewById(R.id.btun2);
        boton3 = findViewById(R.id.btun3);
        boton4 = findViewById(R.id.btun4);
        boton5 = findViewById(R.id.btun5);
        correctButton = boton3;

        nextButton = findViewById(R.id.Next1);
        timerText = findViewById(R.id.timerTextView);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answerClicked) {
                    answerClicked = true;
                    countDownTimer.cancel();
                    goToNextPage();
                }
            }
        });

        startTimer();

        View.OnClickListener answerClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerClicked) return;
                answerClicked = true;
                countDownTimer.cancel();

                Button clickedButton = (Button) v;

                if (clickedButton == correctButton) {
                    clickedButton.setBackgroundColor(Color.GREEN);
                    score++;
                } else {
                    clickedButton.setBackgroundColor(Color.RED);
                    correctButton.setBackgroundColor(Color.GREEN);
                }

                clickedButton.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        goToNextPage();
                    }
                }, 1000);
            }
        };

        boton1.setOnClickListener(answerClickListener);
        boton2.setOnClickListener(answerClickListener);
        boton3.setOnClickListener(answerClickListener);
        boton4.setOnClickListener(answerClickListener);
        boton5.setOnClickListener(answerClickListener);
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText("Time left: " + millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                if (!answerClicked) {
                    answerClicked = true;
                    goToNextPage();
                }
            }
        }.start();
    }

    private void goToNextPage() {
        Intent intent = new Intent(three_eme_class.this, class_four.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
        finish();
    }
}
