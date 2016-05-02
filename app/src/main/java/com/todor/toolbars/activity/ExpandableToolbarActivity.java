package com.todor.toolbars.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.todor.tooblars.R;

import butterknife.BindView;

public class ExpandableToolbarActivity extends BaseActivity {

    @BindView(R.id.toolbar) protected Toolbar toolbar;
    @BindView(R.id.recycler_view) protected RecyclerView recyclerView;

    @Override
    public int getContentViewId() {
        return R.layout.expandable_toolbar_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupRecyclerView(recyclerView);
        setupToolbar(toolbar);
    }

}
