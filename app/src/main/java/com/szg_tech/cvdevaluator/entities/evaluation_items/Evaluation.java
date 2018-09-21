package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

public class Evaluation extends SectionEvaluationItem {

    public Evaluation(Context context) {
        super(ConfigurationParams.EVALUATION, null);
        name = context.getString(R.string.evaluation);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new Bio(context));
                add(new Symptoms(context));
                add(new ReviewOfSystems(context));
                add(new PhysicalExam(context));
                add(new CurrentCVProfile(context));
                add(new Pulmonary(context));
                add(new Renal(context));
                add(new MajorCVRisk(context));
                add(new NonCardiacSurgicalRisk(context));
                add(new Laboratories(context));
                add(new Diagnostics(context));
                add(new Therapies(context));
            }
        };
    }
}
