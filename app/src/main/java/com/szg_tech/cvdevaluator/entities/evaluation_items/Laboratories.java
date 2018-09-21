package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalDependantEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class Laboratories extends SectionEvaluationItem {
    Laboratories(Context context) {
        super(LABORATORIES, null);
        name = context.getString(R.string.laboratories);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BoldEvaluationItem(CHEM_BASIC, context.getString(R.string.chem_basic)));
                add(new NumericalEvaluationItem(NA_MEQ_L, context.getString(R.string.na_meq_l), context.getString(R.string.value), 99, 170, true));
                add(new NumericalDependantEvaluationItem(URINE_NA_MEQ_L, context.getString(R.string.urine_na_meq_l), context.getString(R.string.value), 1, 200, true,
                        NA_MEQ_L, 99, 130));
                add(new NumericalDependantEvaluationItem(SERUM_OSMOLALITY, context.getString(R.string.serum_osmolality), context.getString(R.string.value), 200, 400, true,
                        NA_MEQ_L, 99, 130));
                add(new NumericalDependantEvaluationItem(URINE_OSMOLALITY, context.getString(R.string.urine_osmolality), context.getString(R.string.value), 200, 1000, true,
                        NA_MEQ_L, 99, 130));
                add(new NumericalEvaluationItem(K_MEQ_L, context.getString(R.string.k_meq_l), context.getString(R.string.value), 2, 9, false));
                add(new NumericalEvaluationItem(CREATININE_MG_DL, "Creatinine", context.getString(R.string.value), 0.4, 20, false));
                add(new NumericalEvaluationItem(BUN_MG_DL, context.getString(R.string.bun_mg_dl), context.getString(R.string.value), 6, 200, true));
                add(new NumericalEvaluationItem(FASTING_PLASMA_GLUCOSE, "Glucose mg/dl", context.getString(R.string.value), 35, 1000, true));
                add(new NumericalEvaluationItem(HEMOGLOBIN , "Hemoglobin mg/dl", "Value", 3, 25, true));
                add(new NumericalEvaluationItem(GFR_ML_MIN, "GFR", "Value", 5, 120, true) {

                });
                add(new BooleanEvaluationItem(WORSENING_RENAL_FX, context.getString(R.string.worsening_renal_fx)));
                add(new BoldEvaluationItem(LIPID_PROFILE, context.getString(R.string.lipid_profile)));
                add(new BooleanEvaluationItem(ALREADY_ON_STATIN, context.getString(R.string.already_on_statin)));
                add(new BooleanEvaluationItem(STATIN_INTOLERANCE, context.getString(R.string.statin_intolerance)));

                add(new NumericalEvaluationItem(CHOLESTEROL, "Cholesterol", context.getString(R.string.value), 40, 500, true));
                add(new NumericalEvaluationItem(TRG, context.getString(R.string.trg), context.getString(R.string.value), 25, 25000, true));
                add(new NumericalEvaluationItem(LDL_C, context.getString(R.string.ldl_c), context.getString(R.string.value), 0, 500, true));
                add(new NumericalEvaluationItem(HDL_C, context.getString(R.string.hdl_c), context.getString(R.string.value), 1, 200, true));
                add(new NumericalEvaluationItem(APO_B, context.getString(R.string.apo_b), context.getString(R.string.value), 0, 400, true));
                add(new NumericalEvaluationItem(LDL_P, context.getString(R.string.ldl_p), context.getString(R.string.value), 100, 5000, true));
                add(new NumericalEvaluationItem(LPA_MG_DL, context.getString(R.string.lpa_mg_dl), context.getString(R.string.value), 1, 500, true));
                add(new NumericalEvaluationItem(ASCVD_RISK, context.getString(R.string.ascvd_risk), context.getString(R.string.value), 0.1, 30, false));

                add(new BoldEvaluationItem(OTHERS, context.getString(R.string.others)));
                add(new NumericalEvaluationItem(HBA1C, context.getString(R.string.hba1c), context.getString(R.string.value), 4.9, 19.99, false));
                add(new NumericalEvaluationItem(CRP_MG_L, context.getString(R.string.crp_mg_l), context.getString(R.string.value), 0.1, 30, false));
                add(new NumericalEvaluationItem(NT_PROBNP_PG_ML, context.getString(R.string.nt_probnp_pg_ml), context.getString(R.string.value), 50, 100000, true));
                add(new NumericalEvaluationItem(BNP_PG_ML, context.getString(R.string.bnp_pg_ml), context.getString(R.string.value), 10, 100000, true));
                add(new NumericalEvaluationItem(ALBUMINURIA_MG_GM_OR_MG_24HR, context.getString(R.string.albuminuria_mg_gm_or_mg_24hr), context.getString(R.string.value), 1, 10000, true));
                add(new SectionCheckboxEvaluationItem(URINE, "Abnormal urine sediment", new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(RBC, "Isolated RBC"));
                        add(new BooleanEvaluationItem(RBCCAST, "RBC cast"));
                        add(new BooleanEvaluationItem(WBCCAST, "WBC cast"));
                        add(new BooleanEvaluationItem(GRANULAR, "Granular cast"));
                        add(new BooleanEvaluationItem(OVAL, "Oval cell bodies"));

                    }
                }));
            }
        };
    }
}
