package com.theblucandy.bookworm;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    GridView gridView;

//    String numbers[] = {"one", "Two", "Three","Four","Five","Six"};
//    int cover[] = {R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve,R.drawable.steve};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SearchView searchView = findViewById(R.id.search);
        searchView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search...");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BookList.class);
                startActivity(intent);
            }
        });


//        gridView = findViewById(R.id.grid_view);
//
//        BooksAdapter booksAdapter = new BooksAdapter(MainActivity.this, numbers, cover);
//        gridView.setAdapter(booksAdapter);
//
//
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),"You clicked "+numbers[position]+".", Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}
