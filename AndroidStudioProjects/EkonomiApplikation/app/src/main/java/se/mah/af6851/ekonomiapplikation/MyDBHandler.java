package se.mah.af6851.ekonomiapplikation;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amar on 2016-09-30.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ekonomi.db";
    //First table utgifter
    public static final String TABLE_UTGIFTER = "utgifter";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITEL = "_titel";
    public static final String COLUMN_KATEGORI = "_kategori";
    public static final String COLUMN_PRIS = "_pris";
    public static final String COLUMN_DATUM = "_datum";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + TABLE_UTGIFTER + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITEL + " TEXT, " +
                COLUMN_KATEGORI + " TEXT, " +
                COLUMN_PRIS + " INTEGER, " +
                COLUMN_DATUM + " TEXT" +
                ");";
        db.execSQL(query);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_UTGIFTER);
        onCreate(db);
    }

    public void addUtgifter(Utgift utgift){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITEL, utgift.get_titel());
        values.put(COLUMN_KATEGORI, utgift.get_kategori());
        values.put(COLUMN_PRIS, utgift.get_pris());
        values.put(COLUMN_DATUM, utgift.get_datum());
        db.insert(TABLE_UTGIFTER, null, values);
        db.close();
    }

    public Cursor fetchWholeDatabase(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor mCursor =  db.query(TABLE_UTGIFTER, new String[] {COLUMN_TITEL, COLUMN_KATEGORI, COLUMN_PRIS, COLUMN_DATUM},
                null, null, null, null, null);
        if(mCursor != null){
            mCursor.moveToFirst();
        }
        return mCursor;
    }
  public String databaseToString(){
      String dbString = "";
      SQLiteDatabase db = getWritableDatabase();
      String query = "SELECT * FROM " + TABLE_UTGIFTER + " WHERE 1";

      Cursor c = db.rawQuery(query, null);
      c.moveToFirst();

      while(!c.isAfterLast()){
          if(c.getString(c.getColumnIndex("_titel"))!=null){
              dbString += c.getString(c.getColumnIndex("_titel"));
              dbString += "\n";
          }
          if(c.getString(c.getColumnIndex("_kategori"))!=null){
              dbString += c.getString(c.getColumnIndex("_kategori"));
              dbString += "\n";
          }
          if(c.getString(c.getColumnIndex("_pris"))!=null){
              dbString += c.getString(c.getColumnIndex("_pris"));
              dbString += "\n";
          }
          if(c.getString(c.getColumnIndex("_datum"))!=null){
              dbString += c.getString(c.getColumnIndex("_datum"));
              dbString += "\n";
          }
          c.moveToNext();
      }
      db.close();
      return dbString;
  }

}
