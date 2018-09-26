package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;

import java.util.ArrayList;

class Diagnostics extends SectionEvaluationItem {
    Diagnostics(Context context) {
        super(context, DIAGNOSTICS, null);
        name = getString(R.string.diagnostics);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(EKG, getString(R.string.ekg), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(NSR, "Normal sinus rhtym"));
                        add(new BooleanEvaluationItem(SVT, "Supraventricular tachycardia"));
                        add(new BooleanEvaluationItem(ATRIAL_FIBRILATION, getString(R.string.atrial_fibrilation)));
                        add(new SectionCheckboxEvaluationItem(ATRIAL_FLUTTER, getString(R.string.atrial_flutter), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(TYPICAL_AF, getString(R.string.typical_af)));
                                add(new BooleanEvaluationItem(ATYPICAL_AF, getString(R.string.atypical_af)));
                            }
                        }));
                        add(new NumericalEvaluationItem(PR_DURATION, getString(R.string.pr_duration), getString(R.string.value), -100, 100, true));
                        add(new NumericalEvaluationItem(QRS_DURATION, getString(R.string.qrs_duration), getString(R.string.value), -100, 100, true));
                        add(new BooleanEvaluationItem(NONSPECIFIC_ST_ABNORMALITY, "Nonspesific ST abnormality"));
                        add(new BooleanEvaluationItem(ST_DEVIATION_MORE_05_MM, getString(R.string.st_deviation_more_05_mm)));
                        add(new BooleanEvaluationItem(T_WAVE_INVERSION_MORE_1MM, getString(R.string.t_wave_inversion_more_1mm)));
                        add(new BooleanEvaluationItem(LVH, "LVH"));
                        add(new BooleanEvaluationItem(LOW_VOLTAGE_QRS, getString(R.string.low_voltage_qrs)));
                        add(new BooleanEvaluationItem(ABNORMAL_Q_WAVES, getString(R.string.abnormal_q_waves)));
                        add(new BooleanEvaluationItem(LBBB, "LBBB"));
                        add(new BooleanEvaluationItem(BIFASCICULAR, getString(R.string.bifascicular)));
                        add(new BooleanEvaluationItem(LAHB, getString(R.string.lahb)));
                        add(new BooleanEvaluationItem(LPHB, getString(R.string.lphb)));
                        add(new BooleanEvaluationItem(WPW, "WPW"));
                        add(new BooleanEvaluationItem(VPACE, "Ventricular pacing"));
                        add(new BooleanEvaluationItem(RBBB, "RBBB"));
                        add(new BooleanEvaluationItem(INTRAVENTICULAR_BLOCK, "IVCD"));

                        add(new BooleanEvaluationItem(ATRIAL_PREMATURE_DEPOLARIZATION, getString(R.string.atrial_premature_depolarization)));
                        add(new BooleanEvaluationItem(JUNCTIONAL_PREMATURE_DEPOLARIZATION, getString(R.string.junctional_premature_depolarization)));
                        add(new BooleanEvaluationItem(FREQUENT_VENTRICULAR_PACING_OR_ECTOPY, "Frequent ventricular ectopy"));
                        add(new BooleanEvaluationItem(INFREQUENT_VENTRICULAR_PACING_OR_ECTOPY, "Infrequent ventricular ectopy"));



                        add(new BooleanEvaluationItem(FIRST_DEGREE_AV_BLOCK, getString(R.string.first_degree_av_block)));
                        add(new SectionCheckboxEvaluationItem(SECOND_DEGREE_AV_BLOCK, getString(R.string.second_degree_av_block), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(TYPE_1, getString(R.string.type_1)));
                                add(new BooleanEvaluationItem(TYPE_2, getString(R.string.type_2)));
                            }
                        }));
                        add(new BooleanEvaluationItem(THIRD_DEGREE_AV_BLOCK, getString(R.string.third_degree_av_block)));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(STRESS_TESTING, getString(R.string.stress_testing), new ArrayList<EvaluationItem>() {
                    {
                        add(new BoldEvaluationItem(ETT, "Exercise Treadmill Test") {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new NumericalEvaluationItem(DUKE_TREADMILL_SCORE, "DTS "," Value" ,-25, 25, true));


                        add(new NumericalEvaluationItem(EX_TIME_MIN, getString(R.string.ex_time_min), getString(R.string.value), 1, 21, true));
                        add(new NumericalEvaluationItem(MAX_ST_MM, getString(R.string.max_st_mm), getString(R.string.value), 0, 8, true));
                        add(new SectionCheckboxEvaluationItem(ANGINA_INDEX, getString(R.string.angina_index), new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(NO_ANGINA_DURING_EXERCISE, getString(R.string.no_angina_during_exercise), ANGINA_INDEX, false));
                                add(new RadioButtonGroupEvaluationItem(NON_LIMITING_ANGINA, getString(R.string.non_limiting_angina), ANGINA_INDEX, false));
                                add(new RadioButtonGroupEvaluationItem(EXERCISE_LIMITING_ANGINA, getString(R.string.exercise_limiting_angina), ANGINA_INDEX, false));
                            }
                        }));
                        add(new BooleanEvaluationItem(ST_ELEVATION, getString(R.string.st_elevation)));
                        add(new BooleanEvaluationItem(ABNORMAL_BP_RESPONSE, getString(R.string.abnormal_bp_response)));
                        add(new BooleanEvaluationItem(VENTRICULAR_TACHYCARDIA, getString(R.string.ventricular_tachycardia)));
                        add(new BooleanEvaluationItem(PROLONG_ST_DEPRESSION, getString(R.string.prolong_st_depression)));

                        add(new BoldEvaluationItem(NUCLEAR, "Nuclear Imaging") {
                            {
                                setBackgroundHighlighted(true);
                            }

                        });

                        add(new NumericalEvaluationItem(SERUM_STRESS_SUMMED_SCORE, "SSS", " Value", 0, 99, true));


                        add(new NumericalEvaluationItem(STRESS_DIFFERENCE_SCORE, "SDS", getString(R.string.value), 0, 99, true));
                        add(new NumericalEvaluationItem(ISCHEMIC_MYOCARDIUM_ON_MPS, "% Ischemic myocardium", getString(R.string.value), 0, 100, true));
                        add(new BooleanEvaluationItem(TID_OR_SIGNIFICANT_STRESS_INDUCED_LV_DISFUNCTION, "Transient Ischemic Dilatation"));
                        add(new SectionCheckboxEvaluationItem(FIXED, "Fixed Perfusion Defects", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(VIABLE, "Viability present"));

                            }
                        }));
                        add(new BooleanEvaluationItem(ARTIFACTURAL_UNINTERPRETABLE_IMAGES, "Uninterpretable images"));
                        add(new BoldEvaluationItem(DSE, "Dobutamine Stress Echocardiography") {
                            {
                                setBackgroundHighlighted(true);
                            }

                        });

                        add(new SectionCheckboxEvaluationItem(FIXED_PERFUSION_DEFECTS_OR_AKINETIC_DYSKINETIC, "Akinetic, dyskinetic segments ", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(VIABILITY_PRESENT, getString(R.string.viability_present)));
                            }
                        }));
                        add(new NumericalEvaluationItem(DSE_ISCHEMIC_THRESHOLD, "DSE,ischemic threshold", "Value", 0, 200, true));
                        add(new NumericalEvaluationItem(DSE_OR_STRESS_MRI, "DSE or stress MRI, # of RWMA segments", "Value", 0, 24, true));
                        add(new BooleanEvaluationItem(STRESS_INDUCED_IMAGES, "Stress induced LV dilatation"));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(ECHOCARDIOGRAPHY, getString(R.string.echocardiography), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(PERICARDIAL_EFFUSION, getString(R.string.pericardial_effusion)));
                        add(new BooleanEvaluationItem(RWMA, getString(R.string.rwma)));
                        add(new BooleanEvaluationItem(ENLARGED_LA_OR_LVH, getString(R.string.enlarged_la_or_lvh)));
                        add(new BooleanEvaluationItem(E_A_LESS_05_AND_DT_MORE_280MS, getString(R.string.e_a_less_05_and_dt_more_280ms)));
                        add(new BooleanEvaluationItem(GRADE_MORE_2_DIASTOLIC_DYSFUNCTION, getString(R.string.grade_more_2_diastolic_dysfunction)));
                        add(new BooleanEvaluationItem(RESPIRATORY_IVS_SHIFT, getString(R.string.respiratory_ivs_shift)));
                        add(new BooleanEvaluationItem(MITRAL_E_VARIATION, getString(R.string.mitral_e_variation)));
                        add(new BooleanEvaluationItem(HEPATIC_VEIN_EXP_DIASTOLIC_REVERSAL, getString(R.string.hepatic_vein_exp_diastolic_reversal)));
                        add(new BooleanEvaluationItem(ENLARGED_RA, getString(R.string.enlarged_ra)));
                        add(new BooleanEvaluationItem(ENLARGED_RV, getString(R.string.enlarged_rv)));
                        add(new BooleanEvaluationItem(MIDSYSTOLIC_NOTCH, getString(R.string.midsystolic_notch)));
                        add(new NumericalEvaluationItem(LV_LATEREAL_ANNULUS_E_E, getString(R.string.lv_latereal_annulus_e_e), getString(R.string.value), 1, 30, true));
                        add(new NumericalEvaluationItem(LVEF_ECHO, getString(R.string.lvef), getString(R.string.value), 10, 80, true));
                        add(new NumericalEvaluationItem(TRJ_VELOCITY, getString(R.string.trj_velocity), getString(R.string.value), 1, 6, false));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(CHEST_X_RAY, "Chest x-ray", new ArrayList<EvaluationItem>() {
                {
                    add(new BooleanEvaluationItem(RIGHT_PLEURAL_EFFUSION, "Right pleural effusion"));
                    add(new BooleanEvaluationItem(LEFT_PLEURAL_EFFUSION, "Left pleural effusion"));
                    add(new BooleanEvaluationItem(PULMONARY_EDEMA_CHEST, "Pulmonary edema"));
                    add(new BooleanEvaluationItem(ENLARGED_CARDIAC_SOLHOUETTE, "Enlarged cardiac silhoutte"));
                    add(new BooleanEvaluationItem(WIDENED_MEDIASTENEUM, "Widened mediasteneum"));
                    add(new BooleanEvaluationItem(PNEUMOTHORAX, "Pneumothorax"));
                    add(new BooleanEvaluationItem(INFILTRATE, "Infiltrate(s)"));
                    add(new BooleanEvaluationItem(CONSOLIDATION, "Consolidation"));
                }
                }));
                add(new SectionCheckboxEvaluationItem(HRCT, "High resolution CT", new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(GROUND, "Ground glass infiltrates"));
                        add(new BooleanEvaluationItem(SEPTAL, "Inter, intralobular septal thickening"));
                        add(new BooleanEvaluationItem(RETICULAR, "Reticular infiltrates"));
                        add(new BooleanEvaluationItem(NODULAR, "Nodules"));
                        add(new BooleanEvaluationItem(CONSOLIDATE, "Consolidation"));
                        add(new BooleanEvaluationItem(HONEY, "Honey combing"));
                        add(new BooleanEvaluationItem(MEDIAS, "Mediastinal lymphadenopathy"));
                        add(new BooleanEvaluationItem(BRONCH, "Bronchiectasis"));
                        add(new BooleanEvaluationItem(PLEURAL, "Pleural thickening"));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(RHC, getString(R.string.rhc), new ArrayList<EvaluationItem>()) {
                    {
                        setShouldShowAlert(true);
                    }
                });
                add(new NumericalEvaluationItem(CORONARY_CALCIUM_SCORE, getString(R.string.coronary_calcium_score), getString(R.string.value), 0, 100, true));
                add(new NumericalEvaluationItem(TOTAL_CCS, getString(R.string.total), getString(R.string.value), 0, 10000, true));
            }
        };
    }
}
