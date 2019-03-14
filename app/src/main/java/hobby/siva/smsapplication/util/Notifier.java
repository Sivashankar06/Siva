package hobby.siva.smsapplication.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import hobby.siva.smsapplication.R;
import hobby.siva.smsapplication.ui.MainActivity;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public class Notifier {

    public static void showNotification(Context context,  String sender, String message) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notification = createNotification(context);
        notification.setContentText(sender);
        notification.setSubText(message);
        notificationManager.notify(631988, notification.build());
    }

    private static NotificationCompat.Builder createNotification(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        String title = context.getResources().getString(R.string.app_name);

        // Build notification
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, "general_notification");

        notification.setContentTitle(title)
                .setColor(context.getResources().getColor(R.color.colorPrimary))
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentIntent(pIntent)
                .setOngoing(true);
        return notification;
    }
}