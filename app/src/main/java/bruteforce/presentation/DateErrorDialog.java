package bruteforce.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

/**
 Class: DateErrorDialog
 Author: Triet Nguyen
 Purpose: To set up error dialog when choosing wrong date
 */
public class DateErrorDialog extends AppCompatDialogFragment {

    /**
     onCreate

     Purpose: setup Date Error Notification
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Error")
                .setMessage("Date must be in the future")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
