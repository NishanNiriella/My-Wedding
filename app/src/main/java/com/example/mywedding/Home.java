package com.example.mywedding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    ImageButton btn_tasks, btn_budget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_tasks = findViewById(R.id.taskBtn1);
        btn_budget = findViewById(R.id.budgetBtn1);

    }


        @Override
        protected void onResume () {
            super.onResume();

            btn_tasks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Home.this,TaskMenu.class);
                    startActivity(intent);
                }
            });

            btn_budget.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Home.this,BudgetMenu.class);
                    startActivity(intent);
                }
            });




    }

}