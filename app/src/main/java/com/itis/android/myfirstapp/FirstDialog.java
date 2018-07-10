package com.itis.android.myfirstapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Nail Shaykhraziev on 10.07.2018.
 */
public class FirstDialog extends DialogFragment {

    private EditText email;
    private EditText login;
    private OnFieldsFill listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SecondActivity) {
            listener = (OnFieldsFill) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFieldsFill");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_first, null);
        email = view.findViewById(R.id.et_email);
        login = view.findViewById(R.id.et_login);
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setTitle("Title")
                .setView(view)
                .setPositiveButton("Apply", (dialog, which) -> {
                   listener.onOkClick(email.getText().toString(), login.getText().toString());
                })
                .setNegativeButton("No, Thanks", (dialog, which) -> {
                    dismiss();
                });
        return adb.create();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    interface OnFieldsFill {
        void onOkClick(String email, String login);
    }
}
