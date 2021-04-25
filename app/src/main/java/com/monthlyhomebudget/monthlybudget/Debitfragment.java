package com.monthlyhomebudget.monthlybudget;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.monthlyhomebudget.monthlybudget.data.MyDbHandler;
import com.monthlyhomebudget.monthlybudget.model.Contact;

import java.time.LocalDate;
import java.util.Date;

public class Debitfragment extends Fragment {

    public Debitfragment() {
        // Required empty public constructor
    }
    EditText spinnerc;
    Button sbutton;
    Button bbutton;
    EditText amount,description;
    String[] category;

    String slected_cat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_debitfragment, container, false);


//        SpinnerCategory();
        spinnerc = view.findViewById(R.id.spinnerc);
        amount =(EditText)view.findViewById(R.id.amount);
        description=(EditText)view.findViewById(R.id.description);
        sbutton=(Button)view.findViewById(R.id.sbutton);
        sbutton.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(amount.getText().toString().equals("")){
                    amount.setError("Enter valid amount");
                }
                else if(description.getText().toString().equals("")){
                    description.setError("Enter valid description");
                }
                else{
                    MyDbHandler db = new MyDbHandler(getContext());
                    Contact op = new Contact();
                    String strdate = LocalDate.now().toString();
                    op.setDate(strdate);
                    op.setDescription(description.getText().toString());
                    op.setAmount(amount.getText().toString());
                    if(!(spinnerc.getText().toString() == "")){
                        op.setCatagory(spinnerc.getText().toString());
                    }
                    else{
                        op.setCatagory("Debit");
                    }
                    db.addContact(op);
                    Toast.makeText(getContext(), "Data Added successfully", Toast.LENGTH_SHORT).show();
                    Home home = new Home();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,home).commit();

                }
            }
        });
        bbutton=(Button)view.findViewById(R.id.bbutton);
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home home = new Home();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,home).commit();
            }
        });
        return view;
    }
}