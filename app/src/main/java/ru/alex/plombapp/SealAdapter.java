package ru.alex.plombapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class SealAdapter extends RecyclerView.Adapter<SealHolder> {
    private Context mContext;
    private List<Seal> mSeals;

    public SealAdapter(Context context, List<Seal> seals){
        mContext = context;
        mSeals = seals;
    }
    @NonNull
    @Override
    public SealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.rv_item, parent, false);
        return new SealHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SealHolder holder, int position) {
            holder.bindItem(mSeals.get(position));
    }

    @Override
    public int getItemCount() {
        return mSeals.size();
    }
}
