package com.example.hngtask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name,email,tel, bio;

    SharedPreferences sp;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Phone = "phoneKey";
    public static final String Bio = "bioKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.dbd_tv_name);
        email = findViewById(R.id.dbd_tv_email);
        tel = findViewById(R.id.dbd_tv_mobile);
        bio = findViewById(R.id.dbd_tv_brief_info);

        sp = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        name.setText("Name:\t" + sp.getString(Name, ""));
        email.setText("Email: \t" + sp.getString(Email, ""));
        tel.setText("Tel: \t" + sp.getString(Phone, ""));
        bio.setText("Bio: \t" + sp.getString(Bio, ""));

        Button logOutButton = findViewById(R.id.dbd_btn_logout);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}
