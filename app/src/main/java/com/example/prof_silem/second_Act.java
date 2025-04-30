package com.example.prof_silem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class second_Act extends AppCompatActivity {

    private Button buton;
    private EditText emailEditText, passwordEditText;

    private final String correctEmail = "abdouandkhalil@gmail.com";
    private final String correctPassword = "12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        buton = findViewById(R.id.btn_sign);
        emailEditText = findViewById(R.id.email_txt);
        passwordEditText = findViewById(R.id.password_txt);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = emailEditText.getText().toString().trim();
                String enteredPassword = passwordEditText.getText().toString().trim();

                if (enteredEmail.equals(correctEmail) && enteredPassword.equals(correctPassword)) {
                    Intent intent = new Intent(second_Act.this, three_eme_class.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(second_Act.this, "Email or password incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
