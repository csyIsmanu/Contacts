package com.example.contacts;


import android.content.ContentProvider;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

import com.example.contacts.R;


public class MainActivity extends AppCompatActivity {


    private static final String AUTHORITY = "com.example.contacts";
    private static final Uri STUDENT_ALL_URI = Uri.parse("content://" + AUTHORITY +"/Phone");
    private ContentResolver ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri = Uri.parse("content://com.example.contacts/contacts");
        Uri uri1 = Uri.parse("content://com.example.contacts/contactsaa");
        Cursor cursor = getContentResolver().query(uri,null,null,null,null,null);
        while(cursor.moveToNext()) {
            int id ;
            id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            System.out.println("id："+id);
            System.out.println("name："+name);
            System.out.println("phone："+phone);
        }
        Cursor cursor1 = getContentResolver().query(uri1,null,"id = ?",new String[]{"1"},null,null);
        while(cursor1.moveToNext()) {
            int id1;
            id1 = cursor1.getInt(cursor1.getColumnIndex("id"));
            String name = cursor1.getString(cursor1.getColumnIndex("name"));
            String phone = cursor1.getString(cursor1.getColumnIndex("phone"));
            System.out.println("id："+id1);
            System.out.println("name："+name);
            System.out.println("phone："+phone);

        }
        /*Cursor cursor = ct.query(STUDENT_ALL_URI,null,null,null,null,null);

        if(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            System.out.println(name);
        }*/


    }
}
