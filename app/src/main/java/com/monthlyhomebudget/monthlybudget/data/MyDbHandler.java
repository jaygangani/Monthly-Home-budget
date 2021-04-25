package com.monthlyhomebudget.monthlybudget.data;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.monthlyhomebudget.monthlybudget.Parameters.Parameters;
import com.monthlyhomebudget.monthlybudget.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context)
    {
        super(context, Parameters.DB_NAME,null,Parameters.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String create = "CREATE TABLE " + Parameters.TABLE_NAME + " ("
                + Parameters.KEY_ID + " INTEGER PRIMARY KEY, " + Parameters.KEY_DATE
                + " TEXT, " + Parameters.KEY_DESCRIPTION + " TEXT, " + Parameters.KEY_AMOUNT
                + " TEXT, " + Parameters.KEY_CATAGORY + " TEXT, " + Parameters.KEY_ENDOFTHEDAYBALANCE + " TEXT" + ")";
        db.execSQL(create);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
    }
    public void addContact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Parameters.KEY_DATE,contact.getDate());
        values.put(Parameters.KEY_DESCRIPTION,contact.getDescription());
        values.put(Parameters.KEY_AMOUNT,contact.getAmount());
        values.put(Parameters.KEY_CATAGORY,contact.getCatagory());
        values.put(Parameters.KEY_ENDOFTHEDAYBALANCE,contact.getEndofdaybalance());

        db.insert(Parameters.TABLE_NAME,null,values);
        db.close();
    }
    public List<Contact> getAllContacts()
    {
        List<Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //Generate the query to read from database
        String select = "SELECT * FROM " + Parameters.TABLE_NAME;
        Cursor cursor =  db.rawQuery(select,null);

        //Loop through raw
        if(cursor.moveToFirst())
        {
            do{
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setDate(cursor.getString(1));
                contact.setDescription(cursor.getString(2));
                contact.setAmount(cursor.getString(3));
                contact.setCatagory(cursor.getString(4));
                contact.setEndofdaybalance(cursor.getString(5));
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }
}
