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

public class RegisterActivity extends AppCompatActivity {
    EditText nameET,usernameET,phone_numET,passwordET,confirmET;
    TextView login_tv;
    Button register_btn;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        clickEvent();
    }
    private void init() {
        nameET = findViewById(R.id.fullname);
        usernameET = findViewById(R.id.username);
        phone_numET= findViewById(R.id.phone_num);
        passwordET = findViewById(R.id.password);
        confirmET = findViewById(R.id.confirm_password);
        login_tv = findViewById(R.id.login_tv);
        register_btn = findViewById(R.id.register_btn);
        myDB = new DBHelper(this);
    }
    private void clickEvent() {
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                String user = usernameET.getText().toString();
                String phone = phone_numET.getText().toString();
                String pass = passwordET.getText().toString();
                String cpass = confirmET.getText().toString();

                if(name.equals("") || user.equals("") || phone.equals("") || pass.equals("") || cpass.equals(""))
                {
                    Toast.makeText(RegisterActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pass.equals(cpass)){
                        Boolean checkuser = myDB.checkusername(user);
                        if(checkuser == false){
                            Boolean insert = myDB.insertData(user, name,phone,pass);
                            if(insert == true){
                                Toast.makeText(RegisterActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(RegisterActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this,"User already exists! \n Please choose another username!",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Passwords do not match   ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}