package com.todor.tooblars.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.todor.tooblars.R;
import com.todor.tooblars.model.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderProductItem> {

    private Context mContext;
    private List<Item> mItems;

    public RecyclerViewAdapter(Context mContext, List<Item> items) {
        this.mContext = mContext;
        this.mItems = items;
    }

    @Override
    public ViewHolderProductItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderProductItem(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderProductItem holder, int position) {
        Item item = mItems.get(position);
        holder.name.setText(item.name);
        holder.id.setText(item.id);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ViewHolderProductItem extends RecyclerView.ViewHolder {

        @BindView(R.id.name) TextView name;
        @BindView(R.id.id) TextView id;

        public ViewHolderProductItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
