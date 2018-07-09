package com.itis.android.myfirstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TopFragment extends Fragment {

    private EditText editText;

    private OnTopFragmentListener listener;

    public static TopFragment newInstance() {
        return new TopFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            listener = (OnTopFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTopFragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        editText = view.findViewById(R.id.et_text);
        view.findViewById(R.id.btn_send).setOnClickListener(v -> {
            listener.onSendClick(editText.getText().toString());
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    interface OnTopFragmentListener {
        void onSendClick(String text);
    }
}
