package com.example.furofo.areyouconnected;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final String CHANNEL_ID = "wifiNotification";
    private final int NOTIFICATION_ID = 001;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

        public void displayNotification(View view) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setContentTitle("Are you on Wifi");
            builder.setContentText("this is simple notification");
            builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
        }


        private void createNotificationChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CharSequence name = "hello";
                String description = "Display if on wifi or not";
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
                channel.setDescription(description);
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(channel);


            }
        }


    }


