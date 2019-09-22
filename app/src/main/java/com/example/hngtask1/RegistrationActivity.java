package com.example.hngtask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText name,email,tel, bio, pwd;
    Button reg_btn;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Phone = "phoneKey";
    public static final String Bio = "bioKey";
    public static final String Password = "pwdKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.reg_name);
        email = findViewById(R.id.reg_email);
        tel = findViewById(R.id.reg_tel);
        bio = findViewById(R.id.reg_bio);
        pwd = findViewById(R.id.reg_pwd);

        reg_btn = findViewById(R.id.reg_btn);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = name.getText().toString();
                String e  = email.getText().toString();
                String ph  = tel.getText().toString();
                String b  = bio.getText().toString();
                String pw  = pwd.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                if(n.isEmpty() || e.isEmpty() || ph.isEmpty() || b.isEmpty() || pw.isEmpty()){
                    Toast.makeText(RegistrationActivity.this, "One or more fields is empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    editor.putString(Name, n);
                    editor.putString(Email, e);
                    editor.putString(Phone, ph);
                    editor.putString(Bio, b);
                    editor.putString(Password, pw);
                    editor.commit();

                    Toast.makeText(RegistrationActivity.this,"You have successfully registered",Toast.LENGTH_LONG).show();

                    Intent dbdIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(dbdIntent);
                }

            }
        });
    }
}
