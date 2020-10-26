package com.integro.dbhs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.integro.dbhs.R;
import com.integro.dbhs.model.CoverPhotos;

import java.util.ArrayList;


public class CoverPhotosAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<CoverPhotos> coverPhotosArrayList;

    public CoverPhotosAdapter(Context context, ArrayList<CoverPhotos> coverPhotosArrayList) {
        this.context = context;
        this.coverPhotosArrayList = coverPhotosArrayList;
    }

    @Override
    public int getCount() {
        return coverPhotosArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView ivImage;
        View view = LayoutInflater.from(context).inflate(R.layout.card_cover_photos, container, false);
        ivImage = view.findViewById(R.id.ivImage);
        Glide.with(context).load(coverPhotosArrayList.get(position).getImage()).into(ivImage);
        ((ViewPager) container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
