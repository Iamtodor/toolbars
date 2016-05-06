package com.todor.toolbars.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.todor.tooblars.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.toolbar) protected Toolbar toolbar;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);

        setStatusBarTranslucent(true);
    }

    protected void setStatusBarTranslucent(boolean makeTranslucent) {
        View v = findViewById(R.id.bellow_actionbar);
        if (v != null) {
            int paddingTop = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT ? getStatusBarHeight() : 0;
            TypedValue tv = new TypedValue();
            getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarSize, tv, true);
            paddingTop += TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            v.setPadding(0, makeTranslucent ? paddingTop : 0, 0, 0);
        }

        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @OnClick(R.id.expandable_toolbar)
    public void expandableToolbar() {
        startActivity(new Intent(this, ExpandableToolbarActivity.class));
    }

    @OnClick(R.id.parallax_toolbar)
    public void parallaxToolbar() {
        startActivity(new Intent(this, ParallaxToolbarActivity.class));
    }

    @OnClick(R.id.hide_toolbar)
    public void hideToolbar() {
        startActivity(new Intent(this, HideToolbarActivity.class));
    }

    @OnClick(R.id.toolbar_with_tablayout)
    public void toolbarWithTabLayout() {
        startActivity(new Intent(this, ToolbarWithTabLayoutActivity.class));
    }

}