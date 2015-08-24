package com.example.dianam.reproductor.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.dianam.reproductor.MainActivity;

/**
 * Created by DianaM on 24/08/2015.
 */
public class ContadorService extends IntentService {

    public static final String ACTION1 = "action1";
    public static final String ACTION2 = "action2";
    public static final String ACTION3 = "action3";


    public ContadorService() {
        super("ContadorServicio");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
            if (intent.getAction().equals(ACTION1))
            {
                Log.i("TAG","Action1");
            }
            else if (intent.getAction().equals(ACTION2))
            {
                Log.i("TAG","Action2");
            }
            else if (intent.getAction().equals(ACTION3))
            {
                Intent intent1 = new Intent(this, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this,101,intent1,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification notification = new NotificationCompat.Builder(this)
                        .setContentTitle("Contando")
                        .setContentText("Servicio corriendo")
                        .setSmallIcon(android.R.drawable.ic_media_play)
                        .setContentIntent(pi)
                        .build();
                startForeground(101,notification);
                for (int i = 0; i< 20; i++)
                {
                    try {
                        Thread.sleep(1000);
                        Log.i("TAG","Segundo: "+i );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopForeground(true);
            }
    }
}
