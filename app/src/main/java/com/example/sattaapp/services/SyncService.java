package com.example.sattaapp.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.example.sattaapp.data.DataManager;
import com.example.sattaapp.di.component.DaggerServiceComponent;
import com.example.sattaapp.di.component.ServiceComponent;
import com.example.sattaapp.ui.base.VoicemeApplication;

import javax.inject.Inject;


public class SyncService extends Service {
    public SyncService() {
    }

    private static final String TAG = "SyncService";


    @Inject
    DataManager mDataManager;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService.class);
    }

    public static void start(Context context) {
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, SyncService.class));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceComponent component = DaggerServiceComponent.builder()
                .applicationComponent(((VoicemeApplication) getApplication()).getComponent())
                .build();
        component.inject(this);

       // mDataManager.updateTimeOnline(MySharedPreferences.getFireBaseToken((((VoicemeApplication)getApplication()).getSharedPreferences(CONSTANT_PREF_FILE, Context.MODE_PRIVATE))), MySharedPreferences.getUserId((((VoicemeApplication)getApplication()).getSharedPreferences(CONSTANT_PREF_FILE, Context.MODE_PRIVATE))));
      //  mDataManager.updateTimeOnline("hello", "33049");

        //mDataManager.sendNotification()

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    //    AppLogger.d(TAG, "SyncService started");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
     //   AppLogger.d(TAG, "SyncService stopped");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
