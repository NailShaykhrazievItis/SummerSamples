package com.itis.android.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomFragment extends Fragment {

    private TextView textView;

    public static BottomFragment newInstance() {
        return new BottomFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        textView = view.findViewById(R.id.tv_result);
        return view;
    }

    public void setResult(String message) {
        textView.setText(message);
    }
}
