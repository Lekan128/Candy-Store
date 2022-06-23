package com.example.candystore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import static com.example.candystore.CandyDatabaseContract.*;

public class MainActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int LOADER_GENERAL_CHOCOLATE = 0;
    public static final int LOADER_GENERAL_FRUITY = 1;
    public static final int LOADER_GENERAL_GUMMY_BEAR = 2;
    public static final int LOADER_GENERAL_LOLLIPOP = 3;
    public static final int LOADER_GENERAL_SMARTIES = 4;
    public static final int LOADER_DESERT_COOKIES = 5;
    public static final int LOADER_DESERT_CUPCAKES = 6;
    public static final int LOADER_SEASON_CHRISTMAS = 7;
    public static final int LOADER_SEASON_VALENTINE = 8;




    private CandyOpenHelper mCandyOpenHelper;
    private RecyclerView mChocolateRecyclerView;
    private LinearLayoutManager mCandyLayoutManager;


    private Cursor mChocolateCursor;
    private Cursor mFruityCursor;
    private Cursor mGummyBearCursor;
    private Cursor mLollipopCursor;
    private Cursor mSmartiesCursor;
    private Cursor mCookiesCursor;
    private Cursor mCupcakeCursor;
    private Cursor mChristmasCursor;
    private Cursor mValentineCursor;

    private RecyclerView mFruityRecyclerView;

    private CandyRecyclerAdapter mChocolateCandyRecyclerAdapter;
    private CandyRecyclerAdapter mFruityCandyRecyclerAdapter;
    private LinearLayoutManager mFruityLayoutManager;
    private CandyRecyclerAdapter mValentineCandyRecyclerAdapter;
    private CandyRecyclerAdapter mChristmasCandyRecyclerAdapter;
    private CandyRecyclerAdapter mCupcakeCandyRecyclerAdapter;
    private CandyRecyclerAdapter mCookiesCandyRecyclerAdapter;
    private CandyRecyclerAdapter mSmartiesCandyRecyclerAdapter;
    private CandyRecyclerAdapter mLollipopCandyRecyclerAdapter;
    private CandyRecyclerAdapter mGummyBearCandyRecyclerAdapter;

    private Boolean mQueryFinishedChocolate;
    private Boolean mQueryFinishedFruity;
    private Boolean mQueryFinishedGummyBear;
    private Boolean mQueryFinishedLollipop;
    private Boolean mQueryFinishedSmarties;
    private Boolean mQueryFinishedCookies;
    private Boolean mQueryFinishedCupcakes;
    private Boolean mQueryFinishedChristmas;
    private Boolean mQueryFinishedValentine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_candies);

        mCandyOpenHelper = new CandyOpenHelper(this);
//        initialiseDisplayContent();
        loadDataFromDatabase();

