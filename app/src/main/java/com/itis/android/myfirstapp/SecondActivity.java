package com.itis.android.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String text = getIntent().getStringExtra("key");
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();

    }

    public void clickBack(View v) {
        Intent intent = new Intent();
        intent.putExtra("result", "result from second screen");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
