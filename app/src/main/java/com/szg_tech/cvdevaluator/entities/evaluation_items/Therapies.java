package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;

public class Therapies extends SectionEvaluationItem {

    Therapies(Context context) {
        super(CURRENT_THERAPIES, context.getString(R.string.current_therapies));
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        dependsOn = BIO;

    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new POMeds(context));
                add(new InHospitalTherapies(context));
            }
        };
    }
}
