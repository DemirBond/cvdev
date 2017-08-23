package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.StringEvaluationItem;

import java.util.ArrayList;

/**
 * Created by davischan on 8/22/17.
 */


class Pulmonary extends SectionEvaluationItem {

    Pulmonary(Context context) {
        super(context, ConfigurationParams.PULMONARY, null, false);
        name = "Pulmonary";
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {


                add(new NumericalEvaluationItem(context, ConfigurationParams.FEV1_LT, "FEV1 lt/min", "Value", 0.5, 8, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.FEV1_PERCENT, " % FEV1", "Value", 25, 120, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.FVC, "% FVC", "Value", 0, 120, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.DLCO, "% DLCO", "Value", 10, 100, false, true));
                add(new NumericalEvaluationItem(context, ConfigurationParams.PO2, "PO2 mmhg", "Value", 10, 100, false, true));
                add(new BooleanEvaluationItem(context, ConfigurationParams.NONE, "NSevere chronic hypercapnia", false));



                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ASTHMA, "Asthma / Reactive airway disease", false, new ArrayList<EvaluationItem>() {
                    {

                        add(new NumericalEvaluationItem(context, ConfigurationParams.SYMPTOMS_WEEK, " Symptoms / week ", "Value", 0, 112, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.NOCTURNAL, " Nocturnal awakening / week ", "Value", 0, 112, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.SABA_USE, " SABA use / week ", "Value", 0, 112, false, true));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.INTERFERENCE, "Interference with activity", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.NONE, "None", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MINOR, "Minor", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.SOME, "Some", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.SIGNIFICANT, "Significant", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.OVAL, "Oval cell bodies", false));

                            }
                        }));

                    }
                }));




                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CKD, "Acute exacerbation", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ACUTE_EXACERBATION, "Acute exacerbation", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.COPDEX, " More than 1 COPD exacerbation/year ", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.COPDHOS, " One or more hospital admission/year ", false));
                    }
                }));

                add(new BooleanEvaluationItem(context, ConfigurationParams.ILD, "Interstitial lung disease", false));

            }
        };
    }
}
