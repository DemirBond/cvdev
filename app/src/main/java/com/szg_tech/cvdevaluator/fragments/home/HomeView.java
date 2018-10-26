package com.szg_tech.cvdevaluator.fragments.home;

import androidx.recyclerview.widget.RecyclerView;

import com.szg_tech.cvdevaluator.core.MVPView;

interface HomeView extends MVPView {
    RecyclerView getRecyclerView();
}
