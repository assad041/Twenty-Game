package com.asd_soft.assaduzzaman_noor.twentygame;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NewGameActivity extends AppCompatActivity {
    int score;
    int progressStatus;
    ProgressBar Progress;
    private int[][] arr;

    SessionManager sessionManager;
    AI ai;
    Button[][] btn;
    Button[] setbtn;
    int a1,b1;
    TextView bTV;
    TextView sTV;
    Handler handler;
    Runnable runnable;
    int secondss;
    String time;
    int btime;
    int runtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        handler = new Handler();
        Progress = (ProgressBar) findViewById(R.id.progressBar);
        progressStatus=0;

        if(score!=0)
            run_timer();

        btn = new Button[10][10];
        setbtn = new Button[10];
        arr = new int[10][10];
        ai = new AI(NewGameActivity.this);


        a1=b1=9;
        secondss=0;





        sessionManager = new SessionManager(NewGameActivity.this);
        btime= sessionManager.getBTime();

        bTV = (TextView) findViewById(R.id.best) ;
        sTV = (TextView) findViewById(R.id.score);
        final String times;

        times=String.valueOf(btime);

        bTV.setText(times);




        btn[0][0]  = (Button) findViewById(R.id.b01);
        btn[0][1]  = (Button) findViewById(R.id.b02);
        btn[0][2]  = (Button) findViewById(R.id.b03);
        btn[0][3]  = (Button) findViewById(R.id.b04);
        btn[0][4]  = (Button) findViewById(R.id.b05);
        btn[0][5]  = (Button) findViewById(R.id.b06);
        btn[0][6]  = (Button) findViewById(R.id.b07);
        btn[0][7]  = (Button) findViewById(R.id.b08);

        btn[1][0]  = (Button) findViewById(R.id.b11);
        btn[1][1]  = (Button) findViewById(R.id.b12);
        btn[1][2]  = (Button) findViewById(R.id.b13);
        btn[1][3]  = (Button) findViewById(R.id.b14);
        btn[1][4]  = (Button) findViewById(R.id.b15);
        btn[1][5]  = (Button) findViewById(R.id.b16);
        btn[1][6]  = (Button) findViewById(R.id.b17);
        btn[1][7]  = (Button) findViewById(R.id.b18);

        btn[2][0]  = (Button) findViewById(R.id.b21);
        btn[2][1]  = (Button) findViewById(R.id.b22);
        btn[2][2]  = (Button) findViewById(R.id.b23);
        btn[2][3]  = (Button) findViewById(R.id.b24);
        btn[2][4]  = (Button) findViewById(R.id.b25);
        btn[2][5]  = (Button) findViewById(R.id.b26);
        btn[2][6]  = (Button) findViewById(R.id.b27);
        btn[2][7]  = (Button) findViewById(R.id.b28);

        btn[3][0]  = (Button) findViewById(R.id.b31);
        btn[3][1]  = (Button) findViewById(R.id.b32);
        btn[3][2]  = (Button) findViewById(R.id.b33);
        btn[3][3]  = (Button) findViewById(R.id.b34);
        btn[3][4]  = (Button) findViewById(R.id.b35);
        btn[3][5]  = (Button) findViewById(R.id.b36);
        btn[3][6]  = (Button) findViewById(R.id.b37);
        btn[3][7]  = (Button) findViewById(R.id.b38);

        btn[4][0]  = (Button) findViewById(R.id.b41);
        btn[4][1]  = (Button) findViewById(R.id.b42);
        btn[4][2]  = (Button) findViewById(R.id.b43);
        btn[4][3]  = (Button) findViewById(R.id.b44);
        btn[4][4]  = (Button) findViewById(R.id.b45);
        btn[4][5]  = (Button) findViewById(R.id.b46);
        btn[4][6]  = (Button) findViewById(R.id.b47);
        btn[4][7]  = (Button) findViewById(R.id.b48);

        btn[5][0]  = (Button) findViewById(R.id.b51);
        btn[5][1]  = (Button) findViewById(R.id.b52);
        btn[5][2]  = (Button) findViewById(R.id.b53);
        btn[5][3]  = (Button) findViewById(R.id.b54);
        btn[5][4]  = (Button) findViewById(R.id.b55);
        btn[5][5]  = (Button) findViewById(R.id.b56);
        btn[5][6]  = (Button) findViewById(R.id.b57);
        btn[5][7]  = (Button) findViewById(R.id.b58);

        btn[6][0]  = (Button) findViewById(R.id.b61);
        btn[6][1]  = (Button) findViewById(R.id.b62);
        btn[6][2]  = (Button) findViewById(R.id.b63);
        btn[6][3]  = (Button) findViewById(R.id.b64);
        btn[6][4]  = (Button) findViewById(R.id.b65);
        btn[6][5]  = (Button) findViewById(R.id.b66);
        btn[6][6]  = (Button) findViewById(R.id.b67);
        btn[6][7]  = (Button) findViewById(R.id.b68);

        btn[7][0]  = (Button) findViewById(R.id.b71);
        btn[7][1]  = (Button) findViewById(R.id.b72);
        btn[7][2]  = (Button) findViewById(R.id.b73);
        btn[7][3]  = (Button) findViewById(R.id.b74);
        btn[7][4]  = (Button) findViewById(R.id.b75);
        btn[7][5]  = (Button) findViewById(R.id.b76);
        btn[7][6]  = (Button) findViewById(R.id.b77);
        btn[7][7]  = (Button) findViewById(R.id.b78);





        for(int i=0; i<8;i++) {
            for (int j = 0; j < 8; j++) {
                final int a=i,b=j;
                btn[i][j].setOnClickListener(new View.OnClickListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    public void onClick(View v) {
                        if(progressStatus==100){
                            ai.setArrVal();
                            set_number();
                            progressStatus=0;
                        }
                        if(progressStatus==0)
                            run_timer();
                        if(arr[a][b]!=0) {
                            if (a1 < 9 && b1 < 9) {
                                if(arr[a1][b1]==arr[a][b] && (a!=a1 || b!=b1) ){

                                    ai.setVal(a,b,++arr[a][b]);
                                    ai.remove(a1,b1);
                                    set_number();
                                }
                            }
                            btn[a][b].setBackground(getDrawable(R.drawable.option));

                        }

                        if (a1 < 9 && b1 < 9)
                            btn[a1][b1].setBackground(getDrawable(R.drawable.button_bg));

                        a1 = a;
                        b1 = b;
                        ai.re_arrange();
                        set_number();
                        ai.setMax();
                        String s;
                        s=String.valueOf(ai.getMax());
                        sTV.setText(s);

                        int ses=ai.is_over();
                        if(ses==1)
                            game_over();





                    }
                });
            }
        }



        set_number();

    }

    void game_over(){
        score=ai.getMax();
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(NewGameActivity.this);
        dlgAlert.setMessage("  NEW : " + String.valueOf(score)+"            BEST : "+String.valueOf(sessionManager.getBTime())+"\n Are you want to play again ?");
        dlgAlert.setIcon(R.drawable.ic_launcher);
        dlgAlert.setTitle("GAME OVER");
        dlgAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(sessionManager.getBTime()<score){
                    sessionManager.setBTime(score);
                }

                Intent intent = new Intent(NewGameActivity.this,NewGameActivity.class);
                startActivity(intent);

            }
        });
        dlgAlert.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(sessionManager.getBTime()<score){
                    sessionManager.setBTime(score);
                }

                Intent intent = new Intent(NewGameActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        dlgAlert.setCancelable(false);
        dlgAlert.create().show();
    }


    void set_number(){
        arr = ai.getArr();
        for(int i=0; i<8;i++){
            for(int j=0; j<8;j++){
                if(arr[i][j] !=0 ){
                    btn[i][j].setText(String.valueOf(arr[i][j]));
                    if(arr[i][j]==1)
                        btn[i][j].setTextColor(Color.parseColor("#FF0000"));
                    else if(arr[i][j]==2)
                        btn[i][j].setTextColor(Color.parseColor("#00B700"));
                    else if(arr[i][j]==3)
                        btn[i][j].setTextColor(Color.parseColor("#FF00FF"));
                    else if(arr[i][j]==4)
                        btn[i][j].setTextColor(Color.parseColor("#800080"));
                    else if(arr[i][j]==5)
                        btn[i][j].setTextColor(Color.parseColor("#0000FF"));
                    else if(arr[i][j]==6)
                        btn[i][j].setTextColor(Color.parseColor("#000000"));
                    else if(arr[i][j]==7)
                        btn[i][j].setTextColor(Color.parseColor("#FF00FF"));
                    else if(arr[i][j]==8)
                        btn[i][j].setTextColor(Color.parseColor("#800080"));
                    else if(arr[i][j]==9)
                        btn[i][j].setTextColor(Color.parseColor("#FF0000"));
                    else if(arr[i][j]==10)
                        btn[i][j].setTextColor(Color.parseColor("#FF0080"));
                    else if(arr[i][j]==11)
                        btn[i][j].setTextColor(Color.parseColor("#34485e"));
                    else if(arr[i][j]==12)
                        btn[i][j].setTextColor(Color.parseColor("#FF00FF"));
                    else if(arr[i][j]==13)
                        btn[i][j].setTextColor(Color.parseColor("#00ffff"));
                    else if(arr[i][j]==14)
                        btn[i][j].setTextColor(Color.parseColor("#9A03FE"));
                    else if(arr[i][j]==15)
                        btn[i][j].setTextColor(Color.parseColor("#F70000"));
                    else if(arr[i][j]==16)
                        btn[i][j].setTextColor(Color.parseColor("#FF0080"));
                    else if(arr[i][j]==17)
                        btn[i][j].setTextColor(Color.parseColor("#000080"));
                    else if(arr[i][j]==18)
                        btn[i][j].setTextColor(Color.parseColor("#800080"));
                    else if(arr[i][j]==19)
                        btn[i][j].setTextColor(Color.parseColor("#FF0066"));
                    else if(arr[i][j]==20)
                        btn[i][j].setTextColor(Color.parseColor("#1FCB4A"));
                    else if(arr[i][j]==21)
                        btn[i][j].setTextColor(Color.parseColor("#FE67EB"));
                    else if(arr[i][j]==22)
                        btn[i][j].setTextColor(Color.parseColor("#9A03FE"));
                    else if(arr[i][j]==23)
                        btn[i][j].setTextColor(Color.parseColor("#FF0033"));
                    else if(arr[i][j]==24)
                        btn[i][j].setTextColor(Color.parseColor("#3300FF"));
                    else if(arr[i][j]==25)
                        btn[i][j].setTextColor(Color.parseColor("#FF0000"));
                    else if(arr[i][j]==26)
                        btn[i][j].setTextColor(Color.parseColor("#FF0033"));
                    else if(arr[i][j]==27)
                        btn[i][j].setTextColor(Color.parseColor("#FF0066"));
                    else if(arr[i][j]==28)
                        btn[i][j].setTextColor(Color.parseColor("#FF0099"));
                    else if(arr[i][j]==29)
                        btn[i][j].setTextColor(Color.parseColor("#FF00CC"));
                    else if(arr[i][j]==30)
                        btn[i][j].setTextColor(Color.parseColor("#FF00FF"));

                }else{
                    btn[i][j].setText("");
                }
            }
        }
    }

    void run_timer(){
        progressStatus=0;
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;

                    //Update progress bar with completion of operation

                    handler.post(new Runnable() {
                        public void run() {
                            Progress.setProgress(progressStatus);

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        int d=sessionManager.getDiffCode();
                        int time;
                        if(d==1)
                            time=70;
                        else if(d==2)
                            time=50;
                        else
                            time=30;
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void exit(View view) {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        finish();
    }


    public void back(View view) {
        Intent intent =new Intent(NewGameActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
