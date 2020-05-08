package ru.alex.plombapp;

import android.text.Editable;
import android.util.Log;

public class MeterReadingTextWatcher implements IMeterReadingTextWatcher {
    private IMeterReadingTextWatcher mTextWatcher;
    private String mSealId;
    private Object mPrevValue;
    private SingleLineLayout mSingleLineLayout;

    public MeterReadingTextWatcher(IMeterReadingTextWatcher textWatcher, String sealId, SingleLineLayout sllLayout) {
        mTextWatcher = textWatcher;
        mSealId = sealId;
        mSingleLineLayout = sllLayout;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        try {
            mPrevValue = Double.parseDouble(s.toString());
        } catch (NumberFormatException ignored) {
            mPrevValue = s.toString();
        }
        mTextWatcher.beforeTextChanged(s, start, count, after);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        mTextWatcher.onTextChanged(s, start, before, count);
    }

    @Override
    public void afterTextChanged(Editable s) {
        Object value = null;
        try {
            value = Double.parseDouble(s.toString());
        }catch (NumberFormatException ignored) {
            value = s.toString();
        }
        afterMeterReadingTextChanged(mSealId, mPrevValue, value, mSingleLineLayout);

        mTextWatcher.afterTextChanged(s);
    }

    @Override
    public void afterMeterReadingTextChanged(String meterId, Object prevValue, Object value, SingleLineLayout sllLayout) {
        mTextWatcher.afterMeterReadingTextChanged(meterId, prevValue, value, sllLayout);
    }
}
