package ro.pub.cs.systems.eim.colocviu1_2.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import ro.pub.cs.systems.eim.colocviu1_2.general.Constants;

public class Colocviu1_2Service extends Service {
    ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("service started");
        int firstNumber = intent.getIntExtra(Constants.SUM, -1);
        processingThread = new ProcessingThread(this, firstNumber);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}
