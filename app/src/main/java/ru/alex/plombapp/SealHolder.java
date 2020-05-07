package ru.alex.plombapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class SealHolder extends RecyclerView.ViewHolder {
    private SingleLineLayout sllSealType;
    private SingleLineLayout sllSealNumber;
    private SingleLineLayout sllSealPlacement;

    public SealHolder(@NonNull View itemView) {
        super(itemView);
        sllSealType = itemView.findViewById(R.id.sealItem_sllType);
        sllSealNumber = itemView.findViewById(R.id.sealItem_sllNumber);
        sllSealPlacement = itemView.findViewById(R.id.sealItem_sllPlacement);
    }

    public void bindItem(Seal seal) {
            sllSealType.setTvTitle(seal.sealType);
            sllSealType.setTvPrevious(seal.previousType);
            sllSealNumber.setTvTitle(seal.sealNumber);
            sllSealNumber.setTvPrevious(String.valueOf(seal.previousNumber));
            sllSealPlacement.setTvTitle(seal.sealPlacement);
            sllSealPlacement.setTvPrevious(seal.previousPlacement);
    }
}
