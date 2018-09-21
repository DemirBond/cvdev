package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class CurrentCVProfile extends SectionEvaluationItem {

    CurrentCVProfile(Context context) {
        super(CURRENT_PAST_CV_PROFILE, null);
        name = "Cardiovascular";
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    public class  CoronaryHeartDisease extends SectionEvaluationItem{
        public CoronaryHeartDisease(Context context) {
            super(CORONARY_HEART_DISEASE, null);
            name = context.getString(R.string.coronary_heart_disease);
            this.evaluationItemList = createEvaluationItemElementsList(context);
            sectionElementState = SectionEvaluationItem.SectionElementState.OPENED;
        }
        private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context){
            ArrayList<EvaluationItem> list = new ArrayList<>();
            list.add(new SectionCheckboxEvaluationItem(ACUTE_CORONARY_SYNDROME, context.getString(R.string.acute_coronary_syndrome), new ArrayList<EvaluationItem>() {
                {
                    add(new BooleanEvaluationItem(MORE_2_ANGINA_24HR, context.getString(R.string.more_2_angina_24hr)));
                    add(new BooleanEvaluationItem(ANGINA_MORE_20MIN, context.getString(R.string.angina_more_20min)));
                    add(new BooleanEvaluationItem(ASA_ACS, context.getString(R.string.asa_use_in_past_1_week)));
                    add(new BooleanEvaluationItem(POSITIVE_TROP_I_OR_T, context.getString(R.string.positive_trop_i_or_t)));
                    add(new BooleanEvaluationItem(MORE_2_ANTANGINAL, context.getString(R.string.more_2_antanginal)));
                    add(new SectionCheckboxEvaluationItem(STEMI, context.getString(R.string.stemi), new ArrayList<EvaluationItem>() {
                        {
                            add(new NumericalEvaluationItem(DURATION_HOURS, context.getString(R.string.duration_hours), context.getString(R.string.value), 0, 48, true));
                            add(new BooleanEvaluationItem(ANTERIOR, context.getString(R.string.anterior)));
                            add(new BooleanEvaluationItem(INFERIOR, context.getString(R.string.inferior)));
                            add(new BooleanEvaluationItem(OTHER, context.getString(R.string.other)));
                        }
                    }));
                    add(new BooleanEvaluationItem(REFRACTORY_ANGINA, context.getString(R.string.refractory_angina)));
                    add(new BooleanEvaluationItem(CHANGING_TROP_I, context.getString(R.string.changing_trop_i)));
                }
            }));
            list.add(new SectionCheckboxEvaluationItem(PCI_CABG, context.getString(R.string.pci_cabg), new ArrayList<EvaluationItem>() {
                {
                    add(new NumericalEvaluationItem(LAST_PROCEDURE, context.getString(R.string.last_procedure), context.getString(R.string.value), 0, 50, true));
                    add(new BooleanEvaluationItem(BMS, context.getString(R.string.bms)));
                    add(new BooleanEvaluationItem(DES, context.getString(R.string.des)));
                    add(new SectionCheckboxEvaluationItem(CABG, context.getString(R.string.cabg), new ArrayList<EvaluationItem>() {
                        {
                            add(new BooleanEvaluationItem(AUTO_VEIN, context.getString(R.string.auto_vein)));
                            add(new BooleanEvaluationItem(AUTO_ARTERY, context.getString(R.string.auto_artery)));
                            add(new BooleanEvaluationItem(NON_AUTO, context.getString(R.string.non_auto)));
                        }
                    }));
                }
            }));
            list.add(new SectionCheckboxEvaluationItem(STABLE_ANG, context.getString(R.string.stable_ang), new ArrayList<EvaluationItem>() {
                {
                    add(new BooleanEvaluationItem(NYHA_CCVS_CLASS_1, "NYHACCVS Class 1"));
                    add(new BooleanEvaluationItem(NYHA_CCVS_CLASS_2, "NYHACCVS Class 2"));
                    add(new BooleanEvaluationItem(NYHA_CCVS_CLASS_3, "NYHACCVS Class 3"));
                    add(new BooleanEvaluationItem(NYHA_CCVS_CLASS_4, "NYHACCVS Class 4"));
                }
            }));
            list.add(new BooleanEvaluationItem(LM, context.getString(R.string.lm)));
            list.add(new BooleanEvaluationItem(LAD, context.getString(R.string.lad)));
            list.add(new BooleanEvaluationItem(RCA, context.getString(R.string.rca)));
            list.add(new BooleanEvaluationItem(LCX, context.getString(R.string.lcx)));
            list.add(new SectionCheckboxEvaluationItem(ICD_10, context.getString(R.string.icd_10), new ArrayList<EvaluationItem>() {
                {
                    add(new BooleanEvaluationItem(CHRONIC_TOTAL_OCCLUSION, context.getString(R.string.chronic_total_occlusion)));
                    add(new BooleanEvaluationItem(CORONARY_ANEURYSM, context.getString(R.string.coronary_aneurysm)));
                    add(new BooleanEvaluationItem(CORONARY_DISSECTION, context.getString(R.string.coronary_dissection)));
                    add(new BooleanEvaluationItem(CALCIFIED_CORONARY_LESION, context.getString(R.string.calcified_coronary_lesion)));
                    add(new BooleanEvaluationItem(LIPID_RICH_PLAQUE, context.getString(R.string.lipid_rich_plaque)));
                    add(new BooleanEvaluationItem(DOCUMENTED_VASOSPASM, context.getString(R.string.documented_vasospasm)));
                }
            }));
            list.add(new NumericalEvaluationItem(VESSEL_MORE_50, context.getString(R.string.vessel_more_50), context.getString(R.string.value), 1, 3, true));
            list.add(new NumericalEvaluationItem(LVEF_CHD, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, true));
            return list;
        }
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add( new CoronaryHeartDisease(context));
                add(new SectionEvaluationItem(HEART_FAILURE, context.getString(R.string.heart_failure), new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(HF_DIAGNOSIS_DURATION_WEEK, "Duration / week", context.getString(R.string.value), 0, 999, true));
                        add(new BooleanEvaluationItem(PREVIOUS_HF_HOSPITALIZATION, context.getString(R.string.previous_hf_hospitalization)));
                        add(new BooleanEvaluationItem(S_P_ICD, "Status post AICD"));
                        add(new BooleanEvaluationItem(CRT_ICD, "Status post CRT"));
                        add(new NumericalEvaluationItem(LVEF, context.getString(R.string.lvef), context.getString(R.string.value), 10, 80, true));
                        add(new SectionEvaluationItem(NYHA_CLASS, "Heart Failure Class / Stage", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(AT_HIGH_RISK, context.getString(R.string.at_high_risk)));
                                add(new BooleanEvaluationItem(NO_SIGNS_OF_HF, context.getString(R.string.no_signs_of_hf)));
                                add(new BooleanEvaluationItem(SYMPTOMS_OF_HF, context.getString(R.string.symptoms_of_hf)));
                                add(new SectionCheckboxEvaluationItem(REFRACTORY_HF, context.getString(R.string.refractory_hf), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BoldEvaluationItem(CALCULATE_HFSS, context.getString(R.string.calculate_hfss)));
                                        add(new SectionCheckboxEvaluationItem(NO_SIGNIFICANT_COMORBIDITIES, context.getString(R.string.no_significant_comorbidities), new ArrayList<EvaluationItem>() {
                                            {
                                            }
                                        }) {
                                            {
                                                setShouldShowAlert(true);
                                            }
                                        });
                                        add(new NumericalEvaluationItem(VO_MAX_KG, context.getString(R.string.vo_max_kg), context.getString(R.string.value), 6, 40, true));
                                    }
                                }));

                            }
                        }, SectionElementState.OPENED) {
                            {
                                setHasStateIcon(false);
                            }
                        });
                        add(new EmptyCellEvaluationItem());
                        add(new BooleanEvaluationItem(IDIOPATHIC_DCM_NONISCHEMIC, context.getString(R.string.idiopathic_dcm_nonischemic)));
                        add(new SectionCheckboxEvaluationItem(POST_MI_MORE_45, context.getString(R.string.post_mi_more_45), new ArrayList<EvaluationItem>() {
                            {
                                new BooleanEvaluationItem(LV_ANEURYSM, context.getString(R.string.lv_aneurysm));
                            }
                        }));
                        add(new BooleanEvaluationItem(ISCHEMIC_POST_MI_LESS_45, context.getString(R.string.ischemic_post_mi_less_45)));
                        add(new BooleanEvaluationItem(CARDIOTOXINS, context.getString(R.string.cardiotoxins)));
                        add(new BooleanEvaluationItem(FAMILIAL_CMP, context.getString(R.string.familial_cmp)));
                        add(new BooleanEvaluationItem(MYOCARDITIS, "Myocarditis"));
                        add(new BooleanEvaluationItem(RV_DYSPLASIA, context.getString(R.string.rv_dysplasia)));
                        add(new SectionCheckboxEvaluationItem(HOCM, context.getString(R.string.hocm), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(LVH_MORE_30, context.getString(R.string.lvh_more_30)));
                                add(new BooleanEvaluationItem(ABNORMAL_BP_RESPONSE_TO_EXERCISE, context.getString(R.string.abnormal_bp_response_to_exercise)));
                                add(new BooleanEvaluationItem(HISTORY_OF_SUDDEN_DEATH, context.getString(R.string.history_of_sudden_death)));
                                add(new BooleanEvaluationItem(REST_DYNAMIC_PEAK, context.getString(R.string.rest_dynamic_peak)));
                            }
                        }));
                        add(new BooleanEvaluationItem(PERIPARTUM_CMP, context.getString(R.string.peripartum_cmp)));

                    }
                }, SectionElementState.OPENED))
                add(new SectionEvaluationItem(ATRIAL_FIBRILATION, context.getString(R.string.atrial_fibrilation), new ArrayList<EvaluationItem>() {
                    {

                        add(new EmptyCellEvaluationItem());
                        add(new BooleanEvaluationItem(CHRONIC_AF, context.getString(R.string.chronic_af)));
                        add(new BooleanEvaluationItem(PERSISTENT_AF, context.getString(R.string.persistent_af)));
                        add(new BooleanEvaluationItem(PAROXYMAL_AF, context.getString(R.string.paroxymal_af)));
                        add(new BooleanEvaluationItem(S_P_SUCCESSFUL_ABLATION, context.getString(R.string.s_p_successful_ablation)));
                        add(new BoldEvaluationItem(PLEASE_SELECT_ONE, context.getString(R.string.please_select_one)));
                        add(new RadioButtonGroupEvaluationItem(RHYTM_CONTROL, context.getString(R.string.rhytm_control), "radio_section", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionCheckboxEvaluationItem(CURRENT_ANIARRYTHMIC_THERAPY, context.getString(R.string.current_aniarrythmic_therapy), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(PROPOFONONE_FLECANIDE, context.getString(R.string.propofonone_flecanide)));
                                        add(new BooleanEvaluationItem(SOTALOL_AMIODARONE_MULTAQ_DOFETILIDE, context.getString(R.string.sotalol_amiodarone_multaq_dofetilide)));
                                    }
                                }));

                            }
                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(VENTRICULAR_RATE_CONTROL, context.getString(R.string.ventricular_rate_control), "radio_section", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(HEART_RATE_WITH_ACTIVITY, context.getString(R.string.heart_rate_with_activity), context.getString(R.string.value), 40, 300, true));
                            }
                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new EmptyCellEvaluationItem());
                        add(new SectionCheckboxEvaluationItem(SYMPTOMATIC, context.getString(R.string.symptomatic), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(ACUTELY, context.getString(R.string.acutely)));
                            }
                        }));


                        add(new NumericalEvaluationItem(DURATION_DAYS, context.getString(R.string.duration_days), context.getString(R.string.value), 0, 999, true));

                        add(new EmptyCellEvaluationItem());
                        add(new SectionCheckboxEvaluationItem(PREVIOUS_TIA_CVA, context.getString(R.string.previous_tia_cva), new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(LAST_THROMBOEMBOLIC_EVENT_MONTHS_AGO, context.getString(R.string.last_thromboembolic_event_months_ago), context.getString(R.string.value), 0, 600, true));
                            }
                        }));

                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem( THROMBOEMBOLIC_VKA, context.getString(R.string.thromboembolic_vka), new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem( THROMBOEMBOLIC_PREVENTION_VKA_THERAPY, "Thromboembolism / VKA ", new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(INR, context.getString(R.string.inr), context.getString(R.string.value), 0.5, 100, false));
                                add(new SectionCheckboxEvaluationItem(PATIENT_BLEED_RISK, "Patient related bleeding risk", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(ACTIVE_GASTRODUODENAL_ULCER, context.getString(R.string.active_gastroduodenal_ulcer)));
                                        add(new BooleanEvaluationItem(BLEED_IN_3_MO_BEFORE_ADMISSION, context.getString(R.string.bleed_in_3_mo_before_admission)));
                                        add(new BooleanEvaluationItem(PLATELET_COUNT_LESS_50, context.getString(R.string.platelet_count_less_50)));
                                        add(new BooleanEvaluationItem(ICU_OR_CCU_ADMISSION, context.getString(R.string.icu_or_ccu_admission)));
                                        add(new BooleanEvaluationItem(CENTRAL_VENOUS_CATHETER, context.getString(R.string.central_venous_catheter)));

                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(PROCEDURAL_BLEED_RISK, "Procedure related bleeding risk", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(PRIOR_BLEED_DURING_BRIDGING_SIMILAR, context.getString(R.string.prior_bleed_during_bridging_similar)));
                                        add(new BooleanEvaluationItem(PRIOR_ASA_USE, context.getString(R.string.prior_asa_use)));
                                        add(new BooleanEvaluationItem(RISK_NOT_CLINICALLY_IMPORTANT_LOW, context.getString(R.string.risk_not_clinically_important_low)));
                                        add(new BooleanEvaluationItem(RISK_UNCERTAIN, context.getString(R.string.risk_uncertain)));
                                        add(new BooleanEvaluationItem(RISK_INTERMEDIATE_HIGH, context.getString(R.string.risk_intermediate_high)));
                                    }
                                }));
                                add(new BooleanEvaluationItem(DEEP_VENOUS_THROMBOSIS, context.getString(R.string.deep_venous_thrombosis)));
                                add(new BooleanEvaluationItem(PULMONARY_EMBOLISM, context.getString(R.string.pulmonary_embolism)));
                                add(new SectionCheckboxEvaluationItem(DVY_PE_DIAGNOSIS_PREVENTION, "DVT diagnosis, prevention", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(MAJOR_SURGERY_TRAUMA, context.getString(R.string.major_surgery_trauma)));
                                        add(new BooleanEvaluationItem(MAJOR_GYN_UROLOGY, context.getString(R.string.major_gyn_urology)));
                                        add(new BooleanEvaluationItem(TKR, context.getString(R.string.tkr)));
                                        add(new BooleanEvaluationItem(THR, context.getString(R.string.thr)));
                                        add(new BooleanEvaluationItem(HIP_FRACTURE, context.getString(R.string.hip_fracture)));
                                        add(new BooleanEvaluationItem(SPINE_SURGERY, context.getString(R.string.spine_surgery)));
                                        add(new BooleanEvaluationItem(SPINAL_CORD_INJURY, context.getString(R.string.spinal_cord_injury)));
                                        add(new SectionCheckboxEvaluationItem(MEDICAL_ILLNESS, context.getString(R.string.medical_illness), new ArrayList<EvaluationItem>() {
                                            {


                                                add(new BooleanEvaluationItem(PAINFUL_DEEP_VENOUS_PALPATION_AND_EDEMA, context.getString(R.string.painful_deep_venous_palpation_and_edema)));
                                                add(new BooleanEvaluationItem(ACTIVE_CANCER, context.getString(R.string.active_cancer)));

                                                add(new BooleanEvaluationItem(RESPIRATORY_FAILURE, context.getString(R.string.respiratory_failure)));
                                                add(new BooleanEvaluationItem(ALREADY_KNOWN_THROMBOPHILIC_CONDITION, context.getString(R.string.already_known_thrombophilic_condition)));
                                                add(new BooleanEvaluationItem(RECENT_TRAUMA_SURGERY, context.getString(R.string.recent_trauma_surgery)));
                                                add(new BooleanEvaluationItem(REDUCED_MOBILITY, context.getString(R.string.reduced_mobility)));
                                                add(new BooleanEvaluationItem(ONGOING_HORMONAL_TREATMENT, context.getString(R.string.ongoing_hormonal_treatment)));
                                                add(new BooleanEvaluationItem(ACUTE_INFECTION_RHEUMATOLOGIC_DISORDER, "Active infection, rheumatologic disorder"));
                                            }
                                        }));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(ACUTE_CVA, context.getString(R.string.acute_cva), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(NIHSS, context.getString(R.string.nihss), context.getString(R.string.value), 0, 42, true));
                                        add(new BooleanEvaluationItem(UNILATERAL_WEAKNESS, context.getString(R.string.unilateral_weakness)));
                                        add(new BooleanEvaluationItem(SPEECH_DISTURBANCE, context.getString(R.string.speech_disturbance)));
                                        add(new NumericalEvaluationItem(DURATION_OF_SYMPTOMS, context.getString(R.string.duration_of_symptoms), context.getString(R.string.value), 0, 24, true));
                                        add(new BooleanEvaluationItem(PRE_HOSPITAL_CARE, context.getString(R.string.pre_hospital_care)));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(VALVULAR_HEART_DISEASE_THROMBOEMBOLIC, "Valvular heart disease ", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(MECHANICAL_CAGEBALL, context.getString(R.string.mechanical_cageball)));
                                add(new BooleanEvaluationItem(MECHANICAL_DISK_BILEAFLET_MITRAL, context.getString(R.string.mechanical_disk_bileaflet_mitral)));
                                add(new BooleanEvaluationItem(MECHANICAL_DISK_BILEAFLET_AORTIC, context.getString(R.string.mechanical_disk_bileaflet_aortic)));
                                add(new SectionCheckboxEvaluationItem(RHEUMATIC_MITRAL_VALVE_DISEASE, context.getString(R.string.rheumatic_mitral_valve_disease), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(LA_THROMBUS, context.getString(R.string.la_thrombus)));
                                        add(new NumericalEvaluationItem(LA_DIAMETER, context.getString(R.string.la_diameter), context.getString(R.string.value), 2, 7, true));
                                    }
                                }));
                                add(new BooleanEvaluationItem(BIOPROSTHETIC_VALVE, context.getString(R.string.bioprosthetic_valve)));
                                add(new BooleanEvaluationItem(SYSTEMIC_EMBOLISM, context.getString(R.string.systemic_embolism)));
                                add(new BooleanEvaluationItem(INFECTIVE_ENDROCARDITIS, context.getString(R.string.infective_endrocarditis)));
                                add(new BooleanEvaluationItem(LEFT_SIDED_PV_THROMBOSIS, context.getString(R.string.left_sided_pv_thrombosis)));
                                add(new BooleanEvaluationItem(RIGHT_SIDED_PV_THROMBOSIS, context.getString(R.string.right_sided_pv_thrombosis)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(CARDIAC_SOURCE_OF_EMBOLISM, context.getString(R.string.cardiac_source_of_embolism), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(NON_ACUTE_ARTERIAL_ISCHEMIC_STROKE, context.getString(R.string.non_acute_arterial_ischemic_stroke)) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                add(new BooleanEvaluationItem(AORTIC_ARCH_ATHEROSCLEROSIS, context.getString(R.string.aortic_arch_atherosclerosis)));
                                add(new BooleanEvaluationItem(LV_THROMBUS, context.getString(R.string.lv_thrombus)));
                                add(new BooleanEvaluationItem(PFO, context.getString(R.string.pfo)));
                                add(new BooleanEvaluationItem(MVP, context.getString(R.string.mvp)));
                                add(new BooleanEvaluationItem(MITRAL_ANNULAR_VALCIFICATION, context.getString(R.string.mitral_annular_valcification)));
                                add(new BooleanEvaluationItem(CALCIFIC_AORTIC_VALVE_DISEASE, context.getString(R.string.calcific_aortic_valve_disease)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(MISCELLANEOUS, context.getString(R.string.miscellaneous), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(HIT, context.getString(R.string.hit)));
                                add(new BooleanEvaluationItem(CEREBRAL_VENOUS_THROMBOSIS, context.getString(R.string.cerebral_venous_thrombosis)));
                                add(new BooleanEvaluationItem(HYPERCOAGULABLE_STATE, context.getString(R.string.hypercoagulable_state)));
                            }
                        }, SectionElementState.OPENED));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(VENTRICULAR_TACHYARRTHYMIAS, context.getString(R.string.ventricular_tachyarrthymias), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(NSVT, context.getString(R.string.nsvt)));
                        add(new BooleanEvaluationItem(MONOMORPHIC_VT, context.getString(R.string.monomorphic_vt)));
                        add(new BooleanEvaluationItem(REPETITIVE_MONOMORPHIC_VT, context.getString(R.string.repetitive_monomorphic_vt)));
                        add(new BooleanEvaluationItem(POLYMORPHIC_VT, context.getString(R.string.polymorphic_vt)));
                        add(new BooleanEvaluationItem(TORSADES, context.getString(R.string.torsades)));
                        add(new BooleanEvaluationItem(INCESSANT_VT, context.getString(R.string.incessant_vt)));
                        add(new BooleanEvaluationItem(IDIOPATHIC_VT, context.getString(R.string.idiopathic_vt)));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionEvaluationItem(BRADYARRTHYMIA_SYNCOPE, context.getString(R.string.bradyarrthymia_syncope), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(SYMPTOMATIC_SINUS_NODE_DYSFUNCTION, context.getString(R.string.symptomatic_sinus_node_dysfunction)));
                        add(new BooleanEvaluationItem(HIGH_GRADE_AV_NODE_DISEASE, context.getString(R.string.high_grade_av_node_disease)));
                        add(new BooleanEvaluationItem(ISOLATED_NEUROCARDIOGENIC_UNEXPLAINED_SYNCOPE, context.getString(R.string.isolated_neurocardiogenic_unexplained_syncope)));
                        add(new BooleanEvaluationItem(CAROTID_SINUS_HYPERSENSITIVITY, context.getString(R.string.carotid_sinus_hypersensitivity)));
                        add(new BooleanEvaluationItem(POTS, context.getString(R.string.pots)));
                        add(new BooleanEvaluationItem(AUTONOMIC_FAILURE_SYNDROME, context.getString(R.string.autonomic_failure_syndrome)));
                        add(new BooleanEvaluationItem(HISTORY_OF_CARDIAC_ARREST, context.getString(R.string.history_of_cardiac_arrest)));
                        add(new BooleanEvaluationItem(BRUGADA_SYNDROME, context.getString(R.string.brugada_syndrome)));
                        add(new BooleanEvaluationItem(LONG_QT, context.getString(R.string.long_qt)));
                        add(new BooleanEvaluationItem(SARCOIDOSIS_GIANT_CELL_CHAGAS, context.getString(R.string.sarcoidosis_giant_cell_chagas)));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionCheckboxEvaluationItem(VALVULAR_HEART_DISEASE, context.getString(R.string.valvular_heart_disease), new ArrayList<EvaluationItem>(){}) {
                    {
                        setShouldShowAlert(true);
                    }
                });
                add(new SectionEvaluationItem(PULMONARY_HYPERTENSION, context.getString(R.string.pulmonary_hypertension), new ArrayList<EvaluationItem>() {
                    {
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setShouldShowAlert(true);
                    }
                });
                add(new SectionEvaluationItem(VASCULAR_DISEASES, context.getString(R.string.vascular_diseases), new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem( SYMPTOMATIC_CAROTID_DISEASE, context.getString(R.string.symptomatic_carotid_disease), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(NONCARDIOEMBOLIC_VCA_TIA, "Noncardioembolic CVA associated with Carotid Plaque"));
                                add(new BooleanEvaluationItem(NONCARDIOEMBOLIC_TIA, "Noncardioembolic TIA associated with Carotid Plaque"));
                                add(new BooleanEvaluationItem(MORE_50_CAROTID_STENOSIS, context.getString(R.string.more_50_carotid_stenosis)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(PERIPHERIC_VASCULAR_DISEASE, context.getString(R.string.peripheric_vascular_disease), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(ABI_LESS_09, context.getString(R.string.abi_less_09)));
                                add(new BooleanEvaluationItem(CLAUDICATION, context.getString(R.string.claudication)));
                                add(new BooleanEvaluationItem(CRITICAL_LIMB_ISCHEMIA, context.getString(R.string.critical_limb_ischemia)));
                                add(new BooleanEvaluationItem(ENDOVASCULAR_REVASCULARIZATION, context.getString(R.string.endovascular_revascularization)));
                                add(new BooleanEvaluationItem(PERIPHERAL_ARTERY_BYPASS_GRAFT, context.getString(R.string.peripheral_artery_bypass_graft)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(ABDOMINAL_AORTIC_ANEURYSM, "Aortic Aneurysm", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(AA_DIAMETER_MORE_5, context.getString(R.string.aa_diameter_more_5)));
                                add(new BooleanEvaluationItem(THORACIC, "Thoracic Aortic Aneurysm "));
                                add(new BooleanEvaluationItem(THORACIC_ABDOMINAL, "Thoracoabdominal Aortic Aneurysm"));
                            }
                        }, SectionElementState.OPENED));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
            }
        };
    }
}
