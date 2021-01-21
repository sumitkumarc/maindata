package ontime.app.utils;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.net.HttpURLConnection;
import java.net.URL;

import ontime.app.R;
import ontime.app.customer.Activity.MainActivity;
import ontime.app.customer.doneActivity.MyOrdersListActivity;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    Bitmap bitmap;
    Intent intent;
    long reminderDateTimeInMilliseconds = 0;

    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            Log.d(TAG, "From: " + remoteMessage.getFrom());
            this.bitmap = getBitmapfromUrl(remoteMessage.getData().get("image"));
            if (remoteMessage.getData().size() > 0) {
                Log.d(TAG, "Message data payload: " + remoteMessage.getData());
                sendNotification(this.bitmap, remoteMessage);
            }
            if (remoteMessage.getNotification() != null) {
                Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            }
        } catch (Exception e) {

        }

    }

    private void scheduleJob(String body, String title, String image, String scheduledTime) {
        // WorkManager.getInstance().beginWith((OneTimeWorkRequest) new OneTimeWorkRequest.Builder(MyWorker.class).build()).enqueue();
    }

    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);
        sendRegistrationToServer(token);
    }

    private void handleNow() {
        Log.d(TAG, "Short lived task is done.");
    }

    private void sendRegistrationToServer(String token) {
    }

    @SuppressLint("WrongConstant")
    private void sendNotification(Bitmap bitmap2, RemoteMessage remoteMessage) {
        try {
            if (!remoteMessage.getData().get("noty_type").equals("0")) {
                Intent intent2 = new Intent(this, MyOrdersListActivity.class);
                this.intent = intent2;
                intent2.putExtra("NOTY_TYPE", remoteMessage.getData().get("noty_type"));
                intent2.putExtra("ORDER_ID", remoteMessage.getData().get("order_id"));
                this.intent.addFlags(603979776);
            } else {
                Intent intent4 = new Intent(this, MainActivity.class);
                this.intent = intent4;
                intent4.addFlags(603979776);
            }
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, this.intent, 134217728);
            String channelId = getString(R.string.app_name);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, channelId).setStyle(new NotificationCompat.BigPictureStyle()
                    .bigPicture(bitmap2))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Order status update")
//                .setContentText(remoteMessage.getData().get(HtmlTags.BODY))
                    .setAutoCancel(true)
                    .setSound(RingtoneManager.getDefaultUri(2))
                    .setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel(channelId, "Channel human readable title", 3));
            }
            notificationManager.notify(0, notificationBuilder.build());
        } catch (Exception e) {
        }

    }

    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
            connection.setDoInput(true);
            connection.connect();
            return BitmapFactory.decodeStream(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
