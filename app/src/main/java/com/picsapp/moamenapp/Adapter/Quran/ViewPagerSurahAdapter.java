package com.picsapp.moamenapp.Adapter.Quran;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.github.chrisbanes.photoview.PhotoView;

import org.jetbrains.annotations.NotNull;

public class ViewPagerSurahAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImageIds;

    public ViewPagerSurahAdapter(Context context, int[] mImageIds) {
        mContext = context;
        this.mImageIds = mImageIds;
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        return view == object;
    }

    @NotNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // PhotoView to zoom in the image "Instaded of ImageView"
        PhotoView imageView = new PhotoView (mContext);
        imageView.setImageResource(mImageIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NotNull Object object) {
        container.removeView((ImageView) object);
    }
}