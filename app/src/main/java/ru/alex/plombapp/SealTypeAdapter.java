package ru.alex.plombapp;

import android.content.Context;

import java.util.List;
import java.util.Map;

public class SealTypeAdapter extends AutocompleteAdapter {

    private static final String[] from = {Names.NAME};
    private static final int[] to = {android.R.id.text1};

    /**
     * Constructor
     *
     * @param context The context where the View associated with this SimpleAdapter is running
     * @param data    A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                Maps contain the data for each row, and should include all the entries specified in
     *                "from"
     */
    public SealTypeAdapter(Context context, List<Map<String, Object>> data) {
        super(context, data, from, to);
        String[] sealType = context.getResources().getStringArray(R.array.seal_type);
        for (int i = 0; i < sealType.length; i++) {
            addItem(i, sealType[i]);
        }
    }
}
