package com.szg_tech.cvdevaluator.core.views.cell;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.views.CustomTextView;

public class BoldTextCell extends CellWithIndent implements CellItem {
    private CustomTextView textView;
    private View rootView;

    public BoldTextCell(Context context) {
        super(context);
        inflate(context);
    }

    public BoldTextCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public BoldTextCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public BoldTextCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context);
    }


    private void inflate(Context context) {
        inflate(context, R.layout.bold_text_cell, this);
        initView();
    }

    public void initView() {
        super.initView();
        rootView = findViewById(R.id.root_view);
        textView = findViewById(R.id.text);
        setUpView();
    }

    private void setUpView() {

    }

    @Override
    public void setHintText(String text) {

    }

    @Override
    public void setLabelText(String text) {
        textView.setText(text);
    }


    public void setBackgroundHighlighted(boolean isBackgroundHighlighted) {
        if (isBackgroundHighlighted) {
            rootView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.bold_text_background));
        } else {
            rootView.setBackgroundColor(Color.WHITE);
        }
    }
}