package com.todor.toolbars.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;

import com.todor.tooblars.R;

import butterknife.BindView;
import butterknife.OnClick;

public class NotificationsActivity extends BaseActivity {

    @BindView(R.id.toolbar) protected Toolbar mToolbar;
    private Bitmap mLargeItem;
    private Notification.Builder mNotification;
    private NotificationManager mNotificationManager;

    @Override
    public int getContentViewId() {
        return R.layout.notification_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupToolbar(mToolbar);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mLargeItem = BitmapFactory.decodeResource(getResources(), R.drawable.screenshot);
    }

    @OnClick(R.id.simple_notification)
    public void simpleNotification() {
        mLargeItem = BitmapFactory.decodeResource(getResources(), R.drawable.screenshot);
        mNotification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.notification_small_icon)
                .setLargeIcon(mLargeItem)
                .setContentTitle("Simple notification")
                .setContentText(getString(R.string.notification_content));

        if (Build.VERSION.SDK_INT >= 21) {
            mNotification.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        }

        mNotificationManager.notify(1, mNotification.build());
    }

    @OnClick(R.id.big_text_notification)
    public void bigTextNotification() {
        mNotification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.notification_small_icon)
                .setLargeIcon(mLargeItem)
                .setContentTitle("Big text notification")
                .setStyle(new Notification.BigTextStyle().bigText(getString(R.string.long_string)));

        mNotificationManager.notify(2, mNotification.build());
    }

    @OnClick(R.id.big_picture_notification)
    public void bigPictureNotification() {
        mNotification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.notification_small_icon)
                .setContentTitle("Big text notification")
                .setContentText("Content text")
                .setSubText("Sub text")
                .setStyle(new Notification.BigPictureStyle().bigPicture(mLargeItem));

        if (Build.VERSION.SDK_INT >= 21) {
            mNotification.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        }

        mNotificationManager.notify(3, mNotification.build());
    }

    @OnClick(R.id.inbox_notification)
    public void inboxNotification() {
        mNotification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.notification_small_icon)
                .setContentTitle("5 new mails")
                .setContentText("Content text")
                .setSubText("Sub text")
                .setStyle(new Notification.InboxStyle()
                        .addLine("Mail 1")
                        .addLine("Mail 2")
                        .addLine("Mail 3")
                        .addLine("Mail 4")
                        .addLine("Mail 5")
                        .setSummaryText("+2 more"));

        if (Build.VERSION.SDK_INT >= 21) {
            mNotification.setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        }

        mNotificationManager.notify(4, mNotification.build());
    }

    @OnClick(R.id.messaging_notification)
    public void messageNotification() {
        if (Build.VERSION.SDK_INT >= 24) {
            mNotification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.notification_small_icon)
                    .setContentTitle("5 new mails")
                    .setContentText("Content text")
                    .setSubText("Sub text")
                    .setStyle(new Notification.MessagingStyle("Me")
                            .setConversationTitle("Share food")
                            .addMessage("Message 1", 1000L, "Companion 1")
                            .addMessage("Message 2", 1000L, "Companion 2")
                            .addMessage("Message 3", 1000L, "Companion 3")
                            .addMessage("Message 4", 1000L, "Companion 4")
                            .addMessage("Message 5", 1000L, "Companion 5"))
                    .setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
            mNotificationManager.notify(5, mNotification.build());
        } else {
            Snackbar.make(mToolbar, "Api 24 is required", Snackbar.LENGTH_SHORT).show();
        }

    }

}
