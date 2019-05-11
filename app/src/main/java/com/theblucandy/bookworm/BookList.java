package com.theblucandy.bookworm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookList extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {

    GridView gridView;
    public static final String LOG_TAG = BookList.class.getName();
    private static final String BOOKS_REQUEST_URL =
            "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=10";
    private BooksAdapter booksAdapter;

    public static String getUrl(){
        return BOOKS_REQUEST_URL;
    }

//    String numbers[] = {"one", "Two", "Three","Four","Five","Six"};
//    int cover[] = {R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);

//        BACK BUTTON ON ACTIONBAR
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = (activeNetwork != null) && activeNetwork.isConnected();

        if(isConnected == true) {
            getSupportLoaderManager().initLoader(1, null, this);
        }

//        ADAPTER
        booksAdapter = new BooksAdapter(BookList.this, new ArrayList<Book>());
        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(booksAdapter);



//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),"You clicked "+numbers[position]+".", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @NonNull

    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle){
        return new BooksLoader(BookList.this);
    }


    public void onLoadFinished(@NonNull Loader<List<Book>> loader, List<Book> books){

        booksAdapter.clear();
        if(books != null && !books.isEmpty()){
            Log.e(LOG_TAG, "onLoadFinished_________"+books);
            booksAdapter.addAll(books);
            Log.e(LOG_TAG, "onLoadFinished_________"+books);

        }
    }

    public void onLoaderReset(Loader<List<Book>> loader) {
        booksAdapter.addAll(new ArrayList<Book>());
    }


}
