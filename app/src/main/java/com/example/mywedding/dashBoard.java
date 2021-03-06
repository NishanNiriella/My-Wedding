package com.example.mywedding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mywedding.Database.DBHelper;

public class dashBoard extends AppCompatActivity {
    TextView txtBudgetPaid, txtBudgetPending, txtTaskCompleted, txtTaskIncomplete, txtGuestInvited, txtGuestNotInvited, txtVendorPaid, txtVendorNotPaid;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        dbHelper = new DBHelper(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.dboard);

        //assigning fields
        txtTaskCompleted = findViewById(R.id.txtCompletedTasks);
        txtTaskIncomplete = findViewById(R.id.txtIncompletedTasks2);
        txtGuestInvited = findViewById(R.id.txtInvitedGuest);
        txtGuestNotInvited = findViewById(R.id.txtUninvitedGuest);
        txtBudgetPaid = findViewById(R.id.txtBudgetPaid);
        txtBudgetPending = findViewById(R.id.txtBudgetPending);
        txtVendorPaid = findViewById(R.id.txtVendorPaid2);
        txtVendorNotPaid = findViewById(R.id.txtVendorPending2);

        int countPaidBudget = dbHelper.countPaidBudgets();
        int totalBudgets = dbHelper.countBudgets();
        int countCompletedTasks = dbHelper.countCompletedTasks();
        int totalTasks = dbHelper.countTasks();
        int totalVendors = dbHelper.countVendor();
        int countCompleteVendor = dbHelper.countCompletedVendor();
        int totalGuests = dbHelper.countGuest();
        int sentGuest = dbHelper.countSent();


        //setting values to the view
        txtTaskCompleted.setText("Completed : " + countCompletedTasks);
        txtTaskIncomplete.setText("Incomplete : " + getPendingTask(totalTasks, countCompletedTasks));
        txtGuestInvited.setText("Invited : " + sentGuest);
        txtGuestNotInvited.setText("Not Invited : " + getNotSent(totalGuests, sentGuest));
        txtBudgetPending.setText("Pending : " + getPendingBudgets(totalBudgets, countPaidBudget));
        txtBudgetPaid.setText("Paid : " + countPaidBudget);
        txtVendorPaid.setText("Completed : " + countCompleteVendor);
        txtVendorNotPaid.setText("Pending : " + getPendingVendor(totalVendors, countCompleteVendor));
    }


    //pending budgets through a calculation
    public int getPendingBudgets(int total, int paid){
        //calculating pending budgets
        int pendingBudget = total - paid;
        return pendingBudget;
    }

    //not sent invites through a calculation
    public int getNotSent(int total, int sent){
        //calculating pending budgets
        int pendingInvites = total - sent;
        return pendingInvites;
    }

    //pending budgets through a calculation
    public int getPendingVendor(int total, int paidVendor){
        //calculating pending budgets
        int pendingVendor = total - paidVendor;
        return pendingVendor;
    }

    //pending tasks through a calculation
    public int getPendingTask(int total, int paid){
        //calculating pending tasks
        int pendingTask = total - paid;
        return pendingTask;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            Intent intent = new Intent(dashBoard.this, Home.class);
            startActivity(intent);
        }
        return true;
    }

}