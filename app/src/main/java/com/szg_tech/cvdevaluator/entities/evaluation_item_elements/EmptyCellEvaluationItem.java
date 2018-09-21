package com.szg_tech.cvdevaluator.entities.evaluation_item_elements;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;

public class EmptyCellEvaluationItem extends EvaluationItem {
    public EmptyCellEvaluationItem() {
        super(null, null, null);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public void setValue(Object value) {

    }
}
