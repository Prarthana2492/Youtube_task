package com.example.farmpe_stream;

import android.app.Activity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


public class Video_Adapter extends RecyclerView.Adapter<Video_Adapter.MyViewHolder> {


    private List<Video_Bean> productList;
    Activity activity;
    Fragment selectedFragment;



    public Video_Adapter(Activity activity, List<Video_Bean> moviesList) {
        this.productList = moviesList;
        this.activity = activity;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image, default_image;
        public LinearLayout item;
        public TextView prod_name,second_video_name;



        public MyViewHolder(View view) {
            super(view);
            prod_name = view.findViewById(R.id.prod_name);
            image = view.findViewById(R.id.image);
            second_video_name = view.findViewById(R.id.second_video_name);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_adapter_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Video_Bean products = productList.get(position);


        holder.prod_name.setText(products.name);
        holder.second_video_name.setText(products.secong_name);


        Glide.with(activity).load(products.getImage())
                .thumbnail(0.5f)
                // .crossFade()
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
                        .error(R.drawable.ic_like))
                .into(holder.image);

    }


    @Override
    public int getItemCount() {
        System.out.println("lengthhhhhhh" + productList.size());
        return productList.size();
    }

}