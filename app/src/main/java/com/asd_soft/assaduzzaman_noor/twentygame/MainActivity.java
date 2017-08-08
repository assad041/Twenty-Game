package com.asd_soft.assaduzzaman_noor.twentygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void difficalty(View view) {
        Intent intent = new Intent(MainActivity.this,DifficultyActivity.class);
        startActivity(intent);
    }

    public void ng(View view) {

        Intent intent = new Intent(MainActivity.this,NewGameActivity.class);
        startActivity(intent);

    }



    public void play(View view) {

        Intent intent = new Intent(MainActivity.this,NewGameActivity.class);
        startActivity(intent);
    }

    public void exit(View view) {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        finish();
    }

    public void hp(View view) {
        Intent intent = new Intent(MainActivity.this,HPActivity.class);
        startActivity(intent);
    }
}
