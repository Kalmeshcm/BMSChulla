package com.example.abc.bms_chulla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ABC on 09-07-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DISH";
    public static final String TABLE_NAME = "ITEMS";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "TEMPER";
    public static final String COL_4 = "TIME";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,NAME TEXT NOT NULL,TEMPER INTEGER NOT NULL,TIME INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name, String temp, String time)
    {
        long res = 0;
        if (!name.equals("") && !temp.equals("") && !time.equals(""))
        {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, name);
            contentValues.put(COL_3, temp);
            contentValues.put(COL_4, time);
            res = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        }
        if(res == 0)
            return false;
        else
            return res != -1;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

}
