package com.theblucandy.bookworm;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class BooksAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] numbers;
    private int[] cover;

    public BooksAdapter(Context context, String[] numbers, int[] cover) {
        this.context = context;
        this.numbers = numbers;
        this.cover = cover;
    }

    @Override
    public int getCount() {
        return numbers.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.row_item, null);
        }

        ImageView coverImage = convertView.findViewById(R.id.image_view);
        TextView bookName = convertView.findViewById(R.id.book_name);

        coverImage.setImageResource(this.cover[position]);
        bookName.setText(this.numbers[position]);

        return convertView;
    }
}
