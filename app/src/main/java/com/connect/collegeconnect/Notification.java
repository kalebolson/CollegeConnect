package com.connect.collegeconnect;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Notification {

    public static void displayNotificaton(Context mCtx,String title, String body){

        Intent intent = new Intent(mCtx,navigation.class);
        intent.putExtra("fragment","attenfrag");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(mCtx,100,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(mCtx,navigation.CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_stat_call_white)
                .setLargeIcon(BitmapFactory.decodeResource(mCtx.getResources(),R.mipmap.icon_round))
                .setContentTitle(title)
                .setContentText(body)
                .setColor(Color.parseColor("#138FF7"))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setVibrate(new long[]{100,200,300,400,500,400,300,200,400})
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setLights(Color.WHITE,500,500)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(mCtx);
        notificationManagerCompat.notify(1,builder.build());

    }
}
