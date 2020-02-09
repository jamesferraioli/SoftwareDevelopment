package edu.gatech.seclass.words6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWord extends SQLiteOpenHelper {
    // Basic information about the database
    static final String DATABASE_NAME = "worddb.db";
    static final String TABLE_NAME = "word_table";
    static final String COL_1 = "WORD";
    static final String COL_2 = "NUMBER";
    static final String COL_3 = "TIMESTAMP";

    public DataBaseWord(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                " (WORD TEXT PRIMARY KEY , NUMBER INTEGER, TIMESTAMP TEXT)"); // create a query table by
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);           // table created and database created also
        onCreate(db);
    }

    public boolean checkWordDB(String word) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT WORD FROM " + TABLE_NAME + " WHERE WORD = \"" + word + "\"";
        Cursor cursor = db.rawQuery(query, null);

        int res = cursor.getCount();
        cursor.close();

        if ( res > 0){
            System.out.println("The Word " + word + " was found " + cursor.getCount() + " in DB");

            return true;
        }
        else{
            System.out.println("Not Found Word " + word + " in DB " + cursor.getCount());
            return false;
        }
    }

    public boolean insertWordData(String word, String num, String timestamp) {
        SQLiteDatabase db = this.getWritableDatabase();

        // generate the insert ContentValues
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, word);
        contentValues.put(COL_2, num);
        contentValues.put(COL_3, timestamp);
        long res = db.insert(TABLE_NAME, null, contentValues);

        if (res == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public void updateWordData(String word, String timestamp){
        SQLiteDatabase db = this.getWritableDatabase();
        // we need to select the data from previous status and add the updated values.
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " WHERE WORD = \"" + word + "\"", null);

        if( res != null && res.moveToFirst() ){
            int res_num = Integer.parseInt( res.getString(1) );
            res_num += 1;

            // update the letter database with the ContentValues object.
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_1, word);
            contentValues.put(COL_2, Integer.toString(res_num));
            contentValues.put(COL_3, timestamp);
            db.update(TABLE_NAME, contentValues, "WORD = ?", new String[]{word});
            res.close();
        }
    }

    public Cursor getWordData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;

    }

}
