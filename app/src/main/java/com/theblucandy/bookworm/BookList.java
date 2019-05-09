package com.theblucandy.bookworm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class BookList extends AppCompatActivity {

    GridView gridView;

    String numbers[] = {"one", "Two", "Three","Four","Five","Six"};
    int cover[] = {R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        gridView = findViewById(R.id.grid_view);

        BooksAdapter booksAdapter = new BooksAdapter(BookList.this, numbers, cover);
        gridView.setAdapter(booksAdapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You clicked "+numbers[position]+".", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
