package com.example.kemingxiu.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kemingxiu on 2018/3/12.
 */

public class NewsAdapter extends ArrayAdapter<news> {
    private int resourseId;
    public NewsAdapter(Context context, int textViewResourseId, List<news> objects){
        super(context,textViewResourseId,objects);
        resourseId = textViewResourseId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        news newss = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        ImageView new_Image = (ImageView) view.findViewById(R.id.new_image);
        TextView new_name = (TextView) view.findViewById(R.id.new_name);
        new_Image.setImageResource(newss.getImageid());
        new_name.setText(newss.getNew_name());
        return view;
    }
}
