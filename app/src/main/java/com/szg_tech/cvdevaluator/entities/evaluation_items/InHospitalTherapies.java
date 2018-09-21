package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class InHospitalTherapies extends SectionEvaluationItem {
    InHospitalTherapies(Context context) {
        super(IN_HOSPITAL_THERAPIES, null);
        name = context.getString(R.string.in_hospital_therapies);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(FOUR_ANTIARRYTHMIC, context.getString(R.string.four_antiarrythmic), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CONTINOUS_IVAA, context.getString(R.string.Continuous)));
                        add(new BooleanEvaluationItem(BOLUS_IVAA, context.getString(R.string.bolus)));
                        add(new BooleanEvaluationItem(TITRATION_IVAA, context.getString(R.string.titration)));
                        add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVAA, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, true));
                        add(new BooleanEvaluationItem(TRANSITION_TO_PO_ANTIARRYTHMIC, context.getString(R.string.transition_to_po_antiarrythmic)));
                    }
                }));
                add(new BooleanEvaluationItem(URGENT_CV, context.getString(R.string.urgent_cv)));
                add(new BooleanEvaluationItem(DEFIBRILLATION_ACLS, context.getString(R.string.defibrillation_acls)));
                add(new SectionCheckboxEvaluationItem(FOUR_ANTIHYPERTENSIVE, context.getString(R.string.four_antihypertensive), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CONTINOUS_IVHT, context.getString(R.string.Continuous)));
                        add(new BooleanEvaluationItem(BOLUS_IVHT, context.getString(R.string.bolus)));
                        add(new BooleanEvaluationItem(TITRATION_IVHT, context.getString(R.string.titration)));
                        add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVHT, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, true));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(FOUR_VASOACTIVE, context.getString(R.string.four_vasoactive), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CONTINOUS_IVVA, context.getString(R.string.Continuous)));
                        add(new BooleanEvaluationItem(BOLUS_IVVA, context.getString(R.string.bolus)));
                        add(new BooleanEvaluationItem(TITRATION_IVVA, context.getString(R.string.titration)));
                        add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVVA, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, true));
                        add(new BooleanEvaluationItem(FOUR_NPS, context.getString(R.string.four_nps)));
                        add(new BooleanEvaluationItem(FOUR_NTG, context.getString(R.string.four_ntg)));
                        add(new BooleanEvaluationItem(FOUR_MILRINONE, context.getString(R.string.four_milrinone)));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(FOUR_DIURETIC, context.getString(R.string.four_diuretic), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CONTINOUS_IVDI, context.getString(R.string.Continuous)));
                        add(new BooleanEvaluationItem(INTERMITTENT, context.getString(R.string.intermittent)));
                        add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVDI, context.getString(R.string.monitoring_frequency_q_hr), context.getString(R.string.value), 1, 12, true));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(MECHANICAL_VENTIALLATION_OR_NIPPV, context.getString(R.string.mechanical_ventiallation_or_nippv), new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(RESPIRATORY_INTERVENTIONS_Q_HR, context.getString(R.string.respiratory_interventions_q_hr), context.getString(R.string.value), 1, 6, true));
                    }
                }));
                add(new NumericalEvaluationItem(O2_SUPPLEMENT, context.getString(R.string.o2_supplement), context.getString(R.string.value), 23, 100, true));
                add(new BooleanEvaluationItem(FOUR_VASOPRESSORS, context.getString(R.string.four_vasopressors)));
                add(new BooleanEvaluationItem(ULTRAFILTRATION, context.getString(R.string.ultrafiltration)));
                add(new BooleanEvaluationItem(IABP, context.getString(R.string.iabp)));
                add(new BooleanEvaluationItem(TEMPORARY_PM, context.getString(R.string.temporary_pm)));
            }
        };
    }
}
