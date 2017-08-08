package com.asd_soft.assaduzzaman_noor.twentygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultyActivity extends AppCompatActivity {
    Button btes;
    Button btmd;
    Button bthd;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        btes = (Button) findViewById(R.id.es);
        btmd = (Button) findViewById(R.id.md);
        bthd = (Button) findViewById(R.id.hd);
        sessionManager = new SessionManager(DifficultyActivity.this);
        if(sessionManager.getDiffCode()==1){
            btes.setText("✓ "+"EASY  ");
        }else if(sessionManager.getDiffCode()==2){
            btmd.setText("✓ "+"MEDIUM ");
        }else if(sessionManager.getDiffCode()==3){
            bthd.setText("✓ "+"HARD  ");
        }

    }

    public void back(View view) {
        Intent intent = new Intent(DifficultyActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void done(View view) {
        Intent intent = new Intent(DifficultyActivity.this,MainActivity.class);
        startActivity(intent);
    }


    public void easy(View view) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Are You Sure! You Want To Change Difficulty Level Easy.");
        dlgAlert.setIcon(R.drawable.ic_launcher);
        dlgAlert.setTitle("Easy");
        dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                SessionManager sessionManager=new SessionManager(DifficultyActivity.this);
                sessionManager.setDiffCode(1);
                Intent intent = new Intent(DifficultyActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        dlgAlert.setNegativeButton("No",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dlgAlert.setCancelable(false);
        dlgAlert.create().show();
    }

    public void medium(View view) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Are You Sure! You Want To Change Difficulty Level Medium.");
        dlgAlert.setIcon(R.drawable.ic_launcher);
        dlgAlert.setTitle("Medium");
        dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                SessionManager sessionManager=new SessionManager(DifficultyActivity.this);
                sessionManager.setDiffCode(2);
                Intent intent = new Intent(DifficultyActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        dlgAlert.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        dlgAlert.setCancelable(false);
        dlgAlert.create().show();
    }

    public void hard(View view) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Are You Sure! You Want To Change Difficulty Level Hard.");
        dlgAlert.setIcon(R.drawable.ic_launcher);
        dlgAlert.setTitle("Hard");
        dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                SessionManager sessionManager=new SessionManager(DifficultyActivity.this);
                sessionManager.setDiffCode(3);
                Intent intent = new Intent(DifficultyActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        dlgAlert.setNegativeButton("No",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dlgAlert.setCancelable(false);
        dlgAlert.create().show();
    }
}
