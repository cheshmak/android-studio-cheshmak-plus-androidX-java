package me.cheshmak.samplecheshmakplus;

import android.app.Application;
import android.util.Log;

import me.cheshmak.android.sdk.core.Cheshmak;
import me.cheshmak.android.sdk.core.network.CheshmakCallback;
import me.cheshmak.cheshmakplussdk.core.CheshmakPlus;

public class ApplicationClass extends Application {


    @Override
    public void onCreate() {

        super.onCreate();
        Log.e("----------", "MainActivity");
        Cheshmak.with(ApplicationClass.this);
        CheshmakPlus.with(ApplicationClass.this);
//        Cheshmak.initTracker("r035KbHW8OcMwBQhPs+Jpg==");
        Cheshmak.initTracker("Vw++0Y+5wKSf0bvZnpFrKg==", new CheshmakCallback() {
            @Override
            public void onCheshmakIdReceived(String cheshmakID) {
                Log.e("----------", "CheshmakID = " + cheshmakID);
            }
        });
        CheshmakPlus.setTestMode(true);


    }


}
