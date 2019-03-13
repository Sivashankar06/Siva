package hobby.siva.smsapplication.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/*
 * Copyright (c) 2019 Blue Jeans Network, Inc. All rights reserved.
 * Created by sarumugam on 12/03/19
 */
public class AlertUtil {

    public static void showAlert(Activity context, String title, String message){
        AlertDialog.Builder alertDlgBuilder = new AlertDialog.Builder(context);
        alertDlgBuilder
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true);
        AlertDialog alertDialog = alertDlgBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }
}