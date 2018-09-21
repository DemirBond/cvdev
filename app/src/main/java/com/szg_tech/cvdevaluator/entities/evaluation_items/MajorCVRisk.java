package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class MajorCVRisk extends SectionEvaluationItem {
    MajorCVRisk(Context context) {
        super(MAJOR_CV_RISK, null);
        name = context.getString(R.string.cv_risk);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(DIABETES, context.getString(R.string.diabetes), new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionCheckboxEvaluationItem(TYPE_2_DM, context.getString(R.string.type_2_dm), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(DMNP, "Diabetic Nephropathy"));
                                add(new BooleanEvaluationItem(DMCKD, "Diabetic CKD"));
                                add(new BooleanEvaluationItem(DMOTHER,"Other kidney complications"));
                                add(new BooleanEvaluationItem(DMMONO, "Diabetic mononeuropathy"));
                                add(new BooleanEvaluationItem(DMPOLY, "Diabetic polyneuropathy"));
                                add(new BooleanEvaluationItem(DMAUTONOM, "Diabetic autonom neuropathy"));
                                add(new BooleanEvaluationItem(DMANGIO, "Peripheral angiopathy"));
                                add(new BooleanEvaluationItem(DMOTHERCIRC, "Other circulatory complications"));
                                add(new BooleanEvaluationItem(DMGANGRENE, "Angiopathy with gangrene"));
                                add(new BooleanEvaluationItem(DMARTHRO, "Diabetic arthropathy"));
                                add(new BooleanEvaluationItem(DMSKIN, "Diabetic skin complications"));
                                add(new BooleanEvaluationItem(DMORAL, "Diabetic oral complications"));
                                add(new BooleanEvaluationItem(DMHYPO, "Hypoglycemia"));
                                add(new BooleanEvaluationItem(DMHYPOCOMA, "Hypoglycemia with coma"));
                                add(new BooleanEvaluationItem(DMHYPER, "Hyperglycemia"));
                                add(new BooleanEvaluationItem(DMOTHERCOMP, "Other specified complications"));
                                add(new BooleanEvaluationItem(DMUNSPEC, "Unspecified complications"));

                                add(new BooleanEvaluationItem(DMWITHOUT, " Without complications"));
                            }
                        }));


                        add(new SectionCheckboxEvaluationItem(TYPE_1_DM, context.getString(R.string.type_1_dm), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(DMNP, "Diabetic Nephropathy"));
                                add(new BooleanEvaluationItem(DMCKD, "Diabetic CKD"));
                                add(new BooleanEvaluationItem(DMCKD,"Other kidney complications"));
                                add(new BooleanEvaluationItem(DMMONO, "Diabetic mononeuropathy"));
                                add(new BooleanEvaluationItem(DMPOLY, "Diabetic polyneuropathy"));
                                add(new BooleanEvaluationItem(DMAUTONOM, "Diabetic autonom neuropathy"));
                                add(new BooleanEvaluationItem(DMANGIO, "Peripheral angiopathy"));
                                add(new BooleanEvaluationItem(DMOTHERCIRC, "Other circulatory complications"));
                                add(new BooleanEvaluationItem(DMGANGRENE, "Angiopathy with gangrene"));
                                add(new BooleanEvaluationItem(DMARTHRO, "Diabetic arthropathy"));
                                add(new BooleanEvaluationItem(DMSKIN, "Diabetic skin complications"));
                                add(new BooleanEvaluationItem(DMORAL, "Diabetic oral complications"));
                                add(new BooleanEvaluationItem(DMHYPO, "Hypoglycemia"));
                                add(new BooleanEvaluationItem(DMHYPOCOMA, "Hypoglycemia with coma"));
                                add(new BooleanEvaluationItem(DMHYPER, "Hyperglycemia"));
                                add(new BooleanEvaluationItem(DMOTHERCOMP, "Other specified complications"));
                                add(new BooleanEvaluationItem(DMUNSPEC, "Unspecified complications"));

                                add(new BooleanEvaluationItem(DMWITHOUT, " Without complications"));

                            }
                        }));
                        add(new BooleanEvaluationItem(GESTATIONAL_DM, context.getString(R.string.gestational_dm)));
                        add(new BooleanEvaluationItem(RETINOPATHY, context.getString(R.string.retinopathy)));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(SYSTEMIC_ARTERIAL_HYPERTENSION, context.getString(R.string.systemic_arterial_hypertension), new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(AMB_SBP, context.getString(R.string.amb_sbp), context.getString(R.string.value), 80, 190, true));
                        add(new NumericalEvaluationItem(AMB_DBP, context.getString(R.string.amb_dbp), context.getString(R.string.value), 30, 150, true));
                        add(new BoldEvaluationItem(CHECK_LVH_ON_EKG, context.getString(R.string.check_lvh_on_ekg)) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(SBP_TREATED, context.getString(R.string.sbp_treated)));
                        add(new BooleanEvaluationItem(AFRICAN_AMERICAN, context.getString(R.string.african_american)));
                        add(new BoldEvaluationItem(SECONDARY_HYPERTENSION, "Secondary hypertension") {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(PRIMARY_HYPERALDESTERONISM, context.getString(R.string.primary_hyperaldesteronism)));
                        add(new BooleanEvaluationItem(RENOVASCULAR_ATHEROSCLEROTIC, context.getString(R.string.renovascular_atherosclerotic)));
                        add(new BooleanEvaluationItem(PHEOCROMOCYTOMA, context.getString(R.string.pheocromocytoma)));
                        add(new BooleanEvaluationItem(OSA, context.getString(R.string.osa)));
                        add(new BoldEvaluationItem(ACUTELY_SYMPTOMATIC, context.getString(R.string.acutely_symptomatic)) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(HEADACHED_BLURRED_VISION_OR_AMS, context.getString(R.string.headached_blurred_vision_or_ams)));
                        add(new BooleanEvaluationItem(EPISTAXIS, context.getString(R.string.epistaxis)));
                        add(new BooleanEvaluationItem(CHEST_BACK_PAIN_DYSPNEA, context.getString(R.string.chest_back_pain_dyspnea)));
                    }
                }));
                add(new BooleanEvaluationItem(TOBACCO_USE, context.getString(R.string.tobacco_use)));
                add(new BooleanEvaluationItem(FAMILY_HISTORY, context.getString(R.string.family_history)));

            }
        };
    }
}
