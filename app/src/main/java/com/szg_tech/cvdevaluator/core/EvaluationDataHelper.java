package com.szg_tech.cvdevaluator.core;

import android.content.Context;
import android.support.annotation.Nullable;

import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_items.Evaluation;
import com.szg_tech.cvdevaluator.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationDataHelper {

    // TODO Refactor this to be reusable (extract?)
    public static HashMap<String, Object> createValuesDump(ArrayList<EvaluationItem> evaluationItems) {
        HashMap<String, Object> valuesDump = new HashMap<>();
        for (EvaluationItem item : evaluationItems) {
            valuesDump.put(item.getId(), item.getValue());
        }
        return valuesDump;
    }

    public static Evaluation createHomeScreenData(Context context){
        Evaluation evaluation = new Evaluation(context);
        HashMap<String, Object>  valueHashMap = EvaluationDAO.getInstance().loadValues();
        if (!valueHashMap.isEmpty()) {
            recursiveFillSection(evaluation, valueHashMap);
        }
        return evaluation;
    }

    public static EvaluationItem fetchEvaluationItemById(String id, Context context){
        Evaluation evaluation = new Evaluation(context);
        return fetchItemFromEvaluation(id, evaluation);
    }

    public static EvaluationItem fetchItemFromEvaluation(String id,Evaluation evaluation ){
        EvaluationItem item = recursiveFetch(evaluation, id);
        // fill section with data
        if(item!=null){
            HashMap<String, Object>  valueHashMap = EvaluationDAO.getInstance().loadValues();
            if (!valueHashMap.isEmpty()) {
                recursiveFillSection(item, valueHashMap);
            }
        }
        return item;
    }

    public static EvaluationItem recursiveFetch(EvaluationItem item, String id){
        ArrayList<EvaluationItem> evaluationItems = item.getEvaluationItemList();
        if (evaluationItems != null) {
            for (EvaluationItem evaluationItem : evaluationItems) {
                if (id.equals(evaluationItem.getId())) {
                    return evaluationItem;
                } else {
                    EvaluationItem nestedResult = recursiveFetch(evaluationItem, id);
                    if(nestedResult!=null){
                        return nestedResult;
                    }
                }
            }
        }
        return null;
    }

    public static ArrayList<SectionEvaluationItem> getNextSectionItems(@Nullable List<String> ids, Context context){
        ArrayList<SectionEvaluationItem> items = new ArrayList<>();
        if(ids!=null) {
            Evaluation evaluation = new Evaluation(context);
            for (String id : ids) {
                SectionEvaluationItem sectionEvaluationItem = (SectionEvaluationItem) fetchItemFromEvaluation(id, evaluation);
                if (sectionEvaluationItem != null) {
                    items.add(sectionEvaluationItem);
                }
            }
        }
        return items;
    }

    public static void recursiveFillSection(EvaluationItem tempEvaluationItem, Map<String, Object> valueHashMap) {
        ArrayList<EvaluationItem> evaluationItems = tempEvaluationItem.getEvaluationItemList();
        if (evaluationItems != null) {
            for (EvaluationItem evaluationItem : evaluationItems) {
                Object value = valueHashMap.get(evaluationItem.getId());
                if (value != null) {
                    evaluationItem.setValue(value);
                }
                recursiveFillSection(evaluationItem, valueHashMap);
            }
        }
    }
}
