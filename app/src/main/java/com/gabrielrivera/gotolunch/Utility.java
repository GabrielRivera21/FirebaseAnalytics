package com.gabrielrivera.gotolunch;

/**
 * Created by gabrielrivera on 6/8/17.
 */

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by gabrielrivera on 6/8/17.
 */

public class Utility {

    /**
     * Builds and Shows an Alert Dialog Message
     *
     * @param mActivity Calling Activity
     * @param message   The Message
     */
    public static void showAlertDialog(Activity mActivity, String message) {
        showAlertDialog(mActivity, null, message, null, null);
    }

    /**
     * Builds and shows Dialog with an OK Button callback.
     *
     * @param mActivity        Calling Activity
     * @param message          The Message
     * @param positiveCallback the Callback if OK Button is pressed
     */
    public static void showAlertDialog(Activity mActivity, String message, DialogInterface.OnClickListener positiveCallback) {
        showAlertDialog(mActivity, null, message, positiveCallback, null);
    }

    /**
     * Builds and shows a Dialog with an OK Button callback
     * and a cancel button
     *
     * @param mActivity        Calling Activity
     * @param message          The Message
     * @param positiveCallback the Callback if OK Button is pressed
     * @param showCancel       if it shows the Cancel Button
     */
    public static void showAlertDialog(Activity mActivity, String message,
                                       DialogInterface.OnClickListener positiveCallback, boolean showCancel) {
        if (showCancel)
            showAlertDialog(mActivity, null, message, positiveCallback, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
        else
            showAlertDialog(mActivity, null, message, positiveCallback, null);
    }

    /**
     * Builds and shows a Dialog with a custom title with an OK Button callback
     * and a cancel button
     *
     * @param mActivity        Calling Activity
     * @param title            Title of the Dialog
     * @param message          The Message
     * @param positiveCallback the Callback if OK Button is pressed
     * @param showCancel       if it shows the Cancel Button
     */
    public static void showAlertDialog(Activity mActivity, String title, String message,
                                       DialogInterface.OnClickListener positiveCallback, boolean showCancel) {
        if (showCancel)
            showAlertDialog(mActivity, title, message, positiveCallback, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
        else
            showAlertDialog(mActivity, title, message, positiveCallback, null);
    }

    /**
     * Builds and shows a Dialog with a custom title with an OK Button callback
     * and a cancel button with callback
     *
     * @param mActivity        Calling Activity
     * @param title            Title of the Dialog
     * @param message          The Message
     * @param positiveCallback the Callback if OK Button is pressed
     * @param negativeCallback the Callback if Cancel Button is pressed
     */
    public static void showAlertDialog(Activity mActivity, String title, String message,
                                       DialogInterface.OnClickListener positiveCallback,
                                       DialogInterface.OnClickListener negativeCallback) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mActivity);
        if (title == null)
            alertDialogBuilder.setTitle(mActivity.getString(R.string.app_name));
        else
            alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("Ok", positiveCallback);
        if (negativeCallback != null)
            alertDialogBuilder.setNegativeButton("Cancel", negativeCallback);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
