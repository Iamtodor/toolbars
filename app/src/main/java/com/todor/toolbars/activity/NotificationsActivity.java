package com.todor.toolbars.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
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
}
