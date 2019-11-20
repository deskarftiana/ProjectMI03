package com.example.projectmi03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectmi03.helper.SharedPref;

public class LoginActivity extends AppCompatActivity {

    Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBtnLogin = findViewById(R.id.bt_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPref.getInstance(LoginActivity.this).setLogin(true);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            }
        });
    }
}
