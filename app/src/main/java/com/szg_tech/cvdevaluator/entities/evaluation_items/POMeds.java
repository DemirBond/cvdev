package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class POMeds extends SectionEvaluationItem {
    POMeds(Context context) {
        super(PO_MEDS, null);
        name = context.getString(R.string.po_meds);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(B_BLOCKER, context.getString(R.string.b_blocker), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CARVEDILOL_3125BID, context.getString(R.string.carvedilol_3125bid)));
                        add(new BooleanEvaluationItem(CARVEDILOL_625BID, "chkCarvedilol625"));
                        add(new BooleanEvaluationItem(CARVEDILOL_125BID, context.getString(R.string.carvedilol_125bid)));
                        add(new BooleanEvaluationItem(CARVEDILOL_25BID, context.getString(R.string.carvedilol_25bid)));
                        add(new BooleanEvaluationItem(METOPROLOLER_25_QD, context.getString(R.string.metoprololer_25_qd)));
                        add(new BooleanEvaluationItem(METOPROLOLER_50_QD, context.getString(R.string.metoprololer_50_qd)));
                        add(new BooleanEvaluationItem(METOPROLOLER_100_QD, context.getString(R.string.metoprololer_100_qd)));
                        add(new BooleanEvaluationItem(METOPROLOLER_150_QD, context.getString(R.string.metoprololer_150_qd)));
                        add(new BooleanEvaluationItem(METOPROLOLER_200_QD, context.getString(R.string.metoprololer_200_qd)));
                    }
                }));

                add(new SectionCheckboxEvaluationItem(ACEL_ARB, "Ace I/ ARB", new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(LISINOPRIL_5QD, "Lisinopril 5 qd"));
                        add(new BooleanEvaluationItem(LISINOPRIL_10QD, "Lisinopril 10-20 qd"));
                        add(new BooleanEvaluationItem(LISINOPRIL_20QD, "Lisinopril 30-40 qd"));
                        add(new BooleanEvaluationItem(LOSARTAN_25QD,  "Losartan 25 qd"));
                        add(new BooleanEvaluationItem(LOSARTAN_50QD,  "Losartan 50 qd"));
                        add(new BooleanEvaluationItem(LOSARTAN_100QD, "Losartan 100 qd"));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(PO_DIURETIC, context.getString(R.string.po_diuretic), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(FUROSEMIDE_40, context.getString(R.string.furosemide_40)));
                        add(new BooleanEvaluationItem(FUROSEMIDE_80, context.getString(R.string.furosemide_80)));
                        add(new BooleanEvaluationItem(FUROSEMIDE_80_PLUS, context.getString(R.string.furosemide_80_plus)));
                        add(new BooleanEvaluationItem(BURNEX_1, context.getString(R.string.burnex_1)));
                        add(new BooleanEvaluationItem(BURNEX_2, context.getString(R.string.burnex_2)));
                        add(new BooleanEvaluationItem(BURNEX_2_PLUS, context.getString(R.string.burnex_2_plus)));
                        add(new BooleanEvaluationItem(TORSEMIDE_20, context.getString(R.string.torsemide_20)));
                        add(new BooleanEvaluationItem(TORSEMIDE_40, context.getString(R.string.torsemide_40)));
                        add(new BooleanEvaluationItem(TORSEMIDE_50_PLUS, context.getString(R.string.torsemide_50_plus)));
                        add(new BooleanEvaluationItem(HCTZ, context.getString(R.string.hctz)));
                        add(new BooleanEvaluationItem(INDAPAMIDE, context.getString(R.string.indapamide)));
                        add(new BooleanEvaluationItem(CHLORTHALIDONE_METOLAZONE, context.getString(R.string.chlorthalidone_metolazone)));
                    }
                }));
                add(new BooleanEvaluationItem(CCB_OTHER_VASOLIDATORS, context.getString(R.string.ccb_other_vasolidators)));
                add(new BooleanEvaluationItem(CURRENT_VKA_THERAPY, context.getString(R.string.current_vka_therapy)));
                add(new BooleanEvaluationItem(DIRECT_THROMBIN_INHIBITORS, context.getString(R.string.direct_thrombin_inhibitors)));
                add(new BooleanEvaluationItem(FACTOR_XA_INHIBITORS, context.getString(R.string.factor_xa_inhibitors)));
            }
        };
    }
}
