package com.todor.tooblars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.toolbar) protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
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
        startActivity(new Intent(this, HideToolbar.class));
    }

}