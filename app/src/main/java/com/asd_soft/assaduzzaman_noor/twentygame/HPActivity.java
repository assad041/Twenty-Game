package com.asd_soft.assaduzzaman_noor.twentygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);
    }
    public void back(View view) {
        Intent intent = new Intent(HPActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void done(View view) {
        Intent intent = new Intent(HPActivity.this,MainActivity.class);
        startActivity(intent);
    }

}
