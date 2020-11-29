package com.ysh.homework1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class showActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mBtnShowLogin,mBtnShowRegister;
    private ImageView mIvarrow;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    private void initView() {
        mBtnShowLogin = findViewById(R.id.show_left);
        mBtnShowRegister = findViewById(R.id.show_right);
        mIvarrow = findViewById(R.id.show_arrow);


        mBtnShowLogin.setOnClickListener(this);
        mBtnShowRegister.setOnClickListener(this);
        mIvarrow.setOnClickListener(this);
    }
    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.show_right:
                startActivity(new Intent(this, registerActivity.class));
                finish();
                break;
            case R.id.show_left:
            case R.id.show_arrow:
                startActivity(new Intent(this, loginActivity.class));
                finish();
                break;
        }
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus&&Build.VERSION.SDK_INT>=19){
            View decorView  = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            |View.SYSTEM_UI_FLAG_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            |View.SYSTEM_UI_FLAG_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }
}