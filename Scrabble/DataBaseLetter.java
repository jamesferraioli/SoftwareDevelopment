package edu.gatech.seclass.words6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Arrays;

public class DataBaseLetter extends SQLiteOpenHelper {
    // Basic information about the database
    static final String DATABASE_NAME = "letterdb.db";
    static final String TABLE_NAME = "letter_table";
    static final String COL_1 = "LETTER";
    static final String COL_2 = "PLAYWORD";
    static final String COL_3 = "TRADEBACK";

    public DataBaseLetter(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                " (LETTER TEXT PRIMARY KEY, PLAYWORD INTEGER, TRADEBACK INTEGER)"); // create a query table by
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);           // table created and database created also
        onCreate(db);
    }

    public boolean insertLetterData(String letter, String wp, String tb) {
        SQLiteDatabase db = this.getWritableDatabase();

        // generate the insert ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, letter);
        contentValues.put(COL_2, wp);
        contentValues.put(COL_3, tb);
        long res = db.insert(TABLE_NAME, null, contentValues);

        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void updateLetterData(String letter, String wp, String tb) {
        SQLiteDatabase db = this.getWritableDatabase();

        // we need to select the data from previous status and add the updated values.
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " WHERE LETTER = \"" + letter + "\"", null);

        if (res != null && res.moveToFirst()) {

//            String res_key = res.getString(0);
            int res_wordCnt = Integer.parseInt(res.getString(1));
            int res_swapCnt = Integer.parseInt(res.getString(2));
//            System.out.println("letter: " + res_key + "\nWord: " + res_swapCnt + "\nSwap: " + res_wordCnt + "\n");

            // Add the old value with the new values
            int update_wordCnt = Integer.parseInt(wp) + res_wordCnt;
            int update_swapCnt = Integer.parseInt(tb) + res_swapCnt;

            // update the letter database with the ContentValues object.
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_1, letter);
            contentValues.put(COL_2, Integer.toString(update_wordCnt));
            contentValues.put(COL_3, Integer.toString(update_swapCnt));
            db.update(TABLE_NAME, contentValues, "LETTER = ?", new String[]{letter});
            res.close();
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
