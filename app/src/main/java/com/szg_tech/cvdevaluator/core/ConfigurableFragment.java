package com.szg_tech.cvdevaluator.core;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class ConfigurableFragment extends Fragment implements MVPView {
    @Override
    public Presenter createPresenter() {
        return null;
    }

    @Override
    public void startActivity(Class<? extends Activity> activityClass) {
        Activity activity = getActivity();
        if (activity instanceof MVPView) {
            ((MVPView) activity).startActivity(activityClass);
        } else {
            if (activity != null) {
                activity.startActivity(new Intent(activity, activityClass));
            }
        }
    }
}
