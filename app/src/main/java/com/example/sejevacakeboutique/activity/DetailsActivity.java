package com.example.sejevacakeboutique.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sejevacakeboutique.R;

public class DetailsActivity extends AppCompatActivity {

    ImageView img;
    TextView tv_name, tv_rating, tv_description, tv_price, tv_flavor;
    Button return_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        img = findViewById(R.id.tv_img);
        tv_name = findViewById(R.id.tv_name);
        tv_rating = findViewById(R.id.tv_rating);
        tv_description = findViewById(R.id.tv_desc);
        tv_flavor= findViewById(R.id.tv_flavor);
        tv_price = findViewById(R.id.tv_price);
        return_btn = findViewById(R.id.return_btn);

        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        img.setImageResource(getIntent().getIntExtra("img",0));
        tv_name.setText(getIntent().getStringExtra("name"));
        tv_flavor.setText(getIntent().getStringExtra("flavor"));
        tv_rating.setText(getIntent().getStringExtra("rate") + " " + "(Rating)");
        tv_description.setText(getIntent().getStringExtra("desc"));
        tv_price.setText(getIntent().getStringExtra("price"));

    }
}