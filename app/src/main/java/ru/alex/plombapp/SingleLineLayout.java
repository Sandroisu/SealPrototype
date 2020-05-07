package ru.alex.plombapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class SingleLineLayout extends ConstraintLayout {
    private Context mContext;
    private TextView tvTitle;
    private TextView tvPrevious;
    private AutoCompleteTextView actvCurrent;
    private ImageView ivCancel;
    private ImageView ivAccept;

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
        tvTitle.setText(labelText);
        ivCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actvCurrent.setSelection(-1);
            }
        });

    }

    public void setTvTitle(String title) {
        tvTitle.setText(title);
    }

    public void setTvPrevious(String previous) {
        tvPrevious.setText(previous);
    }

    public void setActvCurrent(String current) {
        actvCurrent.setText(current);
    }

    public void setIvAcceptVisible(boolean visible) {
        if (visible) {
            ivAccept.setVisibility(VISIBLE);
        } else {
            ivAccept.setVisibility(GONE);
        }
    }
}
