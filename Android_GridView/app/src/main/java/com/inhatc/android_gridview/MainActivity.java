package com.inhatc.android_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView objGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objGridView = (GridView)findViewById(R.id.gridView1);
        objGridView.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] mThumbIds = {
                R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
                R.drawable.img_4, R.drawable.img_5, R.drawable.img_6,
                R.drawable.img_7, R.drawable.img_8, R.drawable.img_9
        };

        public ImageAdapter(Context objC) { mContext = objC; }
        public int getCount() { return mThumbIds.length; }
        public Object getItem(int position) { return null; }
        public long getItemId(int position) { return 0; }

        // Adapter에 의해 참조되는 각 item을 위한 new ImageView 생성
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView objImgView;

            if(convertView == null) {
                objImgView = new ImageView(mContext);
                objImgView.setLayoutParams(new GridView.LayoutParams(85, 85));
                objImgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                objImgView.setPadding(8, 8, 8, 8);
            } else {
                objImgView = (ImageView)convertView;
            }
            objImgView.setImageResource(mThumbIds[position]);
            return objImgView;
        }
    }
}