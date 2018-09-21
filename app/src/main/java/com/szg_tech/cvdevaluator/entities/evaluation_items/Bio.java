package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.StringEvaluationItem;

import java.util.ArrayList;

class Bio extends SectionEvaluationItem {

    Bio(Context context) {
        super(BIO, null);
        name = context.getString(R.string.bio);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                StringEvaluationItem nameItem = new StringEvaluationItem(NAME, context.getString(R.string.name), context.getString(R.string.name_hint), null);
                NumericalEvaluationItem ageItem = new NumericalEvaluationItem(AGE, context.getString(R.string.age), context.getString(R.string.age_hint), 20, 100, true);
                nameItem.setMandatory(true);
                ageItem.setMandatory(true);
                add(nameItem);
                add(ageItem);
                add(new SectionPlaceholderEvaluationItem(GENDER, context.getString(R.string.gender), context.getString(R.string.male),
                        new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(MALE, context.getString(R.string.male), GENDER, true));
                                add(new RadioButtonGroupEvaluationItem(FEMALE, context.getString(R.string.female), GENDER, false));
                            }
                        }));
                add(new NumericalEvaluationItem(BMI, "BMI", "Enter BMI value", 10, 50, true));
                add(new NumericalEvaluationItem(WEIGHT, "Weight kg", "", 40, 400, true));
                add(new NumericalEvaluationItem(HEART_RATE, context.getString(R.string.heart_rate), context.getString(R.string.heart_rate_hint), 30, 300, true));
                NumericalEvaluationItem sbpItem = new NumericalEvaluationItem(SBP, context.getString(R.string.sbp), context.getString(R.string.sbp_hint), 60, 300, true);
                NumericalEvaluationItem dbpItem = new NumericalEvaluationItem(DBP, context.getString(R.string.dbp), context.getString(R.string.dbp_hint), 30, 160, true);
                sbpItem.setMandatory(true);
                dbpItem.setMandatory(true);
                add(sbpItem);
                add(dbpItem);
                add(new NumericalEvaluationItem(ORTHOSTATIC_SBP, "Orthostatic SBP", "Value", 0, 240, true));
                add(new BooleanEvaluationItem(ORTHOSTATIC_SYMPTOMPS, context.getString(R.string.orthostatic_symptomps)));
                add(new NumericalEvaluationItem(WAIST_CIRC, context.getString(R.string.waist_circ), context.getString(R.string.value), 20, 60, false));
                add(new BooleanEvaluationItem(AA, context.getString(R.string.aa)));
                add(new BooleanEvaluationItem(PREGNANCY, context.getString(R.string.pregnancy)));
                add(new NumericalEvaluationItem(RASAT, "RA O2 sat", "Value", 50, 100, true));
            }
        };
    }
}
