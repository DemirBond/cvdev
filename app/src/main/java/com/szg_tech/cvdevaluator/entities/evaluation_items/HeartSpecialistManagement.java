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
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.StringEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.TabEvaluationItem;

import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;

import java.util.ArrayList;

public class HeartSpecialistManagement extends SectionEvaluationItem {
    public HeartSpecialistManagement(Context context) {
        super(context, HEART_SPECIALIST_MANAGEMENT, null);
        name = getString(R.string.heart_specialist_management);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionEvaluationItem(tempContext, BIO_PAH_MAIN, " 6MWT, CPET ", new ArrayList<EvaluationItem>() {
                    {
                        StringEvaluationItem nameItem = new StringEvaluationItem(NAME, getString(R.string.name), getString(R.string.name_hint), null);
                        NumericalEvaluationItem ageItem = new NumericalEvaluationItem(AGE, getString(R.string.age), getString(R.string.age_hint), 20, 100, true);
                        nameItem.setMandatory(true);
                        ageItem.setMandatory(true);
                        add(nameItem);
                        add(ageItem);
                        add(new SectionPlaceholderEvaluationItem(GENDER, getString(R.string.gender), getString(R.string.male),
                                new ArrayList<EvaluationItem>() {
                                    {
                                        add(new RadioButtonGroupEvaluationItem(MALE, getString(R.string.male), GENDER, true));
                                        add(new RadioButtonGroupEvaluationItem(FEMALE, getString(R.string.female), GENDER, false));
                                    }
                                }));
                        add(new NumericalEvaluationItem(BMI, "BMI", "Enter BMI", 100, 220, true));
                        add(new NumericalEvaluationItem(WEIGHT, getString(R.string.weight), getString(R.string.weight_hint), 40, 400, true));
                        add(new NumericalEvaluationItem(HEART_RATE, getString(R.string.heart_rate), getString(R.string.heart_rate_hint), 30, 300, true));

                        NumericalEvaluationItem sbpItem = new NumericalEvaluationItem(SBP, getString(R.string.sbp), getString(R.string.sbp_hint), 60, 300, true);
                        NumericalEvaluationItem dbpItem = new NumericalEvaluationItem(DBP, getString(R.string.dbp), getString(R.string.dbp_hint), 30, 160, true);
                        sbpItem.setMandatory(true);
                        dbpItem.setMandatory(true);
                        add(sbpItem);
                        add(dbpItem);

                        add(new BooleanEvaluationItem(ORTHOSTATIC_SYMPTOMPS, getString(R.string.orthostatic_symptomps)));

                        add(new NumericalEvaluationItem(SIX_MW_DISTANCE, getString(R.string.six_mw_distance), getString(R.string.value), 50, 600, true));
                        add(new NumericalEvaluationItem(MAX_VO_MG_KG_MIN, getString(R.string.max_vo_mg_kg_min), getString(R.string.value), 6, 40, true));

                    }
                }, SectionElementState.OPENED));
                add(new SectionEvaluationItem(tempContext, PAH, "PAH clinics", new ArrayList<EvaluationItem>() {
                    {
                        add(new TabEvaluationItem("heart_rate_tab", "tab", new ArrayList<SectionEvaluationItem>() {
                            {
                                add(new SectionEvaluationItem(tempContext, "tab_pg1", getString(R.string.pah), new ArrayList<EvaluationItem>() {
                                    {

                                        add(new BooleanEvaluationItem(IDIOPATHIC, getString(R.string.idiopathic)));
                                        add(new SectionCheckboxEvaluationItem(CONGENITAL, getString(R.string.congenital), new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(ASD_LESS_2CM, getString(R.string.asd_less_2cm)));
                                                add(new BooleanEvaluationItem(VSD_LESS_1CM, getString(R.string.vsd_less_1cm)));
                                                add(new BooleanEvaluationItem(POST_CORRECTIVE_SURGERY, getString(R.string.post_corrective_surgery)));
                                                add(new BooleanEvaluationItem(EISENMENGER, getString(R.string.eisenmenger)));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(SCLERODERMA, getString(R.string.scleroderma)));
                                        add(new BooleanEvaluationItem(SLE, getString(R.string.sle)));
                                        add(new BooleanEvaluationItem(HIV, getString(R.string.hiv)));
                                        add(new BooleanEvaluationItem(PORTAL_HYPERTENSION, getString(R.string.portal_hypertension)));
                                        add(new SectionCheckboxEvaluationItem(RESPIRATORY_DISEASE_HYPOXIA, getString(R.string.respiratory_disease_hypoxia), new ArrayList<EvaluationItem>() {
                                            {
                                                add(new NumericalEvaluationItem(AHI, getString(R.string.ahi), getString(R.string.value), 0, 100, true));
                                                add(new BooleanEvaluationItem(OSA, getString(R.string.osa)));
                                                add(new BooleanEvaluationItem(IPF_ILD, getString(R.string.ipf_ild)));
                                                add(new BooleanEvaluationItem(COPD, getString(R.string.copd)));
                                            }
                                        }));

                                        add(new BooleanEvaluationItem(PVOD_PCH, getString(R.string.pvod_pch)));
                                        add(new BooleanEvaluationItem(SPLENECTOMY_SC, getString(R.string.splenectomy_sc)));
                                        add(new BooleanEvaluationItem(FAMILIAL, getString(R.string.familial)));
                                        add(new BooleanEvaluationItem(CTEP, getString(R.string.ctep)));
                                        add(new BooleanEvaluationItem(DRUGS_TOXINS, getString(R.string.drugs_toxins)));
                                    }
                                }));
                                add(new SectionEvaluationItem(tempContext,"tab_pg2", getString(R.string.pah), new ArrayList<EvaluationItem>() {
                                    {
                                        {
                                            add(new NumericalEvaluationItem(DLCO, "DLCO,%", "Value", 1, 6, false));
                                            add(new NumericalEvaluationItem(FEV1_LT, "FEV1,lt", "Value", 16, 144, true));
                                            add(new NumericalEvaluationItem(FEV1_PERCENT, "FEV1,%", "Value", 1, 6, false));
                                            add(new NumericalEvaluationItem(IC_TLC, "IC/TLC", "Value", 1, 6, false));
                                        }
                                    }
                                }));

                                add(new SectionEvaluationItem(tempContext,"tab_pg3", getString(R.string.pah), new ArrayList<EvaluationItem>() {
                                    {
                                        {
                                            add(new NumericalEvaluationItem(TR_JET_VELOCITY, "TRJ m/s", "Value", 1, 6, false));
                                            add(new NumericalEvaluationItem(EXERCISE_RSVP, "Exercise RVSPmmHg", "Value", 16, 144, true));


                                            add(new BooleanEvaluationItem(ENLARGED_RA, "Enlarged RA"));

                                            add(new BooleanEvaluationItem(ENLARGED_RV, "Enlarged RV"));
                                            add(new BooleanEvaluationItem(PERICARDIAL_EFFUSION, "Pericardial effusion"));
                                            add(new SectionCheckboxEvaluationItem(CHECK_IF_LV_TD_DONE, "Advanced Echocardiography", new ArrayList<EvaluationItem>() {
                                                {

                                                    add(new SectionCheckboxEvaluationItem(CHECK_IF_LV_TD_DONE, "LV tissue doppler", new ArrayList<EvaluationItem>() {
                                                        {
                                                            add(new BooleanEvaluationItem(E_E_LESS_8, "E/E <8 "));
                                                            add(new BooleanEvaluationItem(E_E_8_16, "E/E' 8 to 16"));
                                                            add(new BooleanEvaluationItem(E_E_MORE_16, "E/E' > 16"));
                                                        }
                                                    }));

                                                    add(new SectionCheckboxEvaluationItem(CHECK_IF_RVOT_PW_DONE, "RVOT DOPPLER ", new ArrayList<EvaluationItem>() {
                                                        {
                                                            add(new BooleanEvaluationItem(SHORT_PAAT, "Short PAAT"));
                                                            add(new BooleanEvaluationItem(MIDSYSTOLIC_NOTCH, "Midsystolic notch"));
                                                        }
                                                    }));

                                                    add(new SectionCheckboxEvaluationItem(CHECK_IF_TAPSE_DONE, "TAPSE", new ArrayList<EvaluationItem>() {
                                                        {
                                                            add(new BooleanEvaluationItem(TAPSE_LESS_2, "TAPSE < 2 "));
                                                        }
                                                    }));

                                                }
                                            }));
                                        }
                                    }

                                }));
                            }
                        }));
                    }

                }, SectionElementState.OPENED));

