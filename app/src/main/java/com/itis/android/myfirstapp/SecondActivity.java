package com.itis.android.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements FirstDialog.OnFieldsFill {

    private TextView tvLogin;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvLogin = findViewById(R.id.tv_login);
        tvEmail = findViewById(R.id.tv_email);
        String text = getIntent().getStringExtra("key");
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        findViewById(R.id.btn_show).setOnClickListener(v -> {
            FirstDialog dialog = new FirstDialog();
            dialog.show(getSupportFragmentManager(), "dialog");
        });
    }

    public void clickBack(View v) {
        Intent intent = new Intent();
        intent.putExtra("result", "result from second screen");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void onOkClick(String email, String login) {
        tvLogin.setText(getString(R.string.login, login));
        tvEmail.setText(getString(R.string.email, email));
    }
}
