package com.i000phone.movieplayer2.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.i000phone.movieplayer2.R;
import com.i000phone.movieplayer2.entities.AllSimpleMovies;
import com.i000phone.movieplayer2.entities.MyImageView;
import com.i000phone.movieplayer2.utils.NetWorkDrawable;
import com.i000phone.movieplayer2.utils.PathUtil;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class ImageAdapter1 extends BaseAdapter {
    private Context context;
    private List<AllSimpleMovies.SimpleMovie> list;

    public ImageAdapter1(Context context, List<AllSimpleMovies.SimpleMovie> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.imageView = (MyImageView) convertView.findViewById(R.id.item_img);
            convertView.setTag(viewHolder);
        }
        AllSimpleMovies.SimpleMovie simpleMovie = list.get(position);
        String backdrop_path = simpleMovie.getBackdrop_path();
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        String imageUrl = PathUtil.getImageUrl(PathUtil.W185, backdrop_path);
        Picasso.with(context).load(imageUrl).into(viewHolder.imageView);
        return convertView;
    }
    class ViewHolder{
        MyImageView imageView;
    }
    public void addAll(Collection<? extends AllSimpleMovies.SimpleMovie> collection){
        list.addAll(collection);
        this.notifyDataSetChanged();
    }
}
