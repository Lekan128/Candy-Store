package com.example.candystore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayInputStream;

import static com.example.candystore.CandyDatabaseContract.*;

public class AboutCandyActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String CANDY_NAME = "com.example.candystore.CANDY_NAME";

    private String mCandyName;
    private ImageView mCandyImage;
    private TextView mCandyNameText;
    private TextView mCandyPriceText;

    Cursor mCursor;
    CandyOpenHelper mCandyOpenHelper;

    private final int LOADER_CANDY = 0;
    private int mImageColonPosition;
    private int mCandyNameColonPosition;
    private int mCandyPriceColonPosition;
    private Button mShareButton;
    private Button mBuyButton;
    private TextView mImageSource;
    private String mCurrentCandyName;
    private boolean mIsRestarting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_candy);
        mCandyOpenHelper = new CandyOpenHelper(this);

        initialiseViews();

        getCandyName();

        mIsRestarting = false;

        getSupportLoaderManager().initLoader(LOADER_CANDY, null, this);

        mShareButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        share();
                    }
                }
        );

        mBuyButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(v, "Sorry " + mCandyNameText.getText().toString() + " is not yet for sale", Snackbar.LENGTH_LONG)
                                .show();
                    }
                }
        );

        mImageSource.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goToPixabay();
                    }
                }
        );

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mIsRestarting = true;
//        getCandyName();
        mCursor.close();
//        getSupportLoaderManager().initLoader(LOADER_CANDY, null, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void goToPixabay() {
        String Url = "https://pixabay.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(Url));
        startActivity(intent);
    }

    private void share(){
        String subject = mCandyNameText.getText().toString() + " from CandyStore application";
        String text = " Go and check out " + mCandyNameText.getText().toString() +
                " from CandyStore application, it only goes for " + mCandyPriceText.getText().toString() +
                " you would love it!! \n\nPS: if you do not have the candy store application you can download it " +
                " to get this candy and more.";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

//        shareIntent.setType("message/rfc2822");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);


        startActivity(Intent.createChooser(shareIntent, "Share with"));

    }

    private void getCandyName() {
        Intent intent = getIntent();
        mCandyName = intent.getStringExtra(CANDY_NAME);
    }

    private void initialiseViews() {
        mCandyImage = findViewById(R.id.candyImageView);
        mCandyNameText = findViewById(R.id.candyNameText);
        mCandyPriceText = findViewById(R.id.candyPriceText);
        mBuyButton = findViewById(R.id.buyButton);
        mShareButton = findViewById(R.id.shareButton);
        mImageSource = findViewById(R.id.imageSource);
    }


    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        CursorLoader loader = null;

        if(id == LOADER_CANDY){
            loader = new CursorLoader(this){
                @Override
                public Cursor loadInBackground() {
                    SQLiteDatabase database = mCandyOpenHelper.getReadableDatabase();

                    String[] columns = {
                            CandyEntry.COLON_CANDY_IMAGE,
                            CandyEntry.COLON_CANDY_NAME,
                            CandyEntry.COLON_CANDY_PRICE
                    };

                    String selection = CandyEntry.COLON_CANDY_NAME + " Like ?";

                    String[] selectionArgs = {mCandyName};

                    return database.query(CandyEntry.TABLE_NAME, columns, selection, selectionArgs, null,null, null);


                }
            };
        }
        return loader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        if(mIsRestarting){

        }else {
            if (loader.getId() == LOADER_CANDY) {
                mCursor = data;
                int in = mCursor.getCount();
                populateColumnPosition();
                getDataFromCursor();
            }
        }
    }

    private void populateColumnPosition() {
        mImageColonPosition = mCursor.getColumnIndex(CandyEntry.COLON_CANDY_IMAGE);
        mCandyNameColonPosition = mCursor.getColumnIndex(CandyEntry.COLON_CANDY_NAME);
        mCandyPriceColonPosition = mCursor.getColumnIndex(CandyEntry.COLON_CANDY_PRICE);
    }


    private void getDataFromCursor() {
        mCursor.moveToFirst();
        byte[] imageBytes = mCursor.getBlob(mImageColonPosition);

        Bitmap theImage = convertImageBytesToImage(imageBytes);

        String candyName = mCursor.getString(mCandyNameColonPosition);
        String candyPrice = mCursor.getString(mCandyPriceColonPosition);

        mCandyImage.setImageBitmap(theImage);
        mCandyNameText.setText(candyName);
        mCandyPriceText.setText(candyPrice);
    }

    private Bitmap convertImageBytesToImage(byte[] imageBytes) {
        ByteArrayInputStream imageStream = new ByteArrayInputStream(imageBytes);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        return theImage;
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mCursor.close();
    }
}