package com.example.mywedding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class VenderPaidList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_paid_list);

        //Back Button in android
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //App bar name
        getSupportActionBar().setTitle(R.string.appbar_name_paid_vendor_list);
    }
}