//        loadDataFromDatabaseWithoutLoader();
//        initialiseDisplayContent();
    }

    private void loadDataFromDatabaseWithoutLoader(){
        mCookiesCursor = getCursorFromDb(DatabaseWorker.COOKIES);
        mFruityCursor = getCursorFromDb(DatabaseWorker.FRUITY);
        mGummyBearCursor = getCursorFromDb(DatabaseWorker.GUMMY_BEAR);
        mLollipopCursor = getCursorFromDb(DatabaseWorker.LOLLIPOP);
        mSmartiesCursor = getCursorFromDb(DatabaseWorker.SMARTIES);
        mCookiesCursor = getCursorFromDb(DatabaseWorker.COOKIES);
        mCupcakeCursor = getCursorFromDb(DatabaseWorker.CUPCAKES);
        mChristmasCursor = getCursorFromDb(DatabaseWorker.CHRISTMAS);
        mValentineCursor = getCursorFromDb(DatabaseWorker.VALENTINE);
    }

    private void loadDataFromDatabase() {
        getSupportLoaderManager().initLoader(LOADER_GENERAL_CHOCOLATE,null, this);
        getSupportLoaderManager().initLoader(LOADER_GENERAL_FRUITY,null, this);
        getSupportLoaderManager().initLoader(LOADER_GENERAL_GUMMY_BEAR,null, this);
        getSupportLoaderManager().initLoader(LOADER_GENERAL_LOLLIPOP,null, this);
        getSupportLoaderManager().initLoader(LOADER_GENERAL_SMARTIES,null, this);
        getSupportLoaderManager().initLoader(LOADER_DESERT_COOKIES,null, this);
        getSupportLoaderManager().initLoader(LOADER_DESERT_CUPCAKES,null, this);
        getSupportLoaderManager().initLoader(LOADER_SEASON_CHRISTMAS,null, this);
        getSupportLoaderManager().initLoader(LOADER_SEASON_VALENTINE,null, this);
    }

    @Override
    protected void onResume() {
//        mCursor = getCursorFromDb();
//        mChocolateCandyRecyclerAdapter.changeCursor(mCursor);
//        mFruityCandyRecyclerAdapter.changeCursor(mCursor);
        super.onResume();
        getSupportLoaderManager().restartLoader(LOADER_GENERAL_CHOCOLATE,null, this);
        getSupportLoaderManager().restartLoader(LOADER_GENERAL_FRUITY,null, this);
        getSupportLoaderManager().restartLoader(LOADER_GENERAL_GUMMY_BEAR,null, this);

    }

    private void initialiseDisplayContent() {

        setUpFruity();
        setUpChocolate();
        setUpGummyBear();
        setUpLollipop();
        setUpSmarties();
        setUpCookies();
        setUpCupcakes();
        setUpChristmas();
        setUpValentine();

//        mChocolateRecyclerView = findViewById(R.id.chocolateRecyclerView);
//        mCandyLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mChocolateCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mCursor);
//
//        mChocolateRecyclerView.setLayoutManager(mCandyLayoutManager);
//        mChocolateRecyclerView.setAdapter(mChocolateCandyRecyclerAdapter);
//
//        mFruityCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mCursor);
//        mFruityRecyclerView = findViewById(R.id.fruityRecyclerView);
//        LinearLayoutManager fruityLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mFruityRecyclerView.setLayoutManager(fruityLayoutManager);

//        getSupportLoaderManager().initLoader(LOADER_,null, this);
//
//        RecyclerView RecyclerView = findViewById(R.id.);
//        CandyRecyclerAdapter CandyRecyclerAdapter = new CandyRecyclerAdapter(this, );
//
//        LinearLayoutManager LayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        RecyclerView.setLayoutManager(LayoutManager);
//        RecyclerView.setAdapter(CandyRecyclerAdapter);
    }

    private void setUpValentine() {
//        getSupportLoaderManager().initLoader(LOADER_SEASON_VALENTINE,null, this);

        RecyclerView valentineRecyclerView = findViewById(R.id.valentineRecyclerView);
        mValentineCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mValentineCursor);

        LinearLayoutManager valentineLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        valentineRecyclerView.setLayoutManager(valentineLayoutManager);
        valentineRecyclerView.setAdapter(mValentineCandyRecyclerAdapter);
    }

    private void setUpChristmas() {
//        getSupportLoaderManager().initLoader(LOADER_SEASON_CHRISTMAS,null, this);

        RecyclerView christmasRecyclerView = findViewById(R.id.christmasRecyclerView);
        mChristmasCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mChristmasCursor);

        LinearLayoutManager christmasLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        christmasRecyclerView.setLayoutManager(christmasLayoutManager);
        christmasRecyclerView.setAdapter(mChristmasCandyRecyclerAdapter);
    }

    private void setUpCupcakes() {
//        getSupportLoaderManager().initLoader(LOADER_DESERT_CUPCAKES,null, this);

        RecyclerView cupcakesRecyclerView = findViewById(R.id.cupcakeRecyclerView);
        mCupcakeCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mCupcakeCursor);

        LinearLayoutManager cupcakeLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cupcakesRecyclerView.setLayoutManager(cupcakeLayoutManager);
        cupcakesRecyclerView.setAdapter(mCupcakeCandyRecyclerAdapter);
    }

    private void setUpCookies() {
//        getSupportLoaderManager().initLoader(LOADER_DESERT_COOKIES,null, this);

        RecyclerView cookiesRecyclerView = findViewById(R.id.cookiesRecyclerView);
        mCookiesCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mCookiesCursor);

        LinearLayoutManager cookiesLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        cookiesRecyclerView.setLayoutManager(cookiesLayoutManager);
        cookiesRecyclerView.setAdapter(mCookiesCandyRecyclerAdapter);
    }

    private void setUpSmarties() {
//        getSupportLoaderManager().initLoader(LOADER_GENERAL_SMARTIES,null, this);

        RecyclerView smartiesRecyclerView = findViewById(R.id.smartiesRecyclerView);
        mSmartiesCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mSmartiesCursor);

        LinearLayoutManager smartiesLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        smartiesRecyclerView.setLayoutManager(smartiesLayoutManager);
        smartiesRecyclerView.setAdapter(mSmartiesCandyRecyclerAdapter);
    }

    private void setUpLollipop() {
//        getSupportLoaderManager().initLoader(LOADER_GENERAL_LOLLIPOP,null, this);

        RecyclerView lollipopRecyclerView = findViewById(R.id.lollipopRecyclerView);
        mLollipopCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mLollipopCursor);

        LinearLayoutManager lollipopLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        lollipopRecyclerView.setLayoutManager(lollipopLayoutManager);
        lollipopRecyclerView.setAdapter(mLollipopCandyRecyclerAdapter);
    }


    private void setUpGummyBear() {
//        getSupportLoaderManager().initLoader(LOADER_GENERAL_GUMMY_BEAR,null, this);

        RecyclerView gummyBearRecyclerView = findViewById(R.id.gummyBearRecyclerView);
        mGummyBearCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mGummyBearCursor);

        LinearLayoutManager gummyBearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        gummyBearRecyclerView.setLayoutManager(gummyBearLayoutManager);
        gummyBearRecyclerView.setAdapter(mGummyBearCandyRecyclerAdapter);
    }

    private void setUpFruity() {
//        getSupportLoaderManager().initLoader(LOADER_GENERAL_FRUITY,null, this);

        mFruityRecyclerView = findViewById(R.id.fruityRecyclerView);
        mFruityCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mFruityCursor);

        mFruityLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mFruityRecyclerView.setLayoutManager(mFruityLayoutManager);
        mFruityRecyclerView.setAdapter(mFruityCandyRecyclerAdapter);
    }

    private void setUpChocolate() {
//        getSupportLoaderManager().initLoader(LOADER_GENERAL_CHOCOLATE,null, this);

        mChocolateRecyclerView = findViewById(R.id.chocolateRecyclerView);
        mCandyLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mChocolateCandyRecyclerAdapter = new CandyRecyclerAdapter(this, mChocolateCursor);

        mChocolateRecyclerView.setLayoutManager(mCandyLayoutManager);
        mChocolateRecyclerView.setAdapter(mChocolateCandyRecyclerAdapter);

    }


    private Cursor getCursorFromDb(String selectionArg) {
        SQLiteDatabase database = mCandyOpenHelper.getReadableDatabase();

        final String[] columns = {
                CandyEntry.COLON_CANDY_IMAGE,
                CandyEntry.COLON_CANDY_NAME,
                CandyEntry.COLON_CANDY_CATEGORY};

        String selection = CandyEntry.COLON_CANDY_CATEGORY + " Like ?";

        String[] selectionArgs = {selectionArg};

        final Cursor cursor = database.query(CandyEntry.TABLE_NAME,columns,selection,selectionArgs,
                null,null, CandyEntry.COLON_CANDY_NAME);
        int row = cursor.getCount();


        return cursor;

    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        CursorLoader loader = null;
        if(id == LOADER_GENERAL_CHOCOLATE){
            mQueryFinishedChocolate = false;
            loader = loadChocolate();
        }
        if(id == LOADER_GENERAL_FRUITY){
            mQueryFinishedFruity = false;
            loader = loadFruity();
        }
        if(id == LOADER_GENERAL_GUMMY_BEAR){
            mQueryFinishedGummyBear = false;
            loader = loadGummyBears();
        }
        if(id == LOADER_GENERAL_LOLLIPOP){
            mQueryFinishedLollipop = false;
            loader = loadLollipop();
        }
        if(id == LOADER_GENERAL_SMARTIES){
            mQueryFinishedSmarties = false;
            loader = loadSmarties();
        }
        if(id == LOADER_DESERT_COOKIES){
            mQueryFinishedCookies = false;
            loader = loadCookies();
        }
        if(id == LOADER_DESERT_CUPCAKES){
            mQueryFinishedCupcakes = false;
            loader = loadCupcakes();
        }
        if(id == LOADER_SEASON_CHRISTMAS){
            mQueryFinishedChristmas = false;
            loader = loaderChristmas();
        }
        if(id == LOADER_SEASON_VALENTINE){
            mQueryFinishedValentine = false;
            loader = loadValentine();
        }

        return loader;
    }

    private CursorLoader loadValentine() {
//        mValentineCursor = getCursorFromDb(DatabaseWorker.VALENTINE);

        return new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.VALENTINE);
            }
        };
    }

    private CursorLoader loaderChristmas() {
//        mChristmasCursor = getCursorFromDb(DatabaseWorker.CHRISTMAS);

        return new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.CHRISTMAS);
            }
        };
    }

    private CursorLoader loadCupcakes() {
//        mCupcakeCursor = getCursorFromDb(DatabaseWorker.CUPCAKES);

        return new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.CUPCAKES);
            }
        };
    }

    private CursorLoader loadCookies() {
//        mCookiesCursor = getCursorFromDb(DatabaseWorker.COOKIES);

        return new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.COOKIES);
            }
        };
    }

    private CursorLoader loadSmarties() {
//        mSmartiesCursor = getCursorFromDb(DatabaseWorker.SMARTIES);


        return new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.SMARTIES);
            }
        };
    }

    private CursorLoader loadLollipop() {
//        mLollipopCursor = getCursorFromDb(DatabaseWorker.LOLLIPOP);

        return new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.LOLLIPOP);
            }
        };
    }


    private CursorLoader loadFruity() {
//        mFruityCursor = getCursorFromDb(DatabaseWorker.FRUITY);

        return new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.FRUITY);
            }
        };
    }

    private CursorLoader loadGummyBears() {
//        mGummyBearCursor = getCursorFromDb(DatabaseWorker.GUMMY_BEAR);

        return new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.GUMMY_BEAR);
            }
        };
    }

    private CursorLoader loadChocolate() {
//        mChocolateCursor = getCursorFromDb(DatabaseWorker.CHOCOLATE);

        CursorLoader loader =  new CursorLoader(this){
            @Override
            public Cursor loadInBackground() {
                return getCursorFromDb(DatabaseWorker.CHOCOLATE);
            }
        };

        return loader;

    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        if(loader.getId() == LOADER_GENERAL_CHOCOLATE){
            mChocolateCursor = data;
//            mChocolateCandyRecyclerAdapter.changeCursor(mChocolateCursor);
            mQueryFinishedChocolate = true;
            checkIfAllQueriesAreDone();
        }
        if(loader.getId() == LOADER_GENERAL_FRUITY){
            mFruityCursor = data;
//            mFruityCandyRecyclerAdapter.changeCursor(mFruityCursor)
            mQueryFinishedFruity = true;
            checkIfAllQueriesAreDone();
        }
        if(loader.getId() == LOADER_GENERAL_GUMMY_BEAR){
            mGummyBearCursor = data;
//            mGummyBearCandyRecyclerAdapter.changeCursor(mGummyBearCursor);
            mQueryFinishedGummyBear = true;
            checkIfAllQueriesAreDone();
        }
        if(loader.getId() == LOADER_GENERAL_LOLLIPOP){
            mLollipopCursor = data;
//            mLollipopCandyRecyclerAdapter.changeCursor(mLollipopCursor);
            mQueryFinishedLollipop = true;
            checkIfAllQueriesAreDone();
        }
        if(loader.getId() == LOADER_GENERAL_SMARTIES){
            mSmartiesCursor = data;
//            mSmartiesCandyRecyclerAdapter.changeCursor(mSmartiesCursor);
            mQueryFinishedSmarties = true;
            checkIfAllQueriesAreDone();
        }
        if(loader.getId() == LOADER_DESERT_COOKIES){
            mCookiesCursor = data;
//            mCookiesCandyRecyclerAdapter.changeCursor(mCookiesCursor);
            mQueryFinishedCookies = true;
            checkIfAllQueriesAreDone();
        }
        if(loader.getId() == LOADER_DESERT_CUPCAKES){
            mCupcakeCursor = data;
//            mCupcakeCandyRecyclerAdapter.changeCursor(mCookiesCursor);
            mQueryFinishedCupcakes = true;
            checkIfAllQueriesAreDone();
        }
        if(loader.getId() == LOADER_SEASON_CHRISTMAS){
            mChristmasCursor = data;
//            mChristmasCandyRecyclerAdapter.changeCursor(mChristmasCursor);
            mQueryFinishedChristmas = true;
            checkIfAllQueriesAreDone();
        }
        if(loader.getId() == LOADER_SEASON_VALENTINE){
            mValentineCursor = data;
//            mValentineCandyRecyclerAdapter.changeCursor(mValentineCursor);
            mQueryFinishedValentine = true;
            checkIfAllQueriesAreDone();
        }
    }

    private void checkIfAllQueriesAreDone() {
        if(mQueryFinishedChocolate && mQueryFinishedFruity
                && mQueryFinishedGummyBear && mQueryFinishedLollipop
                && mQueryFinishedSmarties && mQueryFinishedCookies
                && mQueryFinishedCupcakes && mQueryFinishedChristmas && mQueryFinishedValentine
        ){
            setContentView(R.layout.activity_main);
            initialiseDisplayContent();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        if(loader.getId() == LOADER_GENERAL_CHOCOLATE){
            mChocolateCandyRecyclerAdapter.changeCursor(null);
            mFruityCandyRecyclerAdapter.changeCursor(null);
            mGummyBearCandyRecyclerAdapter.changeCursor(null);
            mLollipopCandyRecyclerAdapter.changeCursor(null);
            mSmartiesCandyRecyclerAdapter.changeCursor(null);
            mCookiesCandyRecyclerAdapter.changeCursor(null);
            mCupcakeCandyRecyclerAdapter.changeCursor(null);
            mChristmasCandyRecyclerAdapter.changeCursor(null);
            mValentineCandyRecyclerAdapter.changeCursor(null);
        }
    }


}