package jwangsadinata.github.io.stayintouch.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import jwangsadinata.github.io.stayintouch.R;

/**
 * Created by Jason on 12/13/15.
 */
public class AboutDialog extends DialogFragment {

    public static final String TAG = "CityFragment";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.aboutdialog_layout, null);
        builder.setTitle(getString(R.string.about_this_app));
        builder.setView(v);
        builder.setNegativeButton(getString(R.string.action_back),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        AlertDialog alert = builder.create();
        return alert;
    }

}