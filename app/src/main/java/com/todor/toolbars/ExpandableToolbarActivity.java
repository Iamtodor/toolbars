package com.todor.tooblars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.todor.tooblars.adapter.RecyclerViewAdapter;
import com.todor.tooblars.model.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableToolbarActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view) protected RecyclerView recyclerView;
    @BindView(R.id.toolbar) protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_toolbar_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, Utils.getItems());
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
        }
        return false;
    }
}
