package com.example.contacts;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Myprovider extends ContentProvider{

    public static final int table1_Dir = 0;
    public static final int table1_Item = 1;
    private static UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.contacts","contacts",table1_Dir);
        uriMatcher.addURI("com.example.contacts","contactsaa",table1_Item);
    }

    private SQLiteDatabase db;
    private MyDateBaseHelper myDateBaseHelper;
    private Cursor cursor = null;


    @Override
    public boolean onCreate() {
       myDateBaseHelper = new MyDateBaseHelper(getContext(),"Phone.db",null,2);
        Log.i("test", "onCreate ");
       db = myDateBaseHelper.getWritableDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        switch (uriMatcher.match(uri)){
            case table1_Dir:
                Log.i("test", "查询所有 ");
                cursor =db.query("contacts",projection,selection,selectionArgs,null,null,null);
                break;
            case table1_Item:
                Log.i("test", "查询单个 ");
                cursor = db.query("contacts",projection,selection,selectionArgs,null,null,null,null);
                break;
        }


        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
    public void text(){
        Log.i("TAG", "text: ");
    }
}
