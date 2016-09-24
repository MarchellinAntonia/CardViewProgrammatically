package com.example.chellin.cardviewprogrammatically;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by chellin on 21/09/16.
 */
public class AlertDialogHelper {
    private Context context;

    public AlertDialogHelper(Context context) {
        this.context = context;
    }

    public void show(String msg){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(msg);
        alertDialogBuilder.setNeutralButton("OK", null).create().show();
    }
}
