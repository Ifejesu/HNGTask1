package com.example.hngtask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText email, pwd;

    SharedPreferences sp;

    public static final String MyPREFERENCES = "MyPrefs" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.log_et_email);
        pwd = findViewById(R.id.log_et_pword);

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        final String em = sp.getString("emailKey", "");
        final String pw = sp.getString("pwdKey", "");

        Log.d("From SP", em+" "+pw);

        Button loginButton = findViewById(R.id.log_btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e  = email.getText().toString();
                String p  = pwd.getText().toString();

                Log.d("Details", e+" "+p);

               if (e.contentEquals(em) && p.contentEquals(pw)) {
                    Intent dbdIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(dbdIntent);
                } else{
                    Toast.makeText(LoginActivity.this, "Credentials not valid", Toast.LENGTH_LONG).show();
            }
            }
        });

        Button registerButton = findViewById(R.id.log_btn_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registerIntent);
            }
        });
    }
}
