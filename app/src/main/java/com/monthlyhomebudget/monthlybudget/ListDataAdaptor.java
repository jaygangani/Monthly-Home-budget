package com.monthlyhomebudget.monthlybudget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListDataAdaptor extends ArrayAdapter {
    Context context;
    String[] dateArray;
    String[] catagoryArray;
    String[] amountArray;
    String[] discArray;
    String[] balanceArray;

    ListDataAdaptor(Context c, ArrayList<String> dateArray, ArrayList<String> catagoryArray, ArrayList<String> amountArray, ArrayList<String> discArray, ArrayList<String> balanceArray ){
        super(c , R.layout.row , R.id.amount, amountArray);
        this.dateArray = dateArray.toArray(new String[0]);
        this.catagoryArray = catagoryArray.toArray(new String[0]);
        this.amountArray = amountArray.toArray(new String[0]);
        this.discArray = discArray.toArray(new String[0]);
        this.balanceArray = balanceArray.toArray(new String[0]);
        this.context = c;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View row =inflater.inflate(R.layout.row,parent,false);

        TextView datetxt = row.findViewById(R.id.rowdate);
        TextView catagorytxt = row.findViewById(R.id.rowcatagory);
        TextView amounttxt = row.findViewById(R.id.rowamount);
        TextView disctxt = row.findViewById(R.id.rowdisc);


        datetxt.setText(dateArray[position]);
        catagorytxt.setText(catagoryArray[position]);
        amounttxt.setText(amountArray[position]);
        disctxt.setText(discArray[position]);

        return row;
    }
}
