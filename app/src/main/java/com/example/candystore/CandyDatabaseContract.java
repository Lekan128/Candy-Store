package com.example.candystore;

import android.provider.BaseColumns;

public class CandyDatabaseContract {
    private CandyDatabaseContract(){}

    public static final class CandyEntry implements BaseColumns{
        public static final String TABLE_NAME = "candies";
        public static final String COLON_CANDY_IMAGE = "candyImage";
        public static final String COLON_CANDY_NAME = "candyName";
        public static final String COLON_CANDY_CATEGORY = "candyCategory";
        public static final String COLON_CANDY_PRICE = "candyPrice";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLON_CANDY_IMAGE + " BLOB, " +
                        COLON_CANDY_NAME +  " TEXT UNIQUE NOT NULL, " +
                        COLON_CANDY_CATEGORY + " TEXT, " +
                        COLON_CANDY_PRICE + " TEXT)";
    }
}
