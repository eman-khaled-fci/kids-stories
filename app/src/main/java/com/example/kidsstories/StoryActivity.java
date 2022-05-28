package com.example.kidsstories;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        String returnedStory=getIntent().getStringExtra("story");
        int returnedPicture=getIntent().getIntExtra("picture",0);
        String title=getIntent().getStringExtra("actionBar");
        setTitle(title);
        TextView textView=findViewById(R.id.story);
        ImageView imageView=findViewById(R.id.image);
        textView.setText(returnedStory);
        imageView.setImageResource(returnedPicture);
        SharedPreferences sharedPreferences=getSharedPreferences("Text File",MODE_PRIVATE);
        int returnedSize =sharedPreferences.getInt("text size",20);
        textView.setTextSize(returnedSize);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setTypeface(null, Typeface.BOLD);
    }
}