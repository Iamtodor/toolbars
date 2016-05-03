package com.todor.toolbars.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.todor.tooblars.R;
import com.todor.tooblars.Utils;
import com.todor.tooblars.adapter.RecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFragment extends android.support.v4.app.Fragment {

    @BindView(R.id.recycler_view) protected RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.my_fragment, container, false);
        ButterKnife.bind(this, view);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), Utils.getItems());
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

}
