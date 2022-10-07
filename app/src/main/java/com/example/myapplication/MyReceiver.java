package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings;

public class MyReceiver extends BroadcastReceiver {
    MediaPlayer playDefaultRingtone;
    Uri alarmTone;
    Ringtone ringtoneAlarm;

    @Override
    public void onReceive(Context context, Intent intent) {

        alarmTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        ringtoneAlarm = RingtoneManager.getRingtone(context, alarmTone );
        ringtoneAlarm.play();

//        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // Set the alarm here.
            alarmTone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            ringtoneAlarm = RingtoneManager.getRingtone(context, alarmTone );
            ringtoneAlarm.play();
//        }




//        playDefaultRingtone=MediaPlayer.create(context , Settings.System.DEFAULT_ALARM_ALERT_URI);
//          playDefaultRingtone.setLooping(true);
//        playDefaultRingtone.start();

    }

}
