package com.example.sejevacakeboutique.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sejevacakeboutique.DBHelper;
import com.example.sejevacakeboutique.R;

public class EditProfileActivity extends AppCompatActivity {

    DBHelper myDB;
    private EditText usernameET, nameET,phone_numET;
    private Button confirm_btn, return_btn;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        init();
        clickEvent();
    }

    private void init() {
        usernameET = findViewById(R.id.username);
        nameET = findViewById(R.id.fullname);
        phone_numET = findViewById(R.id.phone_num);
        confirm_btn= findViewById(R.id.confirm_btn);
        myDB = new DBHelper(this);
        builder = new AlertDialog.Builder(this);

        return_btn = findViewById(R.id.return_btn);

        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Cursor cursor = myDB.viewData();

        if (cursor.getCount() == 0) {
            usernameET.setText("");
            Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
        } else {
            cursor.moveToNext();
            usernameET.setText(cursor.getString(0));
            nameET.setText(cursor.getString(1));
            phone_numET.setText(cursor.getString(2));
        }

    }

    private void clickEvent(){

        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setTitle("Alert!")
                        .setMessage("Are you sure you want to save all changes?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String name = nameET.getText().toString();
                                String user = usernameET.getText().toString();
                                String phone = phone_numET.getText().toString();

                                if(name.equals("") || user.equals("") || phone.equals(""))
                                {
                                    Toast.makeText(EditProfileActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                                }else{
                                    Boolean checkuser = myDB.checkusername(user);
                                    if (checkuser == true){
                                        Boolean update = myDB.update(user,name,phone);
                                        returnData();
                                        if(update == true){
                                            Toast.makeText(EditProfileActivity.this, "Data updated successfully!", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            Toast.makeText(EditProfileActivity.this,"Update failed",Toast.LENGTH_SHORT).show();
                                        }
                                    }else{
                                        Toast.makeText(EditProfileActivity.this,"User does not exist",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                nameET.setText("");
//                                usernameET.setText("");
                                phone_numET.setText("");
                            }
                        })
                        .show();
            }
        });
    }

    private void returnData(){

        String name = nameET.getText().toString();
        String tel = phone_numET.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("name", name);
        intent.putExtra("tel", tel);
        setResult(1,intent);
        EditProfileActivity.this.finish();
    }
}