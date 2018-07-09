package com.itis.android.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TopFragment.OnTopFragmentListener {

    public static final int REQUEST_CODE = 11;

    private EditText editText;
    private Button button;
    private BottomFragment bottomFragment;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.getString("key");
        }
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.et_login);
        button = findViewById(R.id.btn_next);

        initTopFragment();
        initBottomFragment();

        initSharedPreferences();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                String res = data.getStringExtra("result");
                Toast.makeText(this,
                        res,
                        Toast.LENGTH_LONG)
                        .show();
            }
        }
    }

    public void onNextClick(View view) {
        count++;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key", editText.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("key", count);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("key");
        Toast.makeText(this, "Count: " + count, Toast.LENGTH_SHORT).show();
    }

    private void initTopFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_top, TopFragment.newInstance())
                .commit();
    }

    private void initBottomFragment() {
        bottomFragment = BottomFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_bottom, bottomFragment)
                .commit();
    }

    private void initSharedPreferences() {
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("myKey", 1);
        editor.apply();
    }

    @Override
    public void onSendClick(String text) {
        if (bottomFragment != null) {
            bottomFragment.setResult(text);
        } else {
            initBottomFragment();
            bottomFragment.setResult(text);
        }
    }
}
