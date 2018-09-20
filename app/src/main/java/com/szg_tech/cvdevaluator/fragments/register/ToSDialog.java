package com.szg_tech.cvdevaluator.fragments.register;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;

import com.szg_tech.cvdevaluator.R;

public class ToSDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(Html.fromHtml(getResources().getString(R.string.terms_of_use_text)))
                .setPositiveButton(R.string.accept, (dialog, id) -> {
                    // TODO - Store that user accepted ToS
                })
                .setNegativeButton(R.string.cancel, (dialog, id) -> {
                    // User cancelled the dialog
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}