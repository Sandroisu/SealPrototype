package ru.alex.plombapp;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.Map;

class SealHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private SingleLineLayout sllSealType;
    private SingleLineLayout sllSealNumber;
    private SingleLineLayout sllSealPlacement;

    public SealHolder(@NonNull View itemView, Context context) {
        super(itemView);
        mContext =context;
        sllSealType = itemView.findViewById(R.id.sealItem_sllType);
        sllSealNumber = itemView.findViewById(R.id.sealItem_sllNumber);
        sllSealPlacement = itemView.findViewById(R.id.sealItem_sllPlacement);
    }

    public void bindItem(Seal seal) {
            sllSealType.setTvTitle(seal.sealType);
            sllSealType.setTvPrevious(seal.previousType);
            sllSealType.setActvAdapter(new SealTypeAdapter(mContext, new LinkedList<Map<String, Object>>()));
            sllSealNumber.setTvTitle(seal.sealNumber);
            sllSealNumber.setTvPrevious(String.valueOf(seal.previousNumber));
            sllSealNumber.setActvHint("Введите номер");
            sllSealPlacement.setTvTitle(seal.sealPlacement);
            sllSealPlacement.setTvPrevious(seal.previousPlacement);
            sllSealPlacement.setActvAdapter(new SealPlacementAdapter(mContext, new LinkedList<Map<String, Object>>()));

    }
}
