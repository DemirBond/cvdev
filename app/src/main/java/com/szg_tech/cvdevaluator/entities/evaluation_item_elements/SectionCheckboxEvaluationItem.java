package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;

import android.content.Context;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;

import java.util.ArrayList;

public class SectionCheckboxEvaluationItem extends EvaluationItem {
    private ArrayList<EvaluationItem> evaluationItemList;
    private boolean isChecked = false;
    private boolean shouldShowAlert;

    public SectionCheckboxEvaluationItem(String id, String name, ArrayList<EvaluationItem> evaluationItemList) {
        super(id, name, null);
        this.evaluationItemList = evaluationItemList;
    }

    public ArrayList<EvaluationItem> getEvaluationItemList() {
        return evaluationItemList;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isShouldShowAlert() {
        return shouldShowAlert;
    }

    protected void setShouldShowAlert(boolean shouldShowAlert) {
        this.shouldShowAlert = shouldShowAlert;
    }

    public Boolean getValue() {
        return isChecked;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Boolean) {
            setChecked((Boolean) value);
        }
    }
}
