package com.example.complaintapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    ArrayList<Customer> customers;
    Context c;
    public CustomerAdapter(Context context, ArrayList<Customer> customers) {
        c = context;
        this.customers = customers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_complaint_item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.tvName.setText(customer.getcName());
        holder.tvCompanyName.setText(customer.getCompanyName());
        holder.tvContact.setText(customer.getContact());
        holder.tvEprice.setText(customer.getExpectedPrice()+"");
        holder.tvProblem.setText(customer.getProblem());
        holder.tvDate.setText(customer.getDate()+"/" + customer.getMonth()+"/"+customer.getYear());
        if(customer.getImgUrl().equals("dell"))
        {
            holder.ivImgUrl.setImageResource(R.drawable.dell);
        }
        if(customer.getImgUrl().equals("hp"))
        {
            holder.ivImgUrl.setImageResource(R.drawable.hp);
        }
        if(customer.getImgUrl().equals("asus"))
        {
            holder.ivImgUrl.setImageResource(R.drawable.asus);
        }
        if(customer.getImgUrl().equals("lenovo"))
        {
            holder.ivImgUrl.setImageResource(R.drawable.lenovo);
        }
        if(customer.getImgUrl().equals("apple"))
        {
            holder.ivImgUrl.setImageResource(R.drawable.apple);
        }
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder update = new AlertDialog.Builder(c);
                update.setTitle("Update or Delete Complaint");
                View view = LayoutInflater.from(c).inflate(R.layout.update_complaint_form, null,false);
                update.setView(view);
                EditText etName, etCompany, etEPrice, etProblem, etImgUrl, etPhone;
                DatePicker dpDate;

                etName = view.findViewById(R.id.etName);
                etCompany = view.findViewById(R.id.etPCompany);
                etEPrice = view.findViewById(R.id.etEprice);
                etProblem = view.findViewById(R.id.etProblem);
                etImgUrl = view.findViewById(R.id.etImageUrl);
                etPhone = view.findViewById(R.id.etPhone);
                dpDate = view.findViewById(R.id.dpDate);
                int date, month, year;
                date = dpDate.getDayOfMonth();
                month = dpDate.getMonth();
                year = dpDate.getYear();
                etName.setText(customer.getcName());
                etCompany.setText(customer.getCompanyName());
                etEPrice.setText(customer.getExpectedPrice()+"");
                etProblem.setText(customer.getProblem());
                etImgUrl.setText(customer.getImgUrl());
                etPhone.setText(customer.getContact());

                update.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customer.setcName(etName.getText().toString().trim());
                        customer.setContact(etPhone.getText().toString().trim());
                        customer.setCompanyName(etCompany.getText().toString().trim());
                        customer.setExpectedPrice(Double.parseDouble(etEPrice.getText().toString()));
                        customer.setImgUrl(etImgUrl.getText().toString().trim());
                        customer.setProblem(etProblem.getText().toString().trim());
                        customer.setDate(dpDate.getDayOfMonth());
                        customer.setMonth(dpDate.getMonth());
                        customer.setYear(dpDate.getYear());

                        Toast.makeText(c, "Complaint Updated Successfully!", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }
                });
                update.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        customers.remove(holder.getAdapterPosition());
                        Toast.makeText(c, "Complaint Deleted Successfully!", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }
                });
                update.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName,tvCompanyName, tvEprice, tvDate, tvProblem, tvContact;
        ImageView ivImgUrl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImgUrl = itemView.findViewById(R.id.ivDeviceImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
            tvEprice = itemView.findViewById(R.id.tvExpectedPrice);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvProblem = itemView.findViewById(R.id.tvProblem);
            tvContact = itemView.findViewById(R.id.tvContact);
        }
    }
}
