package me.cheshmak.samplecheshmakplus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import me.cheshmak.cheshmakplussdk.advertise.CheshmakInterstitialAd;
import me.cheshmak.cheshmakplussdk.advertise.CheshmakNativeBannerAd;
import me.cheshmak.cheshmakplussdk.advertise.CheshmakRewardedAd;
import me.cheshmak.cheshmakplussdk.advertise.InterstitialCallback;
import me.cheshmak.cheshmakplussdk.advertise.NativeBannerCallback;
import me.cheshmak.cheshmakplussdk.advertise.RewardedCallback;

public class MainActivity extends AppCompatActivity {

    private CheshmakInterstitialAd cheshmakInterstitialAd;
    private CheshmakRewardedAd cheshmakRewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cheshmakInterstitialAd = new CheshmakInterstitialAd(this, new InterstitialCallback() {
            @Override
            public void onAdLoaded() {
                Log.d("Interstitial", "onAdLoaded");
            }

            @Override
            public void onAdOpened() {
                Log.d("Interstitial", "onAdOpened");
            }

            @Override
            public void onAdFailedToLoad() {
                Log.d("Interstitial", "onAdFailedToLoad");
            }

            @Override
            public void onAdClosed() {
                Log.d("Interstitial", "onAdClosed");
            }

        });

        final Button in = findViewById(R.id.interstitial);

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheshmakInterstitialAd.show();
            }
        });

        cheshmakRewardedAd = new CheshmakRewardedAd(this, new RewardedCallback() {
            @Override
            public void onRewardedVideoAdLoaded() {

            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad() {

            }

            @Override
            public void onRewarded() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }
        });

        Button rw = findViewById(R.id.rewarded);

        rw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheshmakRewardedAd.show();
            }
        });

        ViewGroup adContainer = findViewById(R.id.nativeAdContainer);
        CheshmakNativeBannerAd cheshmakNativeBannerAd = new CheshmakNativeBannerAd(MainActivity.this,
                adContainer, R.layout.ad_unified, new NativeBannerCallback() {
            @Override
            public void onAdLoaded() {
                Log.d("native banner", "onAdLoaded");
            }

            @Override
            public void onAdOpened() {
                Log.d("native banner", "onAdOpened");
            }

            @Override
            public void onAdFailedToLoad() {
                Log.d("native banner", "onAdFailedToLoad");
            }

            @Override
            public void onAdClosed() {
                Log.d("native banner", "onAdClosed");
            }
        });
    }
}
