package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class PhysicalExam extends SectionEvaluationItem {
    PhysicalExam(Context context) {
        super(PHYSICAL_EXAM, null);
        name = context.getString(R.string.physical_exam);
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new BooleanEvaluationItem(NECK_VEINS, "Neck veins not assessable"));
                add(new BooleanEvaluationItem(JUGULAR_VENOUS_DISTENTION, "Jugular venous distention"));
                add(new BooleanEvaluationItem(CAROTID_BRUIT, "Carotid bruit"));
                add(new BooleanEvaluationItem(DISPLACED_PMI, context.getString(R.string.displaced_pmi)));
                add(new BooleanEvaluationItem(LEFT_SIDED_S3, "Left sided S3 gallop"));
                add(new BooleanEvaluationItem(LEFT_SIDED_S4, "Left sided S4 gallop"));
                add(new BooleanEvaluationItem(FRICTION_RUB, context.getString(R.string.friction_rub)));
                add(new BooleanEvaluationItem(DISTANT, "Distant heart sounds"));
                add(new SectionCheckboxEvaluationItem(HEART_MURMUR, "Murmur, pathological heart sounds", new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(FOCUS_ON_THE_MOST_ABNORMAL_AUSCULTATION_FOCI, "Please enter the area murmur is most prominent "));
                        add(new SectionCheckboxEvaluationItem(SI_MITRAL, context.getString(R.string.si_mitral), new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(LOUD_S1_MITRAL, context.getString(R.string.loud), SI_MITRAL, false));
                                add(new RadioButtonGroupEvaluationItem(NORMAL_S1_MITRAL, context.getString(R.string.normal), SI_MITRAL, false));
                                add(new RadioButtonGroupEvaluationItem(SOFT_SI_MITRAL, context.getString(R.string.soft), SI_MITRAL, false));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(S2_AORTIC, context.getString(R.string.s2_aortic), new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(LOUD_S2_AORTIC, context.getString(R.string.loud), S2_AORTIC, false));
                                add(new RadioButtonGroupEvaluationItem(NORMAL_S2_AORTIC, context.getString(R.string.normal), S2_AORTIC, false));
                                add(new RadioButtonGroupEvaluationItem(SOFT_S2_AORTIC, context.getString(R.string.soft), S2_AORTIC, false));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(P2_PULMONIC, context.getString(R.string.p2_pulmonic), new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(LOUD_P2_PULMONIC, context.getString(R.string.loud), P2_PULMONIC, false));
                                add(new RadioButtonGroupEvaluationItem(NORMAL_P2_PULMONIC, context.getString(R.string.normal), P2_PULMONIC, false));
                                add(new RadioButtonGroupEvaluationItem(SOFT_P2_PULMONIC, context.getString(R.string.soft), P2_PULMONIC, false));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(S1_TRICUSPID, context.getString(R.string.s1_tricuspid), new ArrayList<EvaluationItem>() {
                            {
                                add(new RadioButtonGroupEvaluationItem(LOUD_S1_TRICUSPID, context.getString(R.string.loud), S1_TRICUSPID, false));
                                add(new RadioButtonGroupEvaluationItem(NORMAL_S1_TRICUSPID, context.getString(R.string.normal), S1_TRICUSPID, false));
                                add(new RadioButtonGroupEvaluationItem(SOFT_S1_TRICUSPID, context.getString(R.string.soft), S1_TRICUSPID, false));
                            }
                        }));
                        add(new SectionEvaluationItem(MURMUR, "Murmur characteristics", new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionCheckboxEvaluationItem(SYSTOLIC_MURMUR, context.getString(R.string.systolic_murmur), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new SectionCheckboxEvaluationItem(CRESCENDO_DECRESCENDO, context.getString(R.string.crescendo_decrescendo), new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(EARLY_MID_SYSTOLIC_PEAKING, context.getString(R.string.early_mid_systolic_peaking)));
                                                add(new BooleanEvaluationItem(LATE_SYSTOLIC_PEAKING, context.getString(R.string.late_systolic_peaking)));
                                            }
                                        }));
                                        add(new SectionCheckboxEvaluationItem(PLATEAU_SHAPED, context.getString(R.string.plateau_shaped), new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(HALOSYSTOLIC, context.getString(R.string.halosystolic)));
                                                add(new BooleanEvaluationItem(PANSYSTOLIC, context.getString(R.string.pansystolic)));
                                                add(new BooleanEvaluationItem(MIDSYSTOLIC, context.getString(R.string.midsystolic)));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(SOFTER_WITH_SQUAT, context.getString(R.string.softer_with_squat)));
                                        add(new BooleanEvaluationItem(EJECTION_SOUND, "Ejection sound"));
                                        add(new BooleanEvaluationItem(SYSTOLIC_CLICK, "Systolic click"));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(DIASTOLIC_MURMUR, context.getString(R.string.diastolic_murmur), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(DECRESCENDO, context.getString(R.string.decrescendo)));
                                        add(new BooleanEvaluationItem(RUMBLE, context.getString(R.string.rumble)));
                                        add(new BooleanEvaluationItem(MITRAL_OPENING_SNAP, context.getString(R.string.mitral_opening_snap)));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED) {
                            {
                                setHasStateIcon(false);
                            }
                        });

                    }
                }));
                add(new BooleanEvaluationItem(NEW_RALES, context.getString(R.string.new_rales)));
                add(new BooleanEvaluationItem(PULMONARY_EDEMA, "Diffuse mixed ralles"));
                add(new BooleanEvaluationItem(DIMINISHED_BREATH_SOUNDS, context.getString(R.string.diminished_breath_sounds)));
                add(new BooleanEvaluationItem(DRY_RALES, "Dry rales"));
                add(new BooleanEvaluationItem(PERCUSSION, "Abnormal resonance to percussion"));
                add(new BooleanEvaluationItem(INCREASED_THORAX_DIAMETER, "Increased thorax AP diameter"));

                add(new BooleanEvaluationItem(ABDOMINAL_TENDERNESS, context.getString(R.string.abdominal_tenderness)));
                add(new BooleanEvaluationItem(HJR, "Hepato jugular reflux"));
                add(new BooleanEvaluationItem(ASCITES, "Ascites"));
                add(new BooleanEvaluationItem(ANY_CNS_SYMPTOMS, context.getString(R.string.any_cns_symptoms)));
                add(new SectionCheckboxEvaluationItem(SYMCYANOSIS, "Cyanosis", new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CENTRAL, "Central cyanosis"));
                        add(new BooleanEvaluationItem(PERIPHERAL, "Peripheral cyanosis"));

                    }
                }));

                add(new BooleanEvaluationItem(COLD_CLAMMY_EXTERMITIES, context.getString(R.string.cold_clammy_extermities)));
                add(new BooleanEvaluationItem(CLUBBING, "Clubbing"));
                add(new BooleanEvaluationItem(ICTERUS, "Jaundice"));
                add(new BooleanEvaluationItem(EDEMA, context.getString(R.string.edema)));
                add(new BooleanEvaluationItem(ABSENTR, "Abnormal right LE pulse"));
                add(new BooleanEvaluationItem(ABSENTL, "Abnormal left LE pulse"));
                add(new BooleanEvaluationItem(ABBRUIT, "Abdominal bruit"));
                add(new NumericalEvaluationItem(DIFFERENCE_IN_SBP, context.getString(R.string.difference_in_sbp), context.getString(R.string.value), 0, 50, true));
            }
        };
    }
}
