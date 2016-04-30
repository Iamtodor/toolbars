package com.todor.tooblars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.toolbar) protected Toolbar toolbar;
    @BindView(R.id.expandable_toolbar) Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExpandableToolbarActivity.class));
            }
        });
    }

//    @OnClick(R.id.expandable_toolbar)
//    public void expandableToolbarClick() {
//        startActivity(new Intent(this, ExpandableToolbarActivity.class));
//
//    }

}