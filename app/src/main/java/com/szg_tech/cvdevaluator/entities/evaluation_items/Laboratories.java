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
        super(context, LABORATORIES, null);
        name = getString(R.string.laboratories);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BoldEvaluationItem(CHEM_BASIC, getString(R.string.chem_basic)));
                add(new NumericalEvaluationItem(NA_MEQ_L, getString(R.string.na_meq_l), getString(R.string.value), 99, 170, true));
                add(new NumericalDependantEvaluationItem(URINE_NA_MEQ_L, getString(R.string.urine_na_meq_l), getString(R.string.value), 1, 200, true,
                        NA_MEQ_L, 99, 130));
                add(new NumericalDependantEvaluationItem(SERUM_OSMOLALITY, getString(R.string.serum_osmolality), getString(R.string.value), 200, 400, true,
                        NA_MEQ_L, 99, 130));
                add(new NumericalDependantEvaluationItem(URINE_OSMOLALITY, getString(R.string.urine_osmolality), getString(R.string.value), 200, 1000, true,
                        NA_MEQ_L, 99, 130));
                add(new NumericalEvaluationItem(K_MEQ_L, getString(R.string.k_meq_l), getString(R.string.value), 2, 9, false));
                add(new NumericalEvaluationItem(CREATININE_MG_DL, "Creatinine", getString(R.string.value), 0.4, 20, false));
                add(new NumericalEvaluationItem(BUN_MG_DL, getString(R.string.bun_mg_dl), getString(R.string.value), 6, 200, true));
                add(new NumericalEvaluationItem(FASTING_PLASMA_GLUCOSE, "Glucose mg/dl", getString(R.string.value), 35, 1000, true));
                add(new NumericalEvaluationItem(HEMOGLOBIN , "Hemoglobin mg/dl", "Value", 3, 25, true));
                add(new NumericalEvaluationItem(GFR_ML_MIN, "GFR", "Value", 5, 120, true) {

                });
                add(new BooleanEvaluationItem(WORSENING_RENAL_FX, getString(R.string.worsening_renal_fx)));
                add(new BoldEvaluationItem(LIPID_PROFILE, getString(R.string.lipid_profile)));
                add(new BooleanEvaluationItem(ALREADY_ON_STATIN, getString(R.string.already_on_statin)));
                add(new BooleanEvaluationItem(STATIN_INTOLERANCE, getString(R.string.statin_intolerance)));

                add(new NumericalEvaluationItem(CHOLESTEROL, "Cholesterol", getString(R.string.value), 40, 500, true));
                add(new NumericalEvaluationItem(TRG, getString(R.string.trg), getString(R.string.value), 25, 25000, true));
                add(new NumericalEvaluationItem(LDL_C, getString(R.string.ldl_c), getString(R.string.value), 0, 500, true));
                add(new NumericalEvaluationItem(HDL_C, getString(R.string.hdl_c), getString(R.string.value), 1, 200, true));
                add(new NumericalEvaluationItem(APO_B, getString(R.string.apo_b), getString(R.string.value), 0, 400, true));
                add(new NumericalEvaluationItem(LDL_P, getString(R.string.ldl_p), getString(R.string.value), 100, 5000, true));
                add(new NumericalEvaluationItem(LPA_MG_DL, getString(R.string.lpa_mg_dl), getString(R.string.value), 1, 500, true));
                add(new NumericalEvaluationItem(ASCVD_RISK, getString(R.string.ascvd_risk), getString(R.string.value), 0.1, 30, false));

                add(new BoldEvaluationItem(OTHERS, getString(R.string.others)));
                add(new NumericalEvaluationItem(HBA1C, getString(R.string.hba1c), getString(R.string.value), 4.9, 19.99, false));
                add(new NumericalEvaluationItem(CRP_MG_L, getString(R.string.crp_mg_l), getString(R.string.value), 0.1, 30, false));
                add(new NumericalEvaluationItem(NT_PROBNP_PG_ML, getString(R.string.nt_probnp_pg_ml), getString(R.string.value), 50, 100000, true));
                add(new NumericalEvaluationItem(BNP_PG_ML, getString(R.string.bnp_pg_ml), getString(R.string.value), 10, 100000, true));
                add(new NumericalEvaluationItem(ALBUMINURIA_MG_GM_OR_MG_24HR, getString(R.string.albuminuria_mg_gm_or_mg_24hr), getString(R.string.value), 1, 10000, true));
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
