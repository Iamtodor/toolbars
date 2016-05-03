package com.todor.toolbars.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.todor.tooblars.R;

import butterknife.BindView;

public class HideToolbarActivity extends BaseActivity {

    @BindView(R.id.toolbar) protected Toolbar toolbar;
    @BindView(R.id.recycler_view) protected RecyclerView recyclerView;
    @BindView(R.id.fab) protected FloatingActionButton fab;

    @Override
    public int getContentViewId() {
        return R.layout.hide_toolbar_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupRecyclerView(recyclerView);
        setupToolbar(toolbar);
        setFabBehavior();
    }

    private void setFabBehavior() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && fab.isShown())
                    fab.hide();
                else if (dy < 0 && !fab.isShown())
                    fab.show();
            }
        });
    }
}
