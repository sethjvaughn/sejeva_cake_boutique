package com.example.sejevacakeboutique.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sejevacakeboutique.DBHelper;
import com.example.sejevacakeboutique.R;

public class LoginActivity extends AppCompatActivity {

    DBHelper myDB;
    private EditText usernameET,passwordET;
    private Button login_btn;
    private TextView signup_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        clickEvent();
    }
    private void init() {
       usernameET = findViewById(R.id.username);
       passwordET = findViewById(R.id.password);
       login_btn= findViewById(R.id.login_btn);
       signup_tv = findViewById(R.id.signup_tv);
       myDB = new DBHelper(this);
    }
    private void clickEvent() {

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameET.getText().toString();
                String pass = passwordET.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = myDB.checkusernamepassword(user,pass);
                    if (checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Sign in successfull!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials! Try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }



}