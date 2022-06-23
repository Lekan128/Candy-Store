package com.example.candystore;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayInputStream;

import static com.example.candystore.CandyDatabaseContract.*;

public class CandyRecyclerAdapter extends RecyclerView.Adapter<CandyRecyclerAdapter.ViewHolder>  {

    private final Context mContext;
    Cursor mCursor;
    private final LayoutInflater mLayoutInflater;
    private int mImageColonPosition;
    private int mCandyNameColonPosition;
    private int mIdColon;

    public CandyRecyclerAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
        mLayoutInflater = LayoutInflater.from(context);

        if(mCursor != null)
        populateColumnPosition();
    }

    private void populateColumnPosition() {
        mImageColonPosition = mCursor.getColumnIndex(CandyEntry.COLON_CANDY_IMAGE);
        mCandyNameColonPosition = mCursor.getColumnIndex(CandyEntry.COLON_CANDY_NAME);
        mIdColon = mCursor.getColumnIndex(CandyEntry._ID);
        int count = mCursor.getCount();
    }

    public void changeCursor(Cursor cursor){
        if(cursor != null)
            mCursor.close();


        mCursor = cursor;
        populateColumnPosition();
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.single_candy, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mCursor.moveToPosition(position);

        byte[] imageBytes = mCursor.getBlob(mImageColonPosition);
        Bitmap theImage = convertImageBytesToImage(imageBytes);

        String candyName = mCursor.getString(mCandyNameColonPosition);
//        int id = mCursor.getInt(mIdColon);

        holder.mCandyImage.setImageBitmap(theImage);
        holder.mCandyName.setText(candyName);

    }

    private Bitmap convertImageBytesToImage(byte[] imageBytes) {
        ByteArrayInputStream imageStream = new ByteArrayInputStream(imageBytes);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        return theImage;
    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mCandyImage;
        public TextView mCandyName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCandyImage = (ImageView) itemView.findViewById(R.id.candyImage);
            mCandyName = itemView.findViewById(R.id.candyName);

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String candyName = mCandyName.getText().toString();
                            Intent intent = new Intent(mContext, AboutCandyActivity.class);
                            intent.putExtra(AboutCandyActivity.CANDY_NAME, candyName);

                            mContext.startActivity(intent);
                        }
                    }
            );
        }
    }
}
