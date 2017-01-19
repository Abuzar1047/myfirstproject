package com.example.abuzar.assignment02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abuza on 1/18/2017.
 */

public class DBClass extends SQLiteOpenHelper {
    public static final String DataBase_NAme = "LoginDBpractice.db";
    public static final String Table = "Login_Table";

    public static final String Usernamecol = "Username";
    public static final String passwordcol = "Password";
    // SQLiteDatabase db;

    String unamevalue="abuzar";
    String passvalue="Mirza";

    public DBClass(Context context) {
        super(context,DataBase_NAme, null, 1);


    }
    //private static final String TableCreate="Create table LoginTbl(id integer primary key," +" Username text not null,Password text not null";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  "
                + Table+ "(" + Usernamecol
                + " text, " + passwordcol
                + " text" +")");
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(Usernamecol , unamevalue );
        CV.put(passwordcol , passvalue);
        db1.insert(Table , null , CV);
        db1.close();

    }

    public  void insertData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(Usernamecol , unamevalue );
        CV.put(passwordcol , passvalue);
        db.insert(Table , null , CV);
        db.close();
    }
    public String AuthenticationFun(String uname){
        SQLiteDatabase   db=this.getReadableDatabase();

        Cursor cur = db.rawQuery("select * from " + Table , null );

        String dbusername,dbusername1;
        dbusername1="Not Found";

        if (cur.moveToFirst()){
            do {
                dbusername=cur.getString(0);
                if(dbusername.equals(uname)){
                    dbusername1=cur.getString(1);
                    break;

                }
            }while (cur.moveToNext());

        }
        cur.close();
        return dbusername1;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop Table if exists " + Table);
        onCreate(db);

    }
}


