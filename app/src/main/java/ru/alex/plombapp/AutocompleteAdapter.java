package ru.alex.plombapp;

import android.content.Context;
import android.widget.Filterable;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutocompleteAdapter extends SimpleAdapter implements Filterable {
    List< Map<String, Object>> mCurrentData;
    /**
     * Constructor
     *
     * @param context  The context where the View associated with this SimpleAdapter is running
     * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                 Maps contain the data for each row, and should include all the entries specified in
     *                 "from"
     * @param from     A list of column names that will be added to the Map associated with each
     *                 item.
     * @param to       The views that should display column in the "from" parameter. These should all be
     *                 TextViews. The first N views in this list are given the values of the first N columns
     */
    public AutocompleteAdapter(Context context, List< Map<String, Object>> data, String[] from, int[] to) {
        super(context, data, android.R.layout.simple_spinner_dropdown_item, from, to);
        mCurrentData = data;

    }

    public void addItem(int position, String value){
        Map<String, Object> m = new HashMap<>();
        m.put(Names.SP_POSITION, position);
        m.put(Names.NAME, value);
    mCurrentData.add(m);
    }

}
