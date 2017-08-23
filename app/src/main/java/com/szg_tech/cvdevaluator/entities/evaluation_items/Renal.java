package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

/**
 * Created by davischan on 8/23/17.
 */

class Renal extends SectionEvaluationItem {

    Renal(Context context) {
        super(context, ConfigurationParams.RENAL, null, false);
        name = "Renal";
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        this.dependsOn = ConfigurationParams.BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.WORSENING_RENAL_FX, "Acute renal failure / worsening renal function", false, new ArrayList<EvaluationItem>() {
                    {

                        add(new NumericalEvaluationItem(context, ConfigurationParams.CRINC, " Increase in SCrx baseline ", "Value", 1, 10, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.CR48H, " Increase in SCr by mg/dl in 48hr ", "Value", 0.1, 112, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.URINE, " Urine volume ml/kg/h", "Value", 0, 200, false, true));


                    }
                }));




                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CKD, "Chronic kidney disease", false, new ArrayList<EvaluationItem>() {
                    {
                        //add(new BooleanEvaluationItem(context, ConfigurationParams.ACUTE_EXACERBATION, "Acute exacerbation", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.COPDEX, " More than 1 COPD exacerbation/year ", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.COPDHOS, " One or more hospital admission/year ", false));
                    }
                }));
            }
        };
    }
}
