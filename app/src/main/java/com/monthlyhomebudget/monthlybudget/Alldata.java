package com.monthlyhomebudget.monthlybudget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.monthlyhomebudget.monthlybudget.data.MyDbHandler;
import com.monthlyhomebudget.monthlybudget.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class Alldata extends Fragment {
    public Alldata() {
    }


    ListView monthlylist;
    TextView nodata;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_alldata, container, false);
        monthlylist = view.findViewById(R.id.alldata);

        nodata = view.findViewById(R.id.nodata);
        ArrayList<String> dateArray = new ArrayList<>();
        ArrayList<String> catagoryArray = new ArrayList<>();
        ArrayList<String> amountArray = new ArrayList<>();
        ArrayList<String> discArray = new ArrayList<>();
        ArrayList<String> balanceArray = new ArrayList<>();

        MyDbHandler db = new MyDbHandler(getActivity());
        List<Contact> allContacts = db.getAllContacts();
        for(Contact contact: allContacts)
        {
            dateArray.add(contact.getDate());
            catagoryArray.add(contact.getCatagory());
            amountArray.add(contact.getAmount());
            discArray.add(contact.getDescription());
            balanceArray.add(contact.getEndofdaybalance());
        }

        ListDataAdaptor adaptor = new ListDataAdaptor(getContext(),dateArray,catagoryArray,amountArray,discArray,balanceArray);
        monthlylist.setAdapter(adaptor);
        if(!dateArray.isEmpty()){
            nodata.setText("");
        }
        return view;
    }
}