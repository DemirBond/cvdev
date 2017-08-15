package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.ConfigurationParams;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.MinutesSecondsEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class Symptoms extends SectionEvaluationItem {
    Symptoms(Context context) {
        super(context, ConfigurationParams.SYMPTOMS, null, false);
        name = context.getString(R.string.symptoms);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        this.dependsOn = ConfigurationParams.BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.DYSPNEA, context.getString(R.string.dyspnea), false, new ArrayList<EvaluationItem>() {
                    {

                        add(new BoldEvaluationItem(context, ConfigurationParams.PLEASE_SELECT_ONE, context.getString(R.string.please_select_one), true));
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.CHRONIC_HF, context.getString(R.string.chronic_hf), ConfigurationParams.PLEASE_SELECT_ONE, false, false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(context, ConfigurationParams.NEW_HF, context.getString(R.string.new_hf), ConfigurationParams.PLEASE_SELECT_ONE, false, false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });

                        add(new EmptyCellEvaluationItem());
                        add(new BooleanEvaluationItem(context, ConfigurationParams.OUTPATIENT, "Ambulatory / Outpatient", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.EMERGENCY_ROOM, "Worsening / Emergency room ", false));

                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.IN_HOSPITAL, "Decompensated/ Hospitalized", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.DAY1, " Day 1", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.DAY2, " Day 2", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.DAY3, " Day 3", false));
                            }
                        }));


                        add(new EmptyCellEvaluationItem());


                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.DYSPNEA_ON_EXERTION, "Dyspnea on exertion", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.STRENUOUS_EXERTION, context.getString(R.string.strenuous_exertion), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MORE_THAN_DAILY_ROUTINE, context.getString(R.string.more_than_daily_routine), false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.DAILY_ROUTINE_MINIMAL_ACTIVITIES, context.getString(R.string.daily_routine_minimal_activities), false));
                            }

                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_1, "NYHA class 1", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_2, "NYHA class 2", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_3, "NYHA class 3 ", false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.DYSPNEA_AT_REST, "Dyspnea at rest", false, new ArrayList<EvaluationItem>() {

                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NYHA_CCVS_CLASS_4, "NYHA class 4", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.WEIGHT_GAIN, "WEIGHT GAIN", false));


                    }



                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CHEST_PAIN, context.getString(R.string.chest_pain), false, new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.EMERGENCY_ROOM_CP, context.getString(R.string.emergency_room), false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TWO_TYPICAL_OR_PROBABLE_ANGINA, "More than 2 typical or probable angina episodes", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.TYPICAL_OR_PROBABLE_ANGINA_MORE_20_MIN, "Typical or probable angina lasting more than 20min", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ASA_USE_IN_PAST_1_WEEK, "ASA use in the past 1 week", false));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.POSITIVE_TROPONIN, context.getString(R.string.positive_troponin), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TROPONIN_X_MORE_3_ABOVE_NORMAL, "Troponin 3 times above normal", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TROPONIN_1_3_ABOVE_NORMAL, "Troponin 1 to 3 times above normal", false));
                                    }
                                }));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.TYPICAL_ANGINA_NEW, "Typical angina", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ESCALATING_IN_FREQUENCY, "Escalating in frequency, duration oer severity", false));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.PROBABLY_ANGINA_NEW, "Probable angina", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ESCALATING_IN_FREQUENCY, "Escalating in frequency, duration oer severity", false));
                            }
                        }));



                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.UNDETERMINED_CP_NEW, "Undetermined chest pain", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SIDE_HEMITHORAX, context.getString(R.string.side_hemithorax), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BoldEvaluationItem(context, ConfigurationParams.QUALITY, context.getString(R.string.quality), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SHARP, context.getString(R.string.sharp), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRESSURE, context.getString(R.string.pressure), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TIGHTNESS, context.getString(R.string.tightness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SORENESS, context.getString(R.string.soreness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HEAVINESS, context.getString(R.string.heaviness), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.AGGRAVATED_BY, context.getString(R.string.aggravated_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING, context.getString(R.string.lying), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BREATHING, context.getString(R.string.breathing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.COUGHING, context.getString(R.string.coughing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXERTION, context.getString(R.string.exertion), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALPATION, context.getString(R.string.palpation), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RELIEVED_BY, context.getString(R.string.relieved_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NTG, context.getString(R.string.ntg), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.REST, context.getString(R.string.rest), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SITTING_UP, context.getString(R.string.sitting_up), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING_ON_SIDE, context.getString(R.string.lying_on_side), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANALGESICS, context.getString(R.string.analgesics), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RADIATION, context.getString(R.string.radiation), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.JAW, context.getString(R.string.jaw), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BACK, context.getString(R.string.back), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ARM, context.getString(R.string.arm), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.ASSOCIATED_WITH, "Associated with", false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_CP, context.getString(R.string.dyspnea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NAUSEA, context.getString(R.string.nausea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIAPHORESIS, context.getString(R.string.diaphoresis), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAINTNESS, context.getString(R.string.faintness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPPALPITATIONS, "CPPalpitations", false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.LASTING, "Lasting", false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPSECONDS, "Seconds", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPMINUTES, "Minutes", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPHOURS, "Hours", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPCONSTANT, "Constant", false));


                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.INTERCOSTAL_CP, context.getString(R.string.intercostal_cp), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BoldEvaluationItem(context, ConfigurationParams.QUALITY, context.getString(R.string.quality), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SHARP, context.getString(R.string.sharp), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRESSURE, context.getString(R.string.pressure), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TIGHTNESS, context.getString(R.string.tightness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SORENESS, context.getString(R.string.soreness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HEAVINESS, context.getString(R.string.heaviness), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.AGGRAVATED_BY, context.getString(R.string.aggravated_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING, context.getString(R.string.lying), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BREATHING, context.getString(R.string.breathing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.COUGHING, context.getString(R.string.coughing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXERTION, context.getString(R.string.exertion), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALPATION, context.getString(R.string.palpation), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RELIEVED_BY, context.getString(R.string.relieved_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NTG, context.getString(R.string.ntg), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.REST, context.getString(R.string.rest), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SITTING_UP, context.getString(R.string.sitting_up), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING_ON_SIDE, context.getString(R.string.lying_on_side), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANALGESICS, context.getString(R.string.analgesics), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RADIATION, context.getString(R.string.radiation), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.JAW, context.getString(R.string.jaw), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BACK, context.getString(R.string.back), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ARM, context.getString(R.string.arm), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.ASSOCIATED_WITH, context.getString(R.string.associated_with), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_CP, context.getString(R.string.dyspnea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NAUSEA, context.getString(R.string.nausea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIAPHORESIS, context.getString(R.string.diaphoresis), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAINTNESS, context.getString(R.string.faintness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPPALPITATIONS, "CPPalpitations", false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.LASTING, "Lasting", false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPSECONDS, "Seconds", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPMINUTES, "Minutes", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPHOURS, "Hours", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPCONSTANT, "Constant", false));

                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.CENTRAL_PRECORDIAL_CP, context.getString(R.string.central_precordial_cp), false, new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BoldEvaluationItem(context, ConfigurationParams.QUALITY, context.getString(R.string.quality), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SHARP, context.getString(R.string.sharp), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PRESSURE, context.getString(R.string.pressure), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.TIGHTNESS, context.getString(R.string.tightness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SORENESS, context.getString(R.string.soreness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.HEAVINESS, context.getString(R.string.heaviness), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.AGGRAVATED_BY, context.getString(R.string.aggravated_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING, context.getString(R.string.lying), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BREATHING, context.getString(R.string.breathing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.COUGHING, context.getString(R.string.coughing), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXERTION, context.getString(R.string.exertion), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALPATION, context.getString(R.string.palpation), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RELIEVED_BY, context.getString(R.string.relieved_by), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NTG, context.getString(R.string.ntg), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.REST, context.getString(R.string.rest), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.SITTING_UP, context.getString(R.string.sitting_up), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.LYING_ON_SIDE, context.getString(R.string.lying_on_side), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANALGESICS, context.getString(R.string.analgesics), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.RADIATION, context.getString(R.string.radiation), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.JAW, context.getString(R.string.jaw), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.BACK, context.getString(R.string.back), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.ARM, context.getString(R.string.arm), false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.ASSOCIATED_WITH, context.getString(R.string.associated_with), false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DYSPNEA_CP, context.getString(R.string.dyspnea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.NAUSEA, context.getString(R.string.nausea), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIAPHORESIS, context.getString(R.string.diaphoresis), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.FAINTNESS, context.getString(R.string.faintness), false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPPALPITATIONS, "CPPalpitations", false));

                                        add(new BoldEvaluationItem(context, ConfigurationParams.LASTING, "Lasting", false) {
                                            {
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPSECONDS, "Seconds", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPMINUTES, "Minutes", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPHOURS, "Hours", false));
                                        add(new BooleanEvaluationItem(context, ConfigurationParams.CPCONSTANT, "Constant", false));

                                    }
                                }));
                            }
                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.UNABLE_TO_EXERCISE, context.getString(R.string.unable_to_exercise), false));

                    }

                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SYNCOPE_PRESYNCOPE, " Presyncope / Syncope / Seizure", false, new ArrayList<EvaluationItem>() {

                    {
                        add(new BoldEvaluationItem(context, ConfigurationParams.CIRCUMSTANCE, context.getString(R.string.circumstance), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.UPRIGHT_POSITION, context.getString(R.string.upright_position), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SUDDEN_NOISE, context.getString(R.string.sudden_noise), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NECK_MOVEMENT_MANIPULATION, context.getString(R.string.neck_movement_manipulation), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXERTIONAL, context.getString(R.string.exertional), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SPORADIC, "Sporadic", false));

                        add(new BoldEvaluationItem(context, ConfigurationParams.PRODROMAL_SYMPTOMS, context.getString(R.string.prodromal_symptoms), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NAUSEA_SYN, context.getString(R.string.nausea), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIZZINESS, context.getString(R.string.dizziness), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SYNPALPITATIONS, context.getString(R.string.palpitations), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SYNCHEST_PAIN, context.getString(R.string.chest_pain), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.AURA, context.getString(R.string.aura), false));

                        add(new BoldEvaluationItem(context, ConfigurationParams.SYNCOPE_DURATION_DURING_SYNCOPE, context.getString(R.string.syncope_duration_during_syncope), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });

                        add(new NumericalEvaluationItem(context, ConfigurationParams.MINUTES_SYN_DUR,"Minutes", "Value", 0, 10, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.SECONDS_SYN_DUR,"Seconds", "Value", 0, 300, false, true));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CYANOSIS, context.getString(R.string.cyanosis), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALLOR_DIAPHORESIS, context.getString(R.string.pallor_diaphoresis), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.UNUSUAL_POSTURE, context.getString(R.string.unusual_posture), false));

                        add(new BoldEvaluationItem(context, ConfigurationParams.POSTICTAL_SYMPTOMS, context.getString(R.string.postictal_symptoms), false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DISORIENTATION, context.getString(R.string.disorientation), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PARALYSIS, context.getString(R.string.paralysis), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.CHEST_PAIN_POS_CP, context.getString(R.string.chest_pain), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PROLONGED_FATIGUE, context.getString(R.string.prolonged_fatigue), false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.TRAUMATIC_INJURY, context.getString(R.string.traumatic_injury), false));
                    }




                 }));

                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SYMEDEMA, "Edema", false, new ArrayList<EvaluationItem>() {

                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PITTING, " Pitting", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.NONPITTING, " Nonpitting", false));

                    }
                    {add(new EmptyCellEvaluationItem());}
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.LOCALIZED, " Localized", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.DIFFUSE, " Diffuse", false));

                    }

                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.WEAKNESS, "Weakness", false, new ArrayList<EvaluationItem>() {

                    {add(new BooleanEvaluationItem(context, ConfigurationParams.MALAISE, "Malaise / Fatigue", false));}
                }));

                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SYMPALPITATIONS, "Palpitations", false, new ArrayList<EvaluationItem>() {

                    {
                        add(new BoldEvaluationItem(context, ConfigurationParams.PAL_FREQUENCY, "Frequency", false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALDAY, "Daily", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALWEEK, "Weekly", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALMONTH, "Monthly", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PALYEAR, "Yearly", false));

                        add(new BoldEvaluationItem(context, ConfigurationParams.PAL_TYPE, "Type", false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.EXTRASYSTOLIC, "Extrasystolic", false));
                        add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.TACHYCARDIC, "Tachycardic", false, new ArrayList<EvaluationItem>() {


                            {
                                add(new BoldEvaluationItem(context, ConfigurationParams.VAGAL, "Reaction to vagal manuever", false) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });


                                add(new BooleanEvaluationItem(context, ConfigurationParams.VAGAL_ABRUPT, "Abrupt termination", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.VAGAL_GRADUAL, "Gradual termination", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.VAGAL_NORESPONSE, "No response", false));
                            }

                        }));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ANXIETY, "Anxiety", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PULSATION, "Strong pulsation ", false));


                        add(new BoldEvaluationItem(context, ConfigurationParams.SYMPTOM_DURATION, "Symptom duration", false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });

                        add(new NumericalEvaluationItem(context, ConfigurationParams.SECONDS_PAL_DUR,"Seconds", "Value", 0, 60, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.MINUTES_PAL_DUR,"Minutes", "Value", 0, 60, false, true));
                        add(new NumericalEvaluationItem(context, ConfigurationParams.HOURS_PAL_DUR,"Hours", "Value", 0, 300, false, true));


                        add(new BoldEvaluationItem(context, ConfigurationParams.PAL_SYMPTOMS, "Associated symptoms", false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_SYNCOPE, "Syncope", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_ANGINA, "Angina", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_POLYURIA, "Polyuria", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_NECK, "Pulsations in neck", false));

                        add(new BoldEvaluationItem(context, ConfigurationParams.PAL_EKG, "EKG during symptoms", false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_NSR, "Normal sinus rhtym", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_REGRR, "Regular RR, other than sinus ", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_IRREGRR, "Irregular RR, other than sinus", false));


                        add(new BoldEvaluationItem(context, ConfigurationParams.PAL_ONSET, "Onset, trigger", false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_SUDDEN, "Normal sinus rhtym", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_POSITION, "Regular RR, other than sinus ", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_EXERTION, "Irregular RR, other than sinus", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PAL_POSTEXERTION, "Irregular RR, other than sinus", false));
                    }




                }));







                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.ABDOMINAL, "Abdominal pain", false, new ArrayList<EvaluationItem>() {
                    {

                                add(new BoldEvaluationItem(context, ConfigurationParams.PAIN_QUALITY, "Quality", false) {
                                    {
                                     setBackgroundHighlighted(true);
                                    }
                                 });
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ABSHARP, "Sharp", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ABCOLIC, "Colicky", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ABACHING, "Aching or muscle spasm", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.SORENESS, context.getString(R.string.soreness), false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.HEAVINESS, context.getString(R.string.heaviness), false));

                                add(new BoldEvaluationItem(context, ConfigurationParams.PAIN_LOCATION, "Location ", false) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PERIUMBILICAL, "Periumbilical", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.EPIGASTRIC, "Epigastric", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.SUPRAPUBIC, "Suprapubic", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ABSPASM," Referred ", false));
                                //add(new BooleanEvaluationItem(context, ConfigurationParams.PALPATION, context.getString(R.string.palpation), false));

                                add(new BoldEvaluationItem(context, ConfigurationParams.ASSOCIATED_FINDINGS, "Associated findings", false) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                add(new BooleanEvaluationItem(context, ConfigurationParams.DISTENTION, "Distention", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.REBOUND, "Rebound tenderness", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PULSATILE, "Pulsatile mass", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BOWELSOUNDS, "Abnormal bowel sounds", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MCBURNEY, "McBurney sign", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.MURPHY, "Murphy sign", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.PSAOS, "Psaos sign", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ROVSING, "Rovsing sign", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.OBTURATOR, "Obturator sign", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.CARNETT, "Carnett sign", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.COSTOVERTEBRAL, "Costovertebral tendernesss", false));
                                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SKIN, "Skin findings", false, new ArrayList<EvaluationItem>() {
                                      {
                                          add(new BooleanEvaluationItem(context, ConfigurationParams.HERPES, "Herpes", false));
                                          add(new BooleanEvaluationItem(context, ConfigurationParams.CELULITIS, "Celulitis", false));
                                          add(new BooleanEvaluationItem(context, ConfigurationParams.ECHYMOSIS, "Flank or periumbilical echymosis", false));
                                          add(new BooleanEvaluationItem(context, ConfigurationParams.CAPUT, "Caput medusa", false));
                                          //add(new BooleanEvaluationItem(context, ConfigurationParams.ICTERUS, "Icterus", false));
                                          add(new BooleanEvaluationItem(context, ConfigurationParams.HENOCH, "Purpura ", false));
                                      }
                                 }));
                                add(new BoldEvaluationItem(context, ConfigurationParams.ASSOCIATED_SYMPTOMS, "Associated symptoms", false) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });



                               add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.VOMITING, "Vomiting", false, new ArrayList<EvaluationItem>() {
                                  {
                                  add(new BooleanEvaluationItem(context, ConfigurationParams.VOMITING_FIRST, "Vomiting precedes pain", false));
                                  add(new BooleanEvaluationItem(context, ConfigurationParams.PAIN_FIRST, "Pain precedes vomiting", false));

                                   }
                                 }));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.ANOREXIA, "Anorexia", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.BOWEL, "Change in bowel habits", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.POSTOPERATIVE, "Post operative status", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.FAMILY_HISTORYAA, "Family history of AAA", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.OBGYN, "Ob gyn history", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.HEMATURIA, "Hematuria", false));
                                add(new BooleanEvaluationItem(context, ConfigurationParams.URINARY, "Change in urinary habit", false));




                    }
                }));
                add(new SectionCheckboxEvaluationItem(context, ConfigurationParams.SHOCK, "Shock", false, new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(context, ConfigurationParams.HYPOVOLEMIA, "Hypovolemia", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.INFECTIOUS, "Infectious", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.SPINALCORD, "Spinal cord", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.ALLERGIC, "Allergic", false));
                        add(new BooleanEvaluationItem(context, ConfigurationParams.PHARMACOLOGIC, "Pharmacologic", false));

                    }
                }));
            }
        };
    }
}
