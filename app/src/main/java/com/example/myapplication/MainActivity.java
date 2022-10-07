package com.example.myapplication;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    static final int TRIGGER_REQ_CODE=100;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        // 1800000

//      alarm();

//      countdownTimer();

        settingAlarmUsingCalendarClass();

 /*     ComponentName receiver = new ComponentName(getApplicationContext() , MyReceiver.class);
        PackageManager pm = getApplicationContext().getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);                              */


    }

/*    void alarm(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());



        final long triggerTime= System.currentTimeMillis() + 90000;
        Intent iBroadCast=new Intent(getApplicationContext() , MyReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext() , TRIGGER_REQ_CODE , iBroadCast , PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() + 90000, pendingIntent);
    }

    void countdownTimer(){
        new CountDownTimer(1800000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
               alarm();
            }
        };
    }                                              */

    void settingAlarmUsingCalendarClass(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());


        Calendar trigger=calendar;
        trigger.add(Calendar.MINUTE , 30 );
        long triggerTime=trigger.getTimeInMillis();
        Log.d("RES", String.valueOf(trigger.getTimeInMillis()));
        Intent iBroadCast=new Intent(getApplicationContext() , MyReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext() , TRIGGER_REQ_CODE , iBroadCast , PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP , triggerTime , pendingIntent);
    }


}