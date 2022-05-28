package com.example.kidsstories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        RadioGroup radioGroup=findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.large:
                        setTextSize(32);
                        break;
                    case R.id.meduim:
                        setTextSize(24);
                        break;
                    case R.id.small:
                        setTextSize(18);
                        break;
                }
            }
        });
    }
    public void setTextSize(int size){
        SharedPreferences.Editor editor=getSharedPreferences("Text File",MODE_PRIVATE).edit();
        editor.putInt("text size",size);
        editor.apply();
    }
}