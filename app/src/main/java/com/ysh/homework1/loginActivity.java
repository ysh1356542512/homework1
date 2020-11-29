package com.ysh.homework1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvLoginLeft;
    private TextView mTvLoginRight;
    private Button mBtnLoginLogin;
    private RelativeLayout mRlLoginTop;
    private EditText mEtLoginUsername;
    private EditText mEtLoginPassword;
    private LinearLayout mLlLoginBody;
    private ImageView mTvXlweibo;
    private ImageView mTvQQ;
    private ImageView mTvwechat;
    private ImageView mTvTxweibo;
    private String uerName, password, spPassword;
    private CheckBox mCbchoice;
    private int count = 0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    private void initView() {
        // 初始化控件
        mRlLoginTop = findViewById(R.id.login_Top);
        mBtnLoginLogin = findViewById(R.id.login_login);
        mIvLoginLeft = findViewById(R.id.login_left);
        mTvLoginRight = findViewById(R.id.login_right);
        mEtLoginUsername = findViewById(R.id.login_userNameText);
        mEtLoginPassword = findViewById(R.id.login_passwordText);
        mLlLoginBody = findViewById(R.id.login_body);
        mTvTxweibo = findViewById(R.id.Txweibo);
        mTvQQ = findViewById(R.id.QQ);
        mTvwechat = findViewById(R.id.wechat);
        mTvXlweibo = findViewById(R.id.Xlweibo);
        mEtLoginUsername.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mEtLoginPassword.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mCbchoice = findViewById(R.id.login_choice);

        mCbchoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    count = 1;
                }else{
                    count = 0;
                }
            }
        });


        mIvLoginLeft.setOnClickListener(this);
        mBtnLoginLogin.setOnClickListener(this);
        mTvLoginRight.setOnClickListener(this);
        mTvQQ.setOnClickListener(this);
        mTvwechat.setOnClickListener(this);
        mTvTxweibo.setOnClickListener(this);
        mTvXlweibo.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        switch (view.getId()) {
            // 跳转到注册界面
            case R.id.login_right:
                startActivity(new Intent(this, registerActivity.class));
                finish();
                break;
            case R.id.login_login:
                if(count==1) {
                    uerName = mEtLoginUsername.getText().toString().trim();
                    password = mEtLoginPassword.getText().toString().trim();
                    String md5Psw = MD5Utils.md5(password);
                    spPassword = readPsw(uerName);
                    if (TextUtils.isEmpty(uerName)) {
                        Toast.makeText(loginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (TextUtils.isEmpty(password)) {
                        Toast.makeText(loginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (md5Psw.equals(spPassword)) {
                        Toast.makeText(loginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        saveLoginStatus(true, uerName);
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else if ((spPassword != null && !TextUtils.isEmpty(spPassword) && !md5Psw.equals(spPassword))) {
                        Toast.makeText(loginActivity.this, "输入的用户名和密码错误", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Toast.makeText(loginActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(loginActivity.this,"请勾选协议",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login_left:
                startActivity(new Intent(this, showActivity.class));
                finish();
                break;
            case R.id.Xlweibo:
                Toast.makeText(this, "新浪微博登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.QQ:
                Toast.makeText(this, "腾讯QQ登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wechat:
                Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Txweibo:
                Toast.makeText(this, "腾讯微博登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private String readPsw(String userName) {
        SharedPreferences sp = getSharedPreferences("logininfo", MODE_PRIVATE);
        return sp.getString(userName,"");
    }
    private void saveLoginStatus(boolean status,String userName){
        SharedPreferences sp = getSharedPreferences("logininfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isLogiin",status);
        editor.putString("loginUserName",userName);
        editor.commit();
    }
    protected void onActivityResult(int code,int result,Intent data){
        super.onActivityResult(code,result,data);
        if(data!=null){
            String userName = data.getStringExtra("userName");
            if(!TextUtils.isEmpty(userName)){
                mEtLoginUsername.setText(userName);
                mEtLoginUsername.setSelection(userName.length());
            }
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