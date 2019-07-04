package bruteforce.presentation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

/**
 Class: TitleErrorDialog
 Author: Triet Nguyen
 Purpose: To set up error dialog when not entering task name
 */
public class TitleErrorDialog extends AppCompatDialogFragment {

    /**
     onCreate

     Purpose: setup Title Error Notification
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Error")
                .setMessage("Please enter task name")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();

    }
}
