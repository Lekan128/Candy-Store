package com.example.candystore;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;

public class DatabaseWorker {
    private SQLiteDatabase mDatabase;
    private Context mContext;
    public static final String CHOCOLATE = "chocolate";
    public static final String FRUITY = "fruity";
    public static final String GUMMY_BEAR = "gummy_bear";
    public static final String LOLLIPOP = "lollipop";
    public static final String SMARTIES = "smarties";
    public static final String COOKIES = "cookie";
    public static final String CUPCAKES = "cupcake";
    public static final String CHRISTMAS = "christmas";
    public static final String VALENTINE = "valentine";



    public DatabaseWorker(SQLiteDatabase database) {
        mDatabase = database;
    }

    public DatabaseWorker(SQLiteDatabase database, Context context) {
        mDatabase = database;
        mContext = context;
    }

    public void insertCandies(){

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.chocolate_one)),"Banana", CHOCOLATE, "600 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.chocolate_two)),"Cake pops", CHOCOLATE, "700 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.chocolate_three)),"Chocolate", CHOCOLATE, "1,000 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.chocolate_four)),"Coca", CHOCOLATE, "1,200 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.chocolate_five)),"Cup cake", CHOCOLATE, "1,340 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.chocolate_six)),"Chocolate pack", CHOCOLATE, "3,000 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.chocolate_one)),"Chocolate pack 2", CHOCOLATE, "3,000 Naira");

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.fruity_one)),"Strawberry", FRUITY, "700 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.fruity_two)),"Orange", FRUITY, "600 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.fruity_three)),"Fruit jelly", FRUITY, "200 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.fruity_four)),"Orange 2", FRUITY, "900 Naira");

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.gummy_bear_one)),"Giant", GUMMY_BEAR, "4,300 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.gummy_bear_two)),"Gummibar", GUMMY_BEAR, "2,200 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.gummy_bear_three)),"Gummibarchen", GUMMY_BEAR, "1,000 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.gummy_bear_four)),"Gummibarchen 2", GUMMY_BEAR, "1,200 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.gummy_bear_five)),"9 bears", GUMMY_BEAR, "900 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.gummy_bear_six)),"Gummies 5", GUMMY_BEAR, "500 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.gummy_bear_seven)),"8 cups", GUMMY_BEAR, "7,000 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.gummy_bear_eight)),"Truck", GUMMY_BEAR, "6,000 Naira");

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.lollipop_one)),"Large", LOLLIPOP, "400 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.lollipop_two)),"Heart shaped", LOLLIPOP, "340 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.lollipop_three)),"Chocolate 2", LOLLIPOP, "300 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.lollipop_four)),"Flower", LOLLIPOP, "600 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.lollipop_five)),"Pack", LOLLIPOP, "6,400 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.lollipop_six)),"Dual", LOLLIPOP, "2,000 Naira");

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_one)),"Cup", SMARTIES, "700 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_two)),"Heart shaped", SMARTIES, "900 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_three)),"Jar", SMARTIES, "1,200 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_four)),"Gummy", SMARTIES, "200 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_five)),"Orange 2", SMARTIES, "900 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_six)),"Gummy 2", SMARTIES, "200 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_seven)),"Caramel", SMARTIES, "100 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_eight)),"Caramel 2", SMARTIES, "120 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_nine)),"Colorful", SMARTIES, "900 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_ten)),"Haribo", SMARTIES, "50 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_eleven)),"Pick mix", SMARTIES, "2,000 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_twelve)),"Group", SMARTIES, "1,000 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.smarties_thirteen)),"Small Heart", SMARTIES, "200 Naira");

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.cookies_one)),"Colorful", COOKIES, "900 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.cookies_two)),"Usual", COOKIES, "500 Naira");

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.cupcake_one)),"Balls", CUPCAKES, "500 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.cupcake_two)),"Cupcake", CUPCAKES, "800 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.cupcake_three)),"Icing", CUPCAKES, "700 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.cupcake_four)),"Brownie", CUPCAKES, "800 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.cupcake_five)),"fancy", CUPCAKES, "1,500 Naira");

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.christmas_one)),"Cane", CHRISTMAS, "2,000 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.christmas_two)),"Sweets", CHRISTMAS, "800 Naira");

        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.valentine_one)),"Candies", VALENTINE, "130 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.valentine_two)),"Heart shaped", VALENTINE, "600 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.valentine_three)),"Candy", VALENTINE, "800 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.valentine_four)),"Box", VALENTINE, "4,500 Naira");
        insertCandy(convertToByte(ContextCompat.getDrawable(mContext, R.drawable.valentine_five)),"Box 2", VALENTINE, "4,000 Naira");


    }

    private byte[] convertToByte(Drawable drawable){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();// the bytes
    }

    private void insertCandy(byte[] image, String candyName, String candyCategory, String candyPrice) {
        ContentValues values = new ContentValues();

        values.put(CandyDatabaseContract.CandyEntry.COLON_CANDY_IMAGE, image);
        values.put(CandyDatabaseContract.CandyEntry.COLON_CANDY_NAME, candyName);
        values.put(CandyDatabaseContract.CandyEntry.COLON_CANDY_CATEGORY, candyCategory);
        values.put(CandyDatabaseContract.CandyEntry.COLON_CANDY_PRICE, candyPrice);

        long newRowId = mDatabase.insert(CandyDatabaseContract.CandyEntry.TABLE_NAME, null, values);
    }
}
