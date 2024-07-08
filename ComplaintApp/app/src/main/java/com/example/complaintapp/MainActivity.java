package com.example.complaintapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvComplaints;
    LinearLayoutManager llManager;
    FloatingActionButton fabAdd;
    ArrayList<Customer> customers;
    CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder complaints = new AlertDialog.Builder(MainActivity.this);
                complaints.setTitle("Add new Complaint...");
                View view = LayoutInflater.from(MainActivity.this)
                                .inflate(R.layout.form_to_add_complaints, null, false);
                complaints.setView(view);

                EditText etName, etCompany, etEPrice, etProblem, etImgUrl, etPhone;
                DatePicker dpDate;
                int date, month, year;
                etName = view.findViewById(R.id.etName);
                etCompany = view.findViewById(R.id.etPCompany);
                etEPrice = view.findViewById(R.id.etEprice);
                etProblem = view.findViewById(R.id.etProblem);
                etImgUrl = view.findViewById(R.id.etImageUrl);
                etPhone = view.findViewById(R.id.etPhone);
                dpDate = view.findViewById(R.id.dpDate);
                date = dpDate.getDayOfMonth();
                month = dpDate.getMonth();
                year = dpDate.getYear();

                complaints.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Customer customers =new Customer(etName.getText().toString().trim(),etProblem.getText().toString().trim(),
                                etCompany.getText().toString().trim(), etImgUrl.getText().toString(), Double.parseDouble(etEPrice.getText().toString()),
                                etPhone.getText().toString(), dpDate.getDayOfMonth(), dpDate.getMonth(), dpDate.getYear());
                        Toast.makeText(MainActivity.this, "Complaint Added Successfully!", Toast.LENGTH_SHORT).show();
                        MyApplication.customers.add(customers);
                        adapter.notifyDataSetChanged();
                    }
                });
                complaints.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
            complaints.show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
    private void init()
    {
        rvComplaints = findViewById(R.id.rvComplaints);
        fabAdd = findViewById(R.id.fabAdd);
        llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        rvComplaints.setLayoutManager(llManager);
        adapter = new CustomerAdapter(this, MyApplication.customers);
        rvComplaints.setAdapter(adapter);
    }
}