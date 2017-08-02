package com.gabrielrivera.gotolunch;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;

/**
 * Created by gabrielrivera on 7/19/17.
 */

public class GLunch extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseAnalytics.getInstance(this).setUserId("abcx");
        FirebaseAnalytics.getInstance(this).setUserProperty("user_lang", "en");
        new GetTokenAsync().execute();
    }

    private class GetTokenAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                String token = FirebaseInstanceId.getInstance().getToken("SENDER_ID", "FCM");
                FirebaseMessaging.getInstance().unsubscribeFromTopic("notifications");
                Log.d("Application", "token: " + token);
            } catch (IOException e) {
                Log.d("Application", "Error: " + e.getLocalizedMessage());
            }
            return null;
        }
    }

}
