package com.example.Kak_voobshe_eto_delat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {

    Button sendEmail;
    EditText emailUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        sendEmail = findViewById(R.id.sendEmail);
        emailUser = findViewById(R.id.createName);
        sendEmail.setEnabled(false);


        emailUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                sendEmail.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sendEmail.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(emailUser.getText())) {
                    sendEmail.setEnabled(false);
                }

            }
        });
        sendEmail.setOnClickListener(v -> {
            Intent code = new Intent(AuthActivity.this, GetCodeEmailActivity.class);
            startActivity(code);
        });
    }
}