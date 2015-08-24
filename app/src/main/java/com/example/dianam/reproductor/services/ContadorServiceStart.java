package com.example.dianam.reproductor.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.dianam.reproductor.MainActivity;


/**
 * Created by DianaM on 24/08/2015.
 */
public class ContadorServiceStart extends Service {

    public static final String ACTION1 = "action1";
    public static final String ACTION2 = "action2";
    public static final String ACTION3 = "action3";

    HandlerService handlerService;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HandlerThread thread = new HandlerThread("handlerThread",Thread.MAX_PRIORITY);
        thread.start();

        handlerService = new HandlerService(thread.getLooper());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Message message = handlerService.obtainMessage();
        message.obj = intent;
        handlerService.sendMessage(message);

        return START_REDELIVER_INTENT;
    }

    public class HandlerService extends Handler
    {
        public HandlerService(Looper looper)
        {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            Intent intent = (Intent) msg.obj;
            if (intent.getAction().equals(ACTION1))
            {
                Log.i("TAG", "Action1");
            }
            else if (intent.getAction().equals(ACTION2))
            {
                Log.i("TAG","Action2");
            }
            else if (intent.getAction().equals(ACTION3))
            {

                for (int i = 0; i< 20; i++)
                {
                    try {
                        Thread.sleep(1000);
                        Log.i("TAG","Segundo: "+i );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stopSelf();

            }

        }


    }
}
