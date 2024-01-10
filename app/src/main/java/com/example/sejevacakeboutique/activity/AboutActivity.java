package com.example.sejevacakeboutique.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sejevacakeboutique.R;

public class AboutActivity extends AppCompatActivity {
    String about = "Sejeva is a home based cake boutique specialising in custom cake artistry." +
            "Based in Barbados, SejevaCakeBoutique was designed to make you deeply immersed with one bite of our gourmet cupcakes, customised cakes, " +
            "and decadent desserts.";
    TextView desc;
    Button return_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        desc = findViewById(R.id.tv_desc);

        desc.setText(about);

        return_btn = findViewById(R.id.return_btn);

        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}