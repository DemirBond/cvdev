package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class NonCardiacSurgicalRisk extends SectionEvaluationItem {
    NonCardiacSurgicalRisk(Context context) {
        super(NONCARDIAC_SURGICAL_RISK, null);
        name = context.getString(R.string.noncardiac_surgical_risk);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BooleanEvaluationItem(EMERGENCY_SURGERY, context.getString(R.string.emergency_surgery)));
                add(new BooleanEvaluationItem(INTERMEDIATE_RISK, context.getString(R.string.intermediate_risk)));
                add(new BooleanEvaluationItem(HIGH_RISK, context.getString(R.string.high_risk)));
                add(new BooleanEvaluationItem(LOW_RISK_SURGERY_CATARACT_PLASTIC, context.getString(R.string.low_risk_surgery_cataract_plastic)));
                add(new BooleanEvaluationItem(UNABLE_TO_EXERCISE_PHYSICALLY_INACTIVE, context.getString(R.string.unable_to_exercise_physically_inactive)));
                add(new NumericalEvaluationItem(METS, context.getString(R.string.mets), context.getString(R.string.value), 0, 21, true));
                add(new NumericalEvaluationItem(DUKE_ACTIVITY_SCORE_INDEX, "Duke Activity Status Index", context.getString(R.string.value), 0, 99, true));
            }
        };
    }
}
