package com.asd_soft.assaduzzaman_noor.twentygame;

import android.content.Context;

import java.util.Random;

/**
 * Created by User on 1/13/2017.
 */
public class AI {
    private int[][] arr;
    private int x;
    private int[] y;
    private int max;
    private int val;

    private int randNumber;
    private Context context;
    private SessionManager sessionManager;



    public AI(Context context) {
        this.context = context;
        arr = new int[10][10];

        y = new int[10];
       for(int i=0; i<8;i++){
           y[i]=7;
           for(int j=0; j<8;j++){
               arr[i][j] = 0;
           }
       }

        setArrVal();


    }
    public int getMax() {
        return max;
    }

    public void setMax() {
        max=0;
        for(int i=0; i<8;i++){
            for(int j=0; j<8;j++){
                if(arr[i][j]>max)
                    max=arr[i][j];
            }
        }
    }
    int is_over(){
        for (int i=0; i<8;i++)
        {
            if(y[i]<-1)
                return 1;
        }
        return 0;
    }

    public void re_arrange(){
        for(int i=0; i<8;i++){
            for(int j=1; j<8;j++){
                if(arr[j][i]==arr[j-1][i] && arr[j][i]!=0){
                    arr[j][i]++;
                    remove(j-1,i);
                    j--;
                }

            }
        }
    }

    public void remove(int i, int j){
        y[j]++;
        arr[i][j]=0;
        for(int k=i; k>0; k--){
            arr[k][j]=arr[k-1][j];
        }
    }

    public void setArrVal() {
        for(int i=0; i<8;i++){
            if(y[i]>=0){
                val = getRandomNumber(1,4);
                arr[y[i]][i] = val;
            }
            y[i]--;
        }
    }

    public void setVal(int i, int j, int val) {
        arr[i][j]=val;
    }

    public boolean cheak_True(int i, int j, int val) {
        for (int k = 0; k < 8; k++) {
            if (arr[k][j] == val && k!=i) return  false;
            if (arr[i][k] == val && k!=j) return  false;
        }
        return true;
    }





    public int[][] getArr() {
        return arr;
    }




    public int getRandomNumber(int min,int max){
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

}
