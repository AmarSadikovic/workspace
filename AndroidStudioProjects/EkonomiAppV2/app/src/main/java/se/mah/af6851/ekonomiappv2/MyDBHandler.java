package se.mah.af6851.ekonomiappv2;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.os.Build;

import java.util.Date;
import java.util.Locale;

/**
 * Created by Amar on 2016-10-10.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ekonomi.db";

    public static final String TABLE_UTGIFTER = "utgifter";
    public static final String COLUMN_ID_UTGIFT = "_id";
    public static final String COLUMN_TITEL = "_titel";
    public static final String COLUMN_KATEGORI = "_kategori";
    public static final String COLUMN_PRIS = "_pris";
    public static final String COLUMN_DATUM = "_datum";

    private static final String TABLE_INKOMSTER = "inkomster";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_INKOMSTER_TITEL = "_inkomster_titel";
    public static final String COLUMN_INKOMSTER_KATEGORI = "_inkomster_kategori";
    public static final String COLUMN_INKOMSTER_BELOPP = "_inkomster_belopp";
    public static final String COLUMN_INKOMSTER_DATUM = "_inkomster_datum";

    private static final String CREATE_TABLE_UTGIFTER = "CREATE TABLE " + TABLE_UTGIFTER + "( " +
            COLUMN_ID_UTGIFT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TITEL + " TEXT, " +
            COLUMN_KATEGORI + " TEXT, " +
            COLUMN_PRIS + " INTEGER, " +
            COLUMN_DATUM + " INTEGER " +
            ");";

    private static final String CREATE_TABLE_INKOMSTER = "CREATE TABLE " + TABLE_INKOMSTER + "( " +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_INKOMSTER_TITEL + " TEXT, " +
            COLUMN_INKOMSTER_KATEGORI + " TEXT, " +
            COLUMN_INKOMSTER_BELOPP + " INTEGER, " +
            COLUMN_INKOMSTER_DATUM + " INTEGER" +
            ");";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_UTGIFTER);
        db.execSQL(CREATE_TABLE_INKOMSTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_UTGIFTER);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_INKOMSTER);
        onCreate(db);
    }


    public void addUtgifter(Utgift utgift) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITEL, utgift.get_titel());
        values.put(COLUMN_KATEGORI, utgift.get_kategori());
        values.put(COLUMN_PRIS, utgift.get_pris());
        values.put(COLUMN_DATUM, utgift.get_datum());
        db.insert(TABLE_UTGIFTER, null, values);
        db.close();
    }

    public void addInkomster(Inkomst inkomst) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_INKOMSTER_TITEL, inkomst.get_inkomster_titel());
        values.put(COLUMN_INKOMSTER_KATEGORI, inkomst.get_inkomster_kategori());
        values.put(COLUMN_INKOMSTER_BELOPP, inkomst.get_inkomster_belopp());
        values.put(COLUMN_INKOMSTER_DATUM, inkomst.get_inkomster_datum());
        db.insert(TABLE_INKOMSTER, null, values);
        db.close();
    }

    public Cursor getAllItemsInCursor() {
        return getWritableDatabase()
                .rawQuery("SELECT * FROM " + TABLE_UTGIFTER, null);
    }

    public Cursor getAllItemsInCursorI() {
        return getWritableDatabase()
                .rawQuery("SELECT * FROM " + TABLE_INKOMSTER, null);
    }

    public Cursor getAllItemsByDate(int datumFran, int datumTill) {
        return getWritableDatabase()
                .rawQuery("SELECT * FROM " + TABLE_UTGIFTER + " WHERE _datum " + " BETWEEN " + datumFran + " AND " + datumTill, null);
    }

    public Cursor getAllItemsByDateInkomst(int datumFranInkomst, int datumTillInkomst) {
        return getWritableDatabase()
                .rawQuery("SELECT * FROM " + TABLE_INKOMSTER + " WHERE _inkomster_datum " + " BETWEEN " + datumFranInkomst + " AND " + datumTillInkomst, null);
    }


    public String databaseToStringTest(int databaseId) {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_UTGIFTER + " WHERE _id = " + databaseId;

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("_titel")) != null) {
                dbString += "Titel: ";
                dbString += c.getString(c.getColumnIndex("_titel"));
                dbString += "\n";
            }
            if (c.getString(c.getColumnIndex("_kategori")) != null) {
                dbString += "Kategori: ";
                dbString += c.getString(c.getColumnIndex("_kategori"));
                dbString += "\n";
            }
            if (c.getString(c.getColumnIndex("_pris")) != null) {
                dbString += "Pris: ";
                dbString += c.getString(c.getColumnIndex("_pris"));
                dbString += "kr";
                dbString += "\n";
            }
            if (c.getString(c.getColumnIndex("_datum")) != null) {
                dbString += "Datum: ";
                dbString += c.getString(c.getColumnIndex("_datum"));
                dbString += "\n";
            }
            c.moveToNext();
        }

        db.close();
        return dbString;
    }

    public long databaseTotalUtgifter() {
        long dbTotalUtgifter = 0;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_UTGIFTER + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("_pris")) != null) {
                dbTotalUtgifter += c.getInt(c.getColumnIndex("_pris"));
            }
            c.moveToNext();
        }

        db.close();
        return dbTotalUtgifter;
    }

    public long databaseTotalInkomster() {
        long dbTotalInkomster = 0;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_INKOMSTER + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("_inkomster_belopp")) != null) {
                dbTotalInkomster += c.getInt(c.getColumnIndex("_inkomster_belopp"));
            }
            c.moveToNext();
        }

        db.close();
        return dbTotalInkomster;
    }


    public String databaseToStringInkomster(int databaseId) {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_INKOMSTER + " WHERE _id = " + databaseId;

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("_inkomster_titel")) != null) {
                dbString += "Titel: ";
                dbString += c.getString(c.getColumnIndex("_inkomster_titel"));
                dbString += "\n";
            }
            if (c.getString(c.getColumnIndex("_inkomster_kategori")) != null) {
                dbString += "Kategori: ";
                dbString += c.getString(c.getColumnIndex("_inkomster_kategori"));
                dbString += "\n";
            }
            if (c.getString(c.getColumnIndex("_inkomster_belopp")) != null) {
                dbString += "Pris: ";
                dbString += c.getString(c.getColumnIndex("_inkomster_belopp"));
                dbString += "kr";
                dbString += "\n";
            }
            if (c.getString(c.getColumnIndex("_inkomster_datum")) != null) {
                dbString += "Datum: ";
                dbString += c.getString(c.getColumnIndex("_inkomster_datum"));
                dbString += "\n";
            }
            c.moveToNext();
        }

        db.close();
        return dbString;
    }
}
