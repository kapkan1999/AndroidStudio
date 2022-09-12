package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;

public class DBHelper  extends SQLiteOpenHelper {
    private static final String MY_TABLE = "MY_TABLE";
    private static final String COLUMN_NAME = "COLUMN_NAME" ;
    private static final String COLUMN_SURNAME = "COLUMN_SURNAME";
    private static final String COLUMN_YEAR = "COLUMN_YEAR";

    public DBHelper(@Nullable Context context) {
        super(context,  "example.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("DROP TABLE " + MY_TABLE +";");
       db.execSQL("CREATE TABLE " + MY_TABLE + " ("+COLUMN_NAME+" TEXT, "+ COLUMN_SURNAME+ " TEXT, "+ COLUMN_YEAR + " INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public void DeleteALl(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MY_TABLE,null,null);
        db.close();
    }

    public void AddOne(Data data){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, data.name);
        cv.put(COLUMN_SURNAME, data.surName);
        cv.put(COLUMN_YEAR, data.year);

        db.insert(MY_TABLE, null, cv);

        db.close();

    }
    public LinkedList<Data> GetAll (){
        LinkedList<Data> list = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(MY_TABLE,null,null,null,null,null,null);

        if (cursor.moveToFirst())
            do{
                int id_name = cursor.getColumnIndex(COLUMN_NAME);
                int id_surname = cursor.getColumnIndex(COLUMN_SURNAME);
                int id_year = cursor.getColumnIndex(COLUMN_YEAR);

                Data data = new Data(cursor.getString(id_name), cursor.getString(id_surname), cursor.getInt(id_year));
                list.add(data);

            }while(cursor.moveToNext());

        db.close();
        return list;
    }
}
