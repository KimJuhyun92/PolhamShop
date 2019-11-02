package com.example.polhamshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

    Context context;
    int layout;
    int img[];
    LayoutInflater inf;
//    List<InfoMember> infoMembers;

    public GridAdapter(Context context, int img[]) {
        this.context = context;
        this.img = img;
        inf = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        ImageView iv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null)
//            convertView = inf.inflate(layout, null);
//        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);

        ImageView imageView;

        ViewHolder holder = null;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(600,600));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(10,10,10,10);
        } else {
//            holder = (ViewHolder) convertView.getTag();
            imageView = (ImageView)convertView;
        }

//        holder.iv.setImageResource(img[position]);
        imageView.setImageResource(img[position]);

        return imageView;
    }
}
