package com.example.sejevacakeboutique.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sejevacakeboutique.activity.AboutActivity;
import com.example.sejevacakeboutique.DBHelper;
import com.example.sejevacakeboutique.activity.EditProfileActivity;
import com.example.sejevacakeboutique.activity.LoginActivity;
import com.example.sejevacakeboutique.R;


public class SettingsFragment extends Fragment {
    Button edit_btn,about_btn, logout_btn;
    TextView fullname,tel,user;
    AlertDialog.Builder builder;
    DBHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        edit_btn = view.findViewById(R.id.edit_profile);
        about_btn = view.findViewById(R.id.about);
        logout_btn= view.findViewById(R.id.logout);
        fullname = view.findViewById(R.id.fullname_tv);
        tel = view.findViewById(R.id.tel_phone_tv);
        user = view.findViewById(R.id.username_tv);

        builder = new AlertDialog.Builder(getContext());

        myDB = new DBHelper(getContext());
        Cursor cursor = myDB.viewData();

        if (cursor.getCount() == 0) {
            user.setText("Username: ");
            fullname.setText("Full Name: ");
            tel.setText("Telephone No.: ");
            Toast.makeText(getContext(), "No data", Toast.LENGTH_SHORT).show();
        } else {
            cursor.moveToFirst();
            user.setText("Username : " + cursor.getString(0));
            fullname.setText("Full Name :  " + cursor.getString(1));
            tel.setText("Telephone No. :  " + cursor.getString(2));
        }


        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                    startActivityForResult(intent,1);
            }
        });

        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Alert!")
                        .setMessage("Are you sure you want to log out?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                                Toast.makeText(getActivity(), "Logged out sucessfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();

            }
        });
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if (requestCode == 1 && resultCode == 1){
            String name = data.getStringExtra("name");
            String phone = data.getStringExtra("tel");

            fullname.setText("Full Name : " + name);
            tel.setText("Telephone No. : " + phone);
        }
    }
}