package com.infolitz.newsapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        getFireBaseMessage(message.getNotification().getTitle(), message.getNotification().getBody());
        Log.d("firebAseMM", String.valueOf(message));
    }

    public void getFireBaseMessage(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myFirebaseChannel");
        builder.setSmallIcon(R.drawable.ic_logo);
        builder.setContentTitle(title);
        builder.setContentText(message);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(101, builder.build());
    }
}
