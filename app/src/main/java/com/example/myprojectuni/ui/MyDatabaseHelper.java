package com.example.myprojectuni.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "products.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "products";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PRICE = "price";

    public MyDatabaseHelper(Context context) {
        super(context, "products.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PRICE + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

public void insertData(String name){
    SQLiteDatabase db = this . getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(MyDatabaseHelper.COLUMN_NAME, name);
    db.insert(MyDatabaseHelper.TABLE_NAME, null, values);
    db.close();
}
public Cursor readData(){
    SQLiteDatabase db = this.getReadableDatabase();
    String query = "SELECT * FROM " + MyDatabaseHelper.TABLE_NAME;
    Cursor cursor = db.rawQuery(query, null);
    return cursor;
}