                add(new SectionEvaluationItem(tempContext,VALVULAR, getString(R.string.valvular), new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(tempContext,VALVULAR, getString(R.string.valvular), new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(LVEF_PAH, getString(R.string.lvef), getString(R.string.value), 10, 80, true));
                                add(new BooleanEvaluationItem(NEW_ONSET_ATRIAL_FIBRILATION, getString(R.string.new_onset_atrial_fibrilation)));
                                add(new BooleanEvaluationItem(PREGNANCY, getString(R.string.pregnancy)));
                                add(new SectionCheckboxEvaluationItem(AORTIC_STENOSIS, getString(R.string.aortic_stenosis), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(CALCIFIED_AORTIC_VALVE_REDUCED_SYSTOLIC_OPENING, "Calcified AV"));
                                        add(new BooleanEvaluationItem(CONGENITALLY_STENOTIC_AORTIC_VALVE, getString(R.string.congenitally_stenotic_aortic_valve)));
                                        add(new BooleanEvaluationItem(RHEUMATIC_AV, getString(R.string.rheumatic_av)));
                                        add(new NumericalEvaluationItem(CALCULATED_AORTIC_VALVE_AREA, getString(R.string.calculated_aortic_valve_area), getString(R.string.value), 0.1, 4, false));
                                        add(new NumericalEvaluationItem(AORTIC_MEAN_PRESSURE_GRADIENT, getString(R.string.aortic_mean_pressure_gradient), getString(R.string.value), 4, 60, true));
                                        add(new NumericalEvaluationItem(AORTIC_VALVE_VALOCITY, getString(R.string.aortic_valve_valocity), getString(R.string.value), 1, 6, true));
                                        add(new NumericalEvaluationItem(STROKE_VOLUME_INDEX_SV_SBA, getString(R.string.stroke_volume_index_sv_sba), getString(R.string.value), 1, 9, true));
                                        add(new NumericalEvaluationItem(INDEXED_VALVE_AREA_AVA_BSA, getString(R.string.indexed_valve_area_ava_bsa), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(BISCUSPID_AORTIC_ROOT_DIAMETER, getString(R.string.biscuspid_aortic_root_diameter), getString(R.string.value), 0.1, 7, false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(MITRAL_STENOSIS, getString(R.string.mitral_stenosis), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(MVA_CM_2, getString(R.string.mva_cm_2), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(PHT_MSEC, getString(R.string.pht_msec), getString(R.string.value), 50, 400, true));
                                        add(new BooleanEvaluationItem(RHEUMATIC_MV_TV, getString(R.string.rheumatic_mv_tv)));
                                        add(new BooleanEvaluationItem(FAVORABLE_VALVE_MORPHOLOGY, getString(R.string.favorable_valve_morphology)));
                                        add(new BooleanEvaluationItem(LA_CLOT, getString(R.string.la_clot)));
                                    }
                                }));

                                add(new SectionCheckboxEvaluationItem(PULMONIC_STENOSIS, getString(R.string.pulmonic_stenosis), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(PULMONIC_VALVE_VELOCITY, getString(R.string.pulmonic_valve_velocity), getString(R.string.value), 0.5, 5, false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(AORTIC_REGURGITATION, getString(R.string.aortic_regurgitation), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(HOLODIASTOLIC_FLOW_REVERSAL, getString(R.string.holodiastolic_flow_reversal)));
                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH, getString(R.string.vena_contracta_width), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(REGURGITANT_VOLUME_ML_BEAT, getString(R.string.regurgitant_volume_ml_beat), getString(R.string.value), 0, 99, true));
                                        add(new NumericalEvaluationItem(REGURGITANT_FRACTION, getString(R.string.regurgitant_fraction), getString(R.string.value), 0, 61, true));
                                        add(new NumericalEvaluationItem(ERO, getString(R.string.ero), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(LVEDD_MM, getString(R.string.lvedd_mm), getString(R.string.value), 10, 90, true));
                                        add(new NumericalEvaluationItem(LVESD_MM, getString(R.string.lvesd_mm), getString(R.string.value), 10, 60, true));
                                        add(new NumericalEvaluationItem(AORTIC_ROOT_DIAMETER, getString(R.string.aortic_root_diameter), getString(R.string.value), 2, 9, true));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(PRIMARY_MITRAL_REGURGITATION, getString(R.string.primary_mitral_regurgitation), new ArrayList<EvaluationItem>() {
                                    {

                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH, getString(R.string.vena_contracta_width), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(REGURGITANT_VOLUME_ML_BEAT, getString(R.string.regurgitant_volume_ml_beat), getString(R.string.value), 0, 99, true));
                                        add(new NumericalEvaluationItem(REGURGITANT_FRACTION, getString(R.string.regurgitant_fraction), getString(R.string.value), 0, 61, true));
                                        add(new NumericalEvaluationItem(ERO, getString(R.string.ero), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(LVEDD_MM, getString(R.string.lvedd_mm), getString(R.string.value), 10, 90, true));
                                        add(new NumericalEvaluationItem(LVESD_MM, getString(R.string.lvesd_mm), getString(R.string.value), 10, 60, true));

                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(TRICUSPID_REGURGITATION, getString(R.string.tricuspid_regurgitation), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(ANNULAR_DIAMETER, getString(R.string.annular_diameter), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(CENTRAL_JET_AREA_CM_2, getString(R.string.central_jet_area_cm_2), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH_TRI, getString(R.string.vena_contracta_width), getString(R.string.value), 0.1, 9, false));
                                        add(new BooleanEvaluationItem(HEPATIC_VEIN_FLOW_REVERSAL, getString(R.string.hepatic_vein_flow_reversal)));
                                        add(new BooleanEvaluationItem(ABNORMAL_TV_LEAFLETS, getString(R.string.abnormal_tv_leaflets)));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(PULMONIC_REGURGITATION, getString(R.string.pulmonic_regurgitation), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(WIDE_REGURFITANT_JET, getString(R.string.wide_regurfitant_jet)));
                                        add(new BooleanEvaluationItem(ABNORMAL_PULMONIC_VALVE_LEAFLETS, getString(R.string.abnormal_pulmonic_valve_leaflets)));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED));

                        add(new SectionEvaluationItem(tempContext, VALVULAR_SURGERY_RISK, getString(R.string.valvular_surgery_risk), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(LOW, getString(R.string.low)));
                                add(new BooleanEvaluationItem(INTERMEDIATE, getString(R.string.intermediate)));
                                add(new BooleanEvaluationItem(HIGH, getString(R.string.high)));
                                add(new BooleanEvaluationItem(PROHIBITIVE, getString(R.string.prohibitive)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(tempContext, OTHER_SURGICAL_RISK, getString(R.string.other_surgical_risk), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(HIGH_RISK_SUPRA_INGUINAL_VASCULAR_SURGERY, getString(R.string.high_risk_supra_inguinal_vascular_surgery)));
                                add(new BooleanEvaluationItem(LOW_RISK_CATARACT_PLASTIC, getString(R.string.low_risk_cataract_plastic)));
                                add(new BooleanEvaluationItem(INTERMEDIATE_RISK, getString(R.string.intermediate_risk)));
                                add(new BooleanEvaluationItem(OTHER_CARDIAC, getString(R.string.other_cardiac)));
                            }
                        }, SectionElementState.OPENED));
                    }
                }, SectionElementState.OPENED));
                {
                    add(new SectionCheckboxEvaluationItem(HEART_FAILURE, getString(R.string.heart_failure), new ArrayList<EvaluationItem>() {
                        {
                            add(new SectionEvaluationItem(tempContext, HEART_FAILURE_DURATION, getString(R.string.heart_failure_duration), new ArrayList<EvaluationItem>() {
                                {
                                    add(new NumericalEvaluationItem(HEART_FAILURE_DURATION_WEEK, getString(R.string.heart_failure_duration_week), getString(R.string.value), 0, 100, false));
                                    add(new BooleanEvaluationItem(DAY1, getString(R.string.day1)));
                                    add(new BooleanEvaluationItem(DAY2, getString(R.string.day2)));
                                    add(new BooleanEvaluationItem(DAY3, getString(R.string.day3)));
                                    add(new BooleanEvaluationItem(CRT_ICD, getString(R.string.crt_icd)));
                                }
                            }, SectionElementState.OPENED));
                            add(new SectionEvaluationItem(tempContext, CLINICS, getString(R.string.clinics), new ArrayList<EvaluationItem>() {
                                {
                                    add(new NumericalEvaluationItem(LVEF, getString(R.string.lvef), getString(R.string.value), 10, 80, true));
                                    add(new NumericalEvaluationItem(RASAT, "RA O2 sat", "", 50, 100, true));
                                    add(new NumericalEvaluationItem(NT_PROBNP_PG_ML, getString(R.string.nt_probnp_pg_ml), getString(R.string.value), 50, 100000, true));
                                    add(new BooleanEvaluationItem(PULMONARY_EDEMA, getString(R.string.pulmonary_edema)));
                                    add(new BooleanEvaluationItem(LEFT_SIDED_S3, "Left sided S3"));
                                    add(new BooleanEvaluationItem(CARDIO_SHOCK, getString(R.string.cardio_shock)));
                                    add(new BooleanEvaluationItem(DYSPNEA_ON_EXERTION, getString(R.string.dyspnea_on_exertion)));
                                    add(new BooleanEvaluationItem(DYSPNEA_AT_REST_MORE_2_HRS_AFTER_RX, getString(R.string.dyspnea_at_rest_more_2_hrs_after_rx)));
                                    add(new BooleanEvaluationItem(NEW_RALES, getString(R.string.new_rales)));
                                    add(new BooleanEvaluationItem(HJR, getString(R.string.hepatojuluar_reflux)));
                                    add(new BooleanEvaluationItem(JUGULAR_VENOUS_DISTENTION, getString(R.string.jugular_venous_distention)));
                                    add(new BooleanEvaluationItem(WEIGHT_GAIN, getString(R.string.weight_gain)));
                                    add(new BooleanEvaluationItem(ANY_CNS_SYMPTOMS, getString(R.string.any_cns_symptoms)));
                                    add(new BooleanEvaluationItem(WORSENING_RENAL_FX, getString(R.string.worsening_renal_fx)));
                                    add(new BooleanEvaluationItem(EDEMA, getString(R.string.edema)));
                                }
                            }, SectionElementState.OPENED));
                            add(new SectionEvaluationItem(tempContext, ETIOLOGY, getString(R.string.Etiology), new ArrayList<EvaluationItem>() {
                                {
                                    add(new BooleanEvaluationItem(DCM, getString(R.string.dcm)));
                                    add(new SectionCheckboxEvaluationItem(HOCM, getString(R.string.hocm), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new BooleanEvaluationItem(LVH_MORE_30, getString(R.string.lvh_more_30)));
                                            add(new BooleanEvaluationItem(ABNORMAL_BP_RESPONSE_TO_EXERCISE, getString(R.string.abnormal_bp_response_to_exercise)));
                                            add(new BooleanEvaluationItem(FAMILY_HISTORY_OF_SUDDEN_DEATH, getString(R.string.family_history_of_sudden_death)));
                                        }
                                    }));
                                    add(new BooleanEvaluationItem(ISCHEMIC, getString(R.string.ischemic)));
                                    add(new BooleanEvaluationItem(CARDIOTOXINS, getString(R.string.cardiotoxins)));
                                    add(new BooleanEvaluationItem(FAMILIAL_CMP_ASSOCIATED_SUDDEN_DEATH, getString(R.string.familial_cmp_associated_sudden_death)));
                                    add(new BooleanEvaluationItem(VALVULAR_HEART_DISEASE_SEC, getString(R.string.valvular_heart_disease)));
                                    add(new BooleanEvaluationItem(RV_DYSPLASIA, getString(R.string.rv_dysplasia)));
                                    add(new BooleanEvaluationItem(MI_MORE_45_DAYS, getString(R.string.mi_more_45_days)));
                                }
                            }, SectionElementState.OPENED));
                            add(new SectionEvaluationItem(tempContext, STAGE_CLASS, getString(R.string.stage_class), new ArrayList<EvaluationItem>() {
                                {
                                    add(new BooleanEvaluationItem(AT_HIGH_RISK, getString(R.string.at_high_risk)));
                                    add(new BooleanEvaluationItem(NO_SIGNS_OF_HF, getString(R.string.no_signs_of_hf)));
                                    add(new BooleanEvaluationItem(SYMPTOMS_OF_HF, getString(R.string.symptoms_of_hf)));
                                    add(new SectionCheckboxEvaluationItem(REFRACTORY_HF, getString(R.string.refractory_hf), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new BoldEvaluationItem(CALCULATE_HFSS, getString(R.string.calculate_hfss)));
                                            add(new BooleanEvaluationItem(NO_SIGNIFICANT_COMORBIDITIES, getString(R.string.no_significant_comorbidities)));
                                            add(new BooleanEvaluationItem(FREQUENT_HOSPITAL_ADMISSIONS, getString(R.string.frequent_hospital_admissions)));
                                        }
                                    }));
                                    add(new BooleanEvaluationItem(NYHA_CCVS_CLASS_1, "NYHA/CCVS Class 1"));
                                    add(new BooleanEvaluationItem(NYHA_CCVS_CLASS_2, getString(R.string.nyha_ccvs_class_2)));
                                    add(new BooleanEvaluationItem(NYHA_CCVS_CLASS_3, getString(R.string.nyha_ccvs_class_3)));
                                    add(new BooleanEvaluationItem(NYHA_CCVS_CLASS_4, getString(R.string.nyha_ccvs_class_4)));
                                }
                            }, SectionElementState.OPENED));

                            add(new SectionEvaluationItem(tempContext, ARRTHYMIAS, getString(R.string.arrthymias), new ArrayList<EvaluationItem>() {
                                {
                                    add(new BooleanEvaluationItem(AV_NODE_DISEASE, getString(R.string.av_node_disease)));
                                    add(new BooleanEvaluationItem(SINUS_NODE_DYSFUNCTION, getString(R.string.sinus_node_dysfunction)));
                                    add(new BooleanEvaluationItem(VENTRICULAR_TACHYCARDIA_PAH, getString(R.string.ventricular_tachycardia)));
                                    add(new BooleanEvaluationItem(NSVT, getString(R.string.nsvt)));
                                }
                            }, SectionElementState.OPENED));

                            add(new SectionEvaluationItem(tempContext, HOME_THERAPEUTICS, getString(R.string.home_therapeutics), new ArrayList<EvaluationItem>() {
                                {
                                    add(new SectionCheckboxEvaluationItem(B_BLOCKER, getString(R.string.b_blocker), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new BooleanEvaluationItem(CARVEDILOL_3125BID, getString(R.string.carvedilol_3125bid)));
                                            add(new BooleanEvaluationItem(CARVEDILOL_625BID, getString(R.string.carvedilol_625bid)));
                                            add(new BooleanEvaluationItem(CARVEDILOL_125BID, getString(R.string.carvedilol_125bid)));
                                            add(new BooleanEvaluationItem(CARVEDILOL_25BID, getString(R.string.carvedilol_25bid)));
                                            add(new BooleanEvaluationItem(METOPROLOLER_25_QD, getString(R.string.metoprololer_25_qd)));
                                            add(new BooleanEvaluationItem(METOPROLOLER_50_QD, getString(R.string.metoprololer_50_qd)));
                                            add(new BooleanEvaluationItem(METOPROLOLER_100_QD, getString(R.string.metoprololer_100_qd)));
                                            add(new BooleanEvaluationItem(METOPROLOLER_150_QD, getString(R.string.metoprololer_150_qd)));
                                            add(new BooleanEvaluationItem(METOPROLOLER_200_QD, getString(R.string.metoprololer_200_qd)));
                                        }
                                    }));
                                    add(new BooleanEvaluationItem(ACEL_ARB, getString(R.string.acel_arb)));
                                    add(new SectionCheckboxEvaluationItem(PO_DIURETIC, getString(R.string.po_diuretic), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new BooleanEvaluationItem(FUROSEMIDE_40, getString(R.string.furosemide_40)));
                                            add(new BooleanEvaluationItem(FUROSEMIDE_80, getString(R.string.furosemide_80)));
                                            add(new BooleanEvaluationItem(FUROSEMIDE_80_PLUS, getString(R.string.furosemide_80_plus)));
                                            add(new BooleanEvaluationItem(BURNEX_1, getString(R.string.burnex_1)));
                                            add(new BooleanEvaluationItem(BURNEX_2, getString(R.string.burnex_2)));
                                            add(new BooleanEvaluationItem(BURNEX_2_PLUS, getString(R.string.burnex_2_plus)));
                                            add(new BooleanEvaluationItem(TORSEMIDE_20, getString(R.string.torsemide_20)));
                                            add(new BooleanEvaluationItem(TORSEMIDE_40, getString(R.string.torsemide_40)));
                                            add(new BooleanEvaluationItem(TORSEMIDE_50_PLUS, getString(R.string.torsemide_50_plus)));
                                            add(new BooleanEvaluationItem(HCTZ, getString(R.string.hctz)));
                                            add(new BooleanEvaluationItem(INDAPAMIDE, getString(R.string.indapamide)));
                                            add(new BooleanEvaluationItem(CHLORTHALIDONE_METOLAZONE, getString(R.string.chlorthalidone_metolazone)));
                                        }
                                    }));
                                }
                            }, SectionElementState.OPENED));

                            add(new SectionEvaluationItem(tempContext, THERAPEUTICS, getString(R.string.therapeutics), new ArrayList<EvaluationItem>() {
                                {
                                    add(new SectionCheckboxEvaluationItem(FOUR_ANTIARRYTHMIC, getString(R.string.four_antiarrythmic), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new BooleanEvaluationItem(CONTINOUS_IVAA, getString(R.string.Continuous)));
                                            add(new BooleanEvaluationItem(BOLUS_IVAA, getString(R.string.bolus)));
                                            add(new BooleanEvaluationItem(TITRATION_IVAA, getString(R.string.titration)));
                                            add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVAA, getString(R.string.monitoring_frequency_q_hr), getString(R.string.value), 1, 12, true));
                                            add(new BooleanEvaluationItem(TRANSITION_TO_PO_ANTIARRYTHMIC, getString(R.string.transition_to_po_antiarrythmic)));
                                        }
                                    }));
                                    add(new BooleanEvaluationItem(URGENT_CV, getString(R.string.urgent_cv)));
                                    add(new BooleanEvaluationItem(DEFIBRILLATION_ACLS, getString(R.string.defibrillation_acls)));
                                    add(new SectionCheckboxEvaluationItem(FOUR_ANTIHYPERTENSIVE, getString(R.string.four_antihypertensive), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new BooleanEvaluationItem(CONTINOUS_IVHT, getString(R.string.Continuous)));
                                            add(new BooleanEvaluationItem(BOLUS_IVHT, getString(R.string.bolus)));
                                            add(new BooleanEvaluationItem(TITRATION_IVHT, getString(R.string.titration)));
                                            add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVHT, getString(R.string.monitoring_frequency_q_hr), getString(R.string.value), 1, 12, true));
                                        }
                                    }));
                                    add(new SectionCheckboxEvaluationItem(FOUR_VASOACTIVE, getString(R.string.four_vasoactive), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new BooleanEvaluationItem(CONTINOUS_IVVA, getString(R.string.Continuous)));
                                            add(new BooleanEvaluationItem(BOLUS_IVVA, getString(R.string.bolus)));
                                            add(new BooleanEvaluationItem(TITRATION_IVVA, getString(R.string.titration)));
                                            add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVVA, getString(R.string.monitoring_frequency_q_hr), getString(R.string.value), 1, 12, true));
                                            add(new BooleanEvaluationItem(FOUR_NPS, getString(R.string.four_nps)));
                                            add(new BooleanEvaluationItem(FOUR_NTG, getString(R.string.four_ntg)));
                                            add(new BooleanEvaluationItem(FOUR_MILRINONE, getString(R.string.four_milrinone)));
                                        }
                                    }));
                                    add(new SectionCheckboxEvaluationItem(FOUR_DIURETIC, getString(R.string.four_diuretic), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new BooleanEvaluationItem(CONTINOUS_IVDI, getString(R.string.Continuous)));
                                            add(new BooleanEvaluationItem(INTERMITTENT, getString(R.string.intermittent)));
                                            add(new NumericalEvaluationItem(MONITORING_FREQUENCY_Q_HR_IVDI, getString(R.string.monitoring_frequency_q_hr), getString(R.string.value), 1, 12, true));
                                        }
                                    }));
                                    add(new SectionCheckboxEvaluationItem(MECHANICAL_VENTIALLATION_OR_NIPPV, getString(R.string.mechanical_ventiallation_or_nippv), new ArrayList<EvaluationItem>() {
                                        {
                                            add(new NumericalEvaluationItem(RESPIRATORY_INTERVENTIONS_Q_HR, getString(R.string.respiratory_interventions_q_hr), getString(R.string.value), 1, 6, true));
                                        }
                                    }));
                                    add(new NumericalEvaluationItem(O2_SUPPLEMENT, getString(R.string.o2_supplement), getString(R.string.value), 23, 100, true));
                                    add(new BooleanEvaluationItem(FOUR_VASOPRESSORS, getString(R.string.four_vasopressors)));
                                    add(new BooleanEvaluationItem(ULTRAFILTRATION, getString(R.string.ultrafiltration)));
                                    add(new BooleanEvaluationItem(IABP, getString(R.string.iabp)));
                                    add(new BooleanEvaluationItem(TEMPORARY_PM, getString(R.string.temporary_pm)));
                                    add(new BooleanEvaluationItem(ON_MAX_TOLERATED_B_BLOCKER, getString(R.string.on_max_tolerated_b_blocker)));
                                    add(new BooleanEvaluationItem(ON_MAX_TOLERATED_ACE_IARB, getString(R.string.on_max_tolerated_acei_arb)));
                                    add(new BooleanEvaluationItem(CHRONIC_INOTROPE_DEPENDENCE, getString(R.string.chronic_inotrope_dependence)));
                                    add(new BooleanEvaluationItem(INTERMITTENT_INOTROPE_DEPENDENCE, getString(R.string.intermittent_inotrope_dependence)));
                                }
                            }, SectionElementState.OPENED));
                        }


                    }));
                    add(new SectionCheckboxEvaluationItem(ECHOCARDIOGRAPHY, "Echocardiography", new ArrayList<EvaluationItem>() {
                        {
                            add(new BooleanEvaluationItem(E_A_LESS_05_AND_DT_MORE_280MS, "Grade 1 DD"));
                            add(new BooleanEvaluationItem(GRADE_MORE_2_DIASTOLIC_DYSFUNCTION, "Grade 2 DD"));

                            add(new NumericalEvaluationItem(LV_LATEREAL_ANNULUS_E_E, "Lateral annulus E/E'", "Value", 1, 30, true));
                            add(new NumericalEvaluationItem(LVEF, "LVEF", " Value", 10, 80, true));
                        }
                    }));
                    add(new SectionCheckboxEvaluationItem(EKG, "EKG", new ArrayList<EvaluationItem>() {
                        {
                            add(new NumericalEvaluationItem(QRS_DURATION, "QRS duration", "Value", 10, 300, true));
                            add(new BooleanEvaluationItem(LBBB, "LBBB"));
                        }
                    }));
                    add(new SectionCheckboxEvaluationItem(NEW_ONSET_HEART_FAILURE_INITIAL_EVALUATION, "Laboratories", new ArrayList<EvaluationItem>() {
                        {
                            add(new NumericalEvaluationItem(GFR_ML_MIN, "GFR", "Value", 0, 120, true));
                            add(new NumericalEvaluationItem(CREATININE_MG_DL, "Creatinine", "Value", 0.4, 20, false));
                            add(new NumericalEvaluationItem(NA, "Na meq.l", "Value", 99, 170, true));
                            add(new NumericalEvaluationItem(K_MEQ_L, "K meq.l", "Value", 2, 9, false));
                            add(new NumericalEvaluationItem(PLATELETS_K_ML, "Platelet K", "Value", 1000, 1000000, true));
                            add(new NumericalEvaluationItem(ALBUMIN_G_DL, "Albumin gm.dl", "Value", 0.9, 5, false));
                            add(new NumericalEvaluationItem(INR_PAH, "INR", "Value", 0.8, 100, false));
                            add(new NumericalEvaluationItem(AST_U_ML, "AST U.ml", "Value", 10, 100000, true));
                            add(new NumericalEvaluationItem(BUN_U_DL, "BUN", "Value", 6, 200, true));
                            add(new NumericalEvaluationItem(HEMATOCRIT, "Hematocrit", "Value", 9, 75, true));
                            add(new NumericalEvaluationItem(BNP_PG_ML, "BNP", "Value", 10, 100000, true));
                        }
                    }));

                }
                add(new SectionEvaluationItem(tempContext, RHC, getString(R.string.rhc), new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(MEAN_PAP_MMHG, getString(R.string.mean_pap_mmhg), getString(R.string.value), 10, 70, true));
                        add(new NumericalEvaluationItem(PVR_WU, getString(R.string.pvr_wu), getString(R.string.value), 1, 20, false));
                        add(new NumericalEvaluationItem(LVEDP_MMHG, getString(R.string.lvedp_mmhg), getString(R.string.value), 8, 50, true));
                        add(new NumericalEvaluationItem(PCWP_MMGH, getString(R.string.pcwp_mmgh), getString(R.string.value), 3, 40, true));
                        add(new NumericalEvaluationItem(CL_LT_MIN_SQ, getString(R.string.cl_lt_min_sq), getString(R.string.value), 0.9, 5, false));
                        add(new NumericalEvaluationItem(RA_PRESSURE_MMHG, getString(R.string.ra_pressure_mmhg), getString(R.string.value), 0, 40, true));
                        add(new NumericalEvaluationItem(V_WAVE_AMPLITUDE, getString(R.string.v_wave_amplitude), getString(R.string.value), 0, 40, true));
                        add(new BooleanEvaluationItem(NO_V_WAVE, getString(R.string.no_v_wave)));
                        add(new NumericalEvaluationItem(PADP_MMHG, getString(R.string.padp_mmhg), getString(R.string.value), 5, 40, true));
                        add(new NumericalEvaluationItem(RVEDP_MMGH, getString(R.string.rvedp_mmgh), getString(R.string.value), 3, 20, true));
                        add(new NumericalEvaluationItem(SVR_WU, getString(R.string.svr_wu), "SVR, WU", 1, 19, false));
                    }
                }, SectionElementState.OPENED));
            }
        };
    }
}
