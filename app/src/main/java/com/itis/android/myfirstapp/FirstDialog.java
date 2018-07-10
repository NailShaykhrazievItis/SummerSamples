package com.itis.android.myfirstapp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nail Shaykhraziev on 10.07.2018.
 */
public class FirstDialog extends DialogFragment {

    private EditText editText;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View veiw = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_first, null);
        editText = veiw.findViewById(R.id.et_email);
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setTitle("Title")
                .setView(veiw)
                .setPositiveButton("Ok", (dialog, which) -> {
                    Toast.makeText(getActivity(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", (dialog, which) -> {
                    dismiss();
                });
        return adb.show();
    }

    private void click() {

    }
}
