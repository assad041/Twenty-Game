package com.asd_soft.assaduzzaman_noor.twentygame;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by User on 1/13/2017.
 */
public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final String SESSION_FILE_NAME = "Suduku";
    private final String DIFFICULTY = "diffCode";
    private final String BEST_TIME = "BTime";
    private final String RUNNING_TIME = "RTime";
    private final String SEC_TIME = "STime";
    private final String MIN_TIME = "MTime";
    private final String SSEC_TIME = "SSTime";
    private final String MMIN_TIME = "MMTime";


    private Context context;
    private int diffCode;
    private int BTime;
    private int RTime;
    private int STime;
    private int MTime;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SESSION_FILE_NAME,context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public int getDiffCode() {
        diffCode = sharedPreferences.getInt(DIFFICULTY,1);
        return diffCode;
    }

    public void setDiffCode(int diffCode) {
        editor.putInt(DIFFICULTY,diffCode);
        editor.commit();
    }

    public int getSTime() {
        BTime = sharedPreferences.getInt(SEC_TIME,0);
        return BTime;
    }

    public int getSSTime() {
        BTime = sharedPreferences.getInt(SSEC_TIME,0);
        return BTime;
    }

    public void setSTime(int BTime) {
        editor.putInt(SEC_TIME,BTime);
        editor.commit();
    }

    public void setSSTime(int BTime) {
        editor.putInt(SSEC_TIME,BTime);
        editor.commit();
    }

    public int getMTime() {
        BTime = sharedPreferences.getInt(MIN_TIME,0);
        return BTime;
    }

    public int getMMTime() {
        BTime = sharedPreferences.getInt(MMIN_TIME,0);
        return BTime;
    }


    public void setMTime(int BTime) {
        editor.putInt(MIN_TIME,BTime);
        editor.commit();
    }

    public void setMMTime(int BTime) {
        editor.putInt(MMIN_TIME,BTime);
        editor.commit();
    }

    public int getBTime() {
        BTime = sharedPreferences.getInt(BEST_TIME,0);
        return BTime;
    }

    public void setBTime(int BTime) {
        editor.putInt(BEST_TIME,BTime);
        editor.commit();
    }

    public int getRTime() {
        RTime = sharedPreferences.getInt(RUNNING_TIME,0);
        return RTime;
    }

    public void setRTime(int RTime) {
        editor.putInt(RUNNING_TIME,RTime);
        editor.commit();
    }
}
