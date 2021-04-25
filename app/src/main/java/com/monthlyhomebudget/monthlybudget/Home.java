package com.monthlyhomebudget.monthlybudget;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Home extends Fragment {

    public Home() {
    }
    LinearLayout homealldatafragment;
    ImageView debitbtn,creditbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        Alldata alldata = new Alldata();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.homealldatafragment,alldata).commit();

        debitbtn = view.findViewById(R.id.debitbtn);
        creditbtn = view.findViewById(R.id.creditbtn);

        debitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Debitfragment debitfragment = new Debitfragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,debitfragment).commit();
            }
        });
        creditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Creditfragment creditfragment = new Creditfragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentcontainer,creditfragment).commit();
            }
        });


        return view;
    }
}