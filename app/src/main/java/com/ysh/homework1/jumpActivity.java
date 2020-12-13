package com.ysh.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class jumpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnHk1,mBtnHk2,mBtnHk3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        initView();
    }

    private void initView(){
        mBtnHk1 = findViewById(R.id.homework1);
        mBtnHk2 = findViewById(R.id.homework2_lv1);
        mBtnHk3 = findViewById(R.id.homework2_lv2);

        mBtnHk1.setOnClickListener(this);
        mBtnHk2.setOnClickListener(this);
        mBtnHk3.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homework1:
                startActivity(new Intent(jumpActivity.this,MainActivity.class));
                finish();
                break;
            case R.id.homework2_lv1:
                startActivity(new Intent(jumpActivity.this,LvOneActivity.class));
                finish();
                break;
            case R.id.homework2_lv2:
                startActivity(new Intent(jumpActivity.this,LvTwoActivity.class));
                finish();
                break;
        }
    }
}