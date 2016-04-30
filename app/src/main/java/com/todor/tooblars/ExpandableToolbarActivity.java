package com.todor.tooblars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import com.todor.tooblars.adapter.RecyclerViewAdapter;
import com.todor.tooblars.model.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableToolbarActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view) protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        List<Item> items = new ArrayList<>();

        for(int i = 0; i < 50; i++) {
            items.add(new Item(i, "Item"));
        }

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, items);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
