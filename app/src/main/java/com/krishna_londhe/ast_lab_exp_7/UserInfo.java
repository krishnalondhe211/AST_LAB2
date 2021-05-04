package com.krishna_londhe.ast_lab_exp_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UserInfo extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        String messgae=getIntent().getStringExtra("message");

        text=(TextView)findViewById(R.id.tvuser);

        text.setText(messgae);



    }
}