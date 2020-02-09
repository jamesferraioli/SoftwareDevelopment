package edu.gatech.seclass.words6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseGame extends SQLiteOpenHelper {
    // Basic information about the database
    static final String DATABASE_NAME = "gamedb.db";
    static final String TABLE_NAME = "game_table";
    static final String COL_1 = "ID";
    static final String COL_2 = "SCORES";
    static final String COL_3 = "TURNS";

    public DataBaseGame(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, SCORES INTEGER, TURNS INTEGER)"); // create a query table by
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);           // table created and database created also
        onCreate(db);
    }

    public boolean insertGameData(String scores, String turns){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, scores);
        contentValues.put(COL_3, turns);

        long res = db.insert(TABLE_NAME, null, contentValues);

        if (res == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getGameData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
