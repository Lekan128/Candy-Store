package com.example.candystore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CandyOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CandyStore.db";
    public static final int DATABASE_VERSION = 1;
    private Context mContext;
    public CandyOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CandyDatabaseContract.CandyEntry.SQL_CREATE_TABLE);

        DatabaseWorker worker = new DatabaseWorker(db,mContext);
        worker.insertCandies();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
