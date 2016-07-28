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
    }

    @OnClick(R.id.simple_notification)
    public void simpleNotification() {
        mLargeItem = BitmapFactory.decodeResource(getResources(), R.drawable.screenshot);
        if(Build.VERSION.SDK_INT >= 21) {
            mNotification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.notification_small_icon)
                    .setLargeIcon(mLargeItem)
                    .setContentTitle(getString(R.string.notification_title))
                    .setContentText(getString(R.string.notification_content))
                    .setColor(ContextCompat.getColor(this, android.R.color.holo_red_light));
        } else {
            mNotification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.notification_small_icon)
                    .setLargeIcon(mLargeItem)
                    .setContentTitle(getString(R.string.notification_title))
                    .setContentText(getString(R.string.notification_content));
        }
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mNotification.build());
    }
}
