package com.szg_tech.cvdevaluator.fragments.output;

import androidx.recyclerview.widget.RecyclerView;

import com.szg_tech.cvdevaluator.core.MVPView;

interface OutputView extends MVPView {
    RecyclerView getRecyclerView();

}
