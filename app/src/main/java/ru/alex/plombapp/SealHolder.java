package ru.alex.plombapp;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.Map;

class SealHolder extends RecyclerView.ViewHolder {
    private SingleLineLayout sllSealType;
    private SingleLineLayout sllSealNumber;
    private SingleLineLayout sllSealPlacement;
    private IMeterReadingTextWatcher mTextWatcher;

    public SealHolder(@NonNull View itemView, IMeterReadingTextWatcher textWatcher) {
        super(itemView);
        sllSealType = itemView.findViewById(R.id.sealItem_sllType);
        sllSealNumber = itemView.findViewById(R.id.sealItem_sllNumber);
        sllSealPlacement = itemView.findViewById(R.id.sealItem_sllPlacement);
        mTextWatcher = textWatcher;
    }

    public void bindItem(Seal seal) {
        sllSealType.setActvTextWatcher(mTextWatcher, seal.sealId);
        sllSealPlacement.setActvTextWatcher(mTextWatcher, seal.sealId);
        sllSealNumber.setActvTextWatcher(mTextWatcher, seal.sealId);
        sllSealType.setTvTitle(seal.sealType);
        sllSealType.setTvPrevious(seal.previousType);
        sllSealType.setActvAdapter(new SealTypeAdapter((Context) mTextWatcher, new LinkedList<Map<String, Object>>()));
        sllSealNumber.setTvTitle(seal.sealNumber);
        sllSealNumber.setTvPrevious(String.valueOf(seal.previousNumber));
        sllSealNumber.setActvHint("Введите номер");
        sllSealNumber.setInputDouble();
        sllSealPlacement.setTvTitle(seal.sealPlacement);
        sllSealPlacement.setTvPrevious(seal.previousPlacement);
        sllSealPlacement.setActvAdapter(new SealPlacementAdapter((Context) mTextWatcher, new LinkedList<Map<String, Object>>()));

    }
}
