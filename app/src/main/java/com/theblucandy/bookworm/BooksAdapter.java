package com.theblucandy.bookworm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class BooksAdapter extends ArrayAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Book> books;
    public static final String LOG_TAG = BooksAdapter.class.getName();

    public BooksAdapter(Context context, ArrayList<Book> book) {
        super(context, 0,book );
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

//        GET CURRENT BOOK
        Book currentBook = (Book)getItem(position);
//        Log.e(LOG_TAG, "Current Book________"+currentBook);

        ImageView coverImage = listItemView.findViewById(R.id.image_view);
        TextView bookName = listItemView.findViewById(R.id.book_name);
        Log.e(LOG_TAG, "Url_____"+currentBook.getThumbnail());

        String url = "https://images-na.ssl-images-amazon.com/images/I/41dKkez-1rL._SX326_BO1,204,203,200_.jpg";

        if(url != null){
            Picasso.get().load(url).into(coverImage);
        }

        String nameOfBook = currentBook.getTitle();
        int leng =10;


        bookName.setText(truncate(nameOfBook, leng));

        return listItemView;
    }

    public static String truncate(String str, int len) {
        if (str.length() > len) {
            return str.substring(0, len) + "...";
        } else {
            return str;
        }}

}
