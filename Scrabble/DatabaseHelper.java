package edu.gatech.seclass.words6300;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class DatabaseHelper extends SQLiteOpenHelper {
        // Basic information about the database
        public static final String DATABASE_NAME = "gamescore.db";
        public final String TABLE_NAME = "gamescore_table";
        public final String COL_1 = "id";
        public final String COL_2 = "finalGameScore";
        public static final String COL_3 = "turns";

        //Constructor
        public DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, 1);
            SQLiteDatabase db = this.getWritableDatabase();
        }

        public void onCreate(SQLiteDatabase db){

            db.execSQL("create table " + TABLE_NAME +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT, GAMEID INTEGER, SCORE INTEGER, TURNS INTEGER)"); // create a query table by

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);           // table created and database created also
//            onCreate(db);
        }
}
