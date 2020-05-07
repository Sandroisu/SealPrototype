package ru.alex.plombapp;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ItemLayout extends LinearLayout {

    private TextView mTextView;
    private ImageView mImageView;
    private RecyclerView mRecyclerView;
    private Context mContext;

    public ItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attributeSet,
                R.styleable.ItemLayout, 0, 0);
        String labelText = a.getString(R.styleable.ItemLayout_labelText);
        int listSize = a.getInt(R.styleable.ItemLayout_listSize, 1);
        a.recycle();
        setOrientation(LinearLayout.VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.expandable_layout, this, true);
        }

        mTextView = findViewById(R.id.text_label);
        mImageView = findViewById(R.id.image_arrow);
        mRecyclerView = findViewById(R.id.recycler_view_container);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(new ListAdapter(listSize));
        mTextView.setText(labelText);

        mImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRecyclerView.isShown()) {
                    mRecyclerView.setVisibility(GONE);
                } else mRecyclerView.setVisibility(VISIBLE);
            }
        });
    }

    public void setTextLabel(String value) {
        mTextView.setText(value);
    }


    public void setListAdapter(List<ItemData> data) {
        mRecyclerView.setAdapter(new ListAdapter(data));
    }

    public void setCustomRecLayManager(LinearLayoutManager layManager) {
        mRecyclerView.setLayoutManager(layManager);
    }

    private static class ListHolder extends RecyclerView.ViewHolder {

        private TextView tvPlombType;
        public ListHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindItems(ItemData data) {
            tvPlombType.setText(data.plombType);
        }

        public void disableDocuments() {
        }

    }

    private class ListAdapter extends RecyclerView.Adapter<ListHolder> {
        private List<ItemData> mItemData;
        private int listSize;

        public ListAdapter(List<ItemData> data) {
            mItemData = data;
        }

        public ListAdapter(int size) {
            listSize = size;
        }

        @NonNull
        @Override
        public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.rv_item, parent, false);
            return new ListHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ListHolder holder, int position) {

            holder.bindItems(mItemData.get(position));

            if (false) {
                holder.disableDocuments();
            }
        }

        @Override
        public int getItemCount() {
            if (mItemData == null) {
                return listSize;
            } else {
                return mItemData.size();
            }
        }
    }
}

