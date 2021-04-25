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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.monthlyhomebudget.monthlybudget.data.MyDbHandler;
import com.monthlyhomebudget.monthlybudget.model.Contact;

import java.time.LocalDate;

public class Creditfragment extends Fragment {

    public Creditfragment() {
        // Required empty public constructor
    }
    EditText amount,description;
    Button sbutton;
    Button bbutton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_creditfragment, container, false);
        amount=view.findViewById(R.id.amount);
        description=view.findViewById(R.id.description);
        sbutton=view.findViewById(R.id.sbutton);
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
                    op.setCatagory("Credit");
                    db.addContact(op);
                    Toast.makeText(getContext(), "Data Added successfully", Toast.LENGTH_SHORT).show();
                    Home home = new Home();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,home).commit();
                }
            }
        });
        bbutton=view.findViewById(R.id.bbutton);
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