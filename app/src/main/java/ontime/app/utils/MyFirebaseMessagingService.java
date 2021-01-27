package ontime.app.utils;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ontime.app.R;
import ontime.app.customer.Activity.MainActivity;
import ontime.app.customer.doneActivity.MyOrdersListActivity;
import ontime.app.restaurant.ui.Activity.RiderOrderDetails;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    Bitmap bitmap;
    long reminderDateTimeInMilliseconds = 000;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        String noty_type = remoteMessage.getData().get("noty_type");
        String order_id = remoteMessage.getData().get("order_id");
//        bitmap = getBitmapfromUrl(imageUri);
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            sendNotification(bitmap, remoteMessage);
        }
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }

    private void scheduleJob(String body, String title, String image, String scheduledTime) {
        OneTimeWorkRequest work = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        WorkManager.getInstance().beginWith(work).enqueue();
    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    private void handleNow() {

        Log.d(TAG, "Short lived task is done.");
    }

    private void sendRegistrationToServer(String token) {

    }

    Intent intent;

    private void sendNotification(Bitmap bitmap, RemoteMessage remoteMessage) {
            if (remoteMessage.getData().get("noty_type").equals("2") || remoteMessage.getData().get("noty_type").equals("4")|| remoteMessage.getData().get("noty_type").equals("5")) {
                intent = new Intent(this, MyOrdersListActivity.class);
                intent.putExtra("order_id", remoteMessage.getData().get("order_id"));
                intent.putExtra("noty_type", remoteMessage.getData().get("noty_type"));
            } else if (remoteMessage.getData().get("noty_type").equals("1") || remoteMessage.getData().get("noty_type").equals("3")) {
                intent = new Intent(this, RiderOrderDetails.class);
                intent.putExtra("order_id", remoteMessage.getData().get("order_id"));
                intent.putExtra("noty_type", remoteMessage.getData().get("noty_type"));
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);
            String channelId = getString(R.string.app_name);
            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder =
                    new NotificationCompat.Builder(this, channelId)
//                        .setLargeIcon(bitmap)
//                        .setStyle(new NotificationCompat.BigPictureStyle()
//                                .bigPicture(bitmap))/*Notification with Image*/
                            .setSmallIcon(R.drawable.logo_2)
                            .setContentTitle(getString(R.string.app_name))
                            .setContentText(remoteMessage.getData().get("order_id"))
                            .setAutoCancel(true)
                            .setSound(defaultSoundUri)
                            .setContentIntent(pendingIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(channelId,
                        "Channel human readable title",
                        NotificationManager.IMPORTANCE_HIGH);
                notificationManager.createNotificationChannel(channel);
            }

            notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
//        } catch (Exception e) {
//        }
    }

    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }


}
