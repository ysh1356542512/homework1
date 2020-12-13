package com.ysh.homework1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LvOneActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnBack;

   boolean isWork;
   int number;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelone);
        Button mBtnStart = findViewById(R.id.time_start);
        Button mBtnStop = findViewById(R.id.time_stop);
        mBtnBack = findViewById(R.id.one_back);

        mBtnBack.setOnClickListener(this);

        final Handler handler = new Handler(){
            @SuppressLint("HandlerLeak")
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                EditText mEtNumber = findViewById(R.id.time_number);
                mEtNumber.setText(String.valueOf(msg.what));
            }
        };
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isWork = true;
                EditText mEvNumber = findViewById(R.id.time_number);
                mEvNumber.setEnabled(false);
                if(mEvNumber.getText().length()<1){
                    number = Integer.parseInt(String.valueOf(mEvNumber.getHint()));
                }else{
                    number = Integer.parseInt(String.valueOf(mEvNumber.getText()));
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = number-1;i>=0;i--){
                            if(isWork){
                                try{
                                    Thread.sleep(1000);
                                    Message message = new Message();
                                    message.what = i;
                                    handler.sendMessage(message);
                                } catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }).start();
            }
        });
        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isWork = false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one_back:
                startActivity(new Intent(LvOneActivity.this,jumpActivity.class));
                finish();
                break;
        }
    }
}