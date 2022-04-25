package com.inhatc.android_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Gallery objGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objGallery = (Gallery)findViewById(R.id.gallery1);
        objGallery.setAdapter(new ImageAdapter(this));
        objGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        int mGalleryItemBackgorund;
        private Context mContext;
        private Integer[] mThumbIds = {
                R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
                R.drawable.img_4, R.drawable.img_5, R.drawable.img_6,
                R.drawable.img_7, R.drawable.img_8, R.drawable.img_9
        };

        public ImageAdapter(Context objContext) {
            mContext = objContext;
            TypedArray objArray = obtainStyledAttributes(R.styleable.gallery1);
            mGalleryItemBackgorund = objArray.getResourceId(
                    R.styleable.gallery1_android_galleryItemBackground, 0);
            objArray.recycle();
        }
        public int getCount() { return mThumbIds.length; }
        public Object getItem(int position) { return position; }
        public long getItemId(int position) { return position; }

        // Adapter에 의해 참조되는 각 item을 new ImageView 생성
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView objImgView;

            objImgView = new ImageView(mContext);
            objImgView.setImageResource(mThumbIds[position]);
            objImgView.setLayoutParams(new ViewGroup.LayoutParams(150, 100));
            objImgView.setScaleType(ImageView.ScaleType.FIT_XY);
            objImgView.setBackgroundResource(mGalleryItemBackgorund);
            return objImgView;
        }
    }
}