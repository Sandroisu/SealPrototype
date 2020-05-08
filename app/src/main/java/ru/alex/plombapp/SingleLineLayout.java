package ru.alex.plombapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;

public class SingleLineLayout extends ConstraintLayout {
    private Context mContext;
    private TextView tvTitle;
    private TextView tvPrevious;
    private AutoCompleteTextView actvCurrent;
    private ImageView ivCancel;
    private ImageView ivAccept;
    private ImageView ivDropDown;

    public SingleLineLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.SingleLineLayout, 0, 0);
        String labelText = a.getString(R.styleable.SingleLineLayout_topLabelText);
        a.recycle();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.single_line_layout, this, true);
        }
        tvTitle = findViewById(R.id.singleLine_tvTitle);
        tvPrevious = findViewById(R.id.singleLine_tvPrevious);
        actvCurrent = findViewById(R.id.singleLine_actvCurrent);
        ivCancel = findViewById(R.id.singleLine_ivCancel);
        ivAccept = findViewById(R.id.singleLine_ivAccept);
        ivDropDown = findViewById(R.id.singleLine_ivDropDown);
        tvTitle.setText(labelText);
        ivDropDown.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actvCurrent.showDropDown();
            }
        });
        actvCurrent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ivAccept.setVisibility(VISIBLE);
                ivCancel.setVisibility(VISIBLE);
                HashMap<String, Object> map = (HashMap<String, Object>)parent.getItemAtPosition(position);
                actvCurrent.setText(String.valueOf( map.get(Names.NAME)));
            }
        });
        ivCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actvCurrent.setText(null);
                ivAccept.setVisibility(GONE);
                ivCancel.setVisibility(GONE);
            }
        });
    }

    public void setTvTitle(String title) {
        tvTitle.setText(title);
    }

    public void setTvPrevious(String previous) {
        tvPrevious.setText(previous);
    }

    public void setActvAdapter(AutocompleteAdapter adapter) {
        actvCurrent.setAdapter(adapter);
    }

    public void setActvHint(String current) {
        actvCurrent.setHint(current);
    }

    public void setActvTextWatcher(IMeterReadingTextWatcher textWatcher, String sealId){
        actvCurrent.addTextChangedListener(new MeterReadingTextWatcher(textWatcher, sealId, this));
    }

    public void setClearAcceptVisibility(boolean visibility){
        if (visibility){
            ivAccept.setVisibility(VISIBLE);
            ivCancel.setVisibility(VISIBLE);
        }else {
            ivAccept.setVisibility(GONE);
            ivCancel.setVisibility(GONE);
        }
    }

    public void setInputDouble(){
        actvCurrent.setInputType(InputType.TYPE_CLASS_NUMBER);
        setClearAcceptVisibility(false);
    }

}
