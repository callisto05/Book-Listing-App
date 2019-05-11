package com.theblucandy.bookworm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BooksLoader extends AsyncTaskLoader<List<Book>> {
    public BooksLoader(@NonNull Context context) {
        super(context);
    }

    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public List<Book> loadInBackground() {
        List<Book> bookListLoader;
        bookListLoader = QueryUtils.fetchBookData(BookList.getUrl());
        return bookListLoader;
    }
}
