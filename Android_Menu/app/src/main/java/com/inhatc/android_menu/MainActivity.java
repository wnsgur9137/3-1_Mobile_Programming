package com.inhatc.android_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Group No.
    public static final int ID_GROUP_TEXT_COLOR     = 1;
    public static final int ID_GROUP_TEXT_STYLE     = 2;
    public static final int ID_GROUP_TEXT_SIZE      = 3;
    public static final int ID_GROUP_ARTIST         = 4;
    public static final int ID_GROUP_ALBUM          = 5;
    public static final int ID_GROUP_SONG           = 6;
    public static final int ID_GROUP_MOVIE          = 7;

    // Text Color Item No.
    public static final int ID_COLOR_RED            = 11;
    public static final int ID_COLOR_GREEN          = 12;
    public static final int ID_COLOR_BLUE           = 13;

    // Text Style Item No.
    public static final int ID_TEXT_NORMAL          = 21;
    public static final int ID_TEXT_ITALIC          = 22;
    public static final int ID_TEXT_BOLD            = 23;

    // Text Size Item No.
    public static final int ID_TEXTSIZE_10P         = 31;
    public static final int ID_TEXTSIZE_18P         = 32;
    public static final int ID_TEXTSIZE_24P         = 33;

    TextView objTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTextView = (TextView)findViewById(R.id.textView1);

        // Support context menu
        registerForContextMenu(objTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu mnuTextColor = menu.addSubMenu("Text Color");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_RED, 1, "Red");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_GREEN, 2, "Green");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_BLUE, 3, "Blue");

        SubMenu mnuTextStyle = menu.addSubMenu("Text Style");
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_NORMAL, 1, "Normal").setChecked(true);
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_ITALIC, 2, "Italic");
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_BOLD, 3, "Bold");

        SubMenu mnuTextSize = menu.addSubMenu("Text Size");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_10P, 1, "10 Pt");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_18P, 2, "18 Pt");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXTSIZE_24P, 3, "24 Pt");

        SubMenu mnuArtist = menu.addSubMenu("Artist");
        mnuArtist.setIcon(R.drawable.artist);

        SubMenu mnuAlbum = menu.addSubMenu("Album");
        mnuAlbum.setIcon(R.drawable.album);

        SubMenu mnuSong = menu.addSubMenu("Movie");
        mnuSong.setIcon(R.drawable.song);

        SubMenu mnuMovie = menu.addSubMenu("Movie");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case ID_COLOR_RED:
                objTextView.setTextColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTextView.setTextColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTextView.setTextColor(Color.BLUE);
                return true;
            case ID_TEXT_NORMAL:
                objTextView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                item.setChecked(true);
                return true;
            case ID_TEXT_ITALIC:
                objTextView.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                item.setChecked(true);
                return true;
            case ID_TEXT_BOLD:
                objTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                item.setChecked(true);
                return true;
            case ID_TEXTSIZE_10P:
                objTextView.setTextSize(10);
                return true;
            case ID_TEXTSIZE_18P:
                objTextView.setTextSize(18);
                return true;
            case ID_TEXTSIZE_24P:
                objTextView.setTextSize(24);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        SubMenu mnuTextBackGroundColor = menu.addSubMenu("Text Background Color");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_RED, Menu.NONE, "Red");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_GREEN, Menu.NONE, "Green");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_BLUE, Menu.NONE, "Blue");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case ID_COLOR_RED:
                objTextView.setBackgroundColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTextView.setBackgroundColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTextView.setBackgroundColor(Color.BLUE);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}