package com.ysh.homework1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mRltop;
    private ImageView mIvleft;
    private EditText mEtRegisteractivityUsername;
    private EditText mEtRegisteractivityPassword1;
    private EditText mEtRegisteractivityPassword2;
    private Button mBtnRegisterRegister;
    private TextView mTvRegisterLogin;
    private LinearLayout mLlRegisterBody;
    private CheckBox mCb1;
    private CheckBox mCbregister;
    private int count;
    private String userName,psw,pswEnsure;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        mCb1 = findViewById(R.id.checkbox1);
        mCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mEtRegisteractivityPassword1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mEtRegisteractivityPassword2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    mEtRegisteractivityPassword1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mEtRegisteractivityPassword2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

    }
    private void initView(){
            mRltop = findViewById(R.id.register_Top);
            mIvleft = findViewById(R.id.register_left);
            mLlRegisterBody = findViewById(R.id.register_body);
            mEtRegisteractivityUsername = findViewById(R.id.register_userNameText);
            mEtRegisteractivityPassword1 = findViewById(R.id.register_passwordText);
            mEtRegisteractivityPassword2 = findViewById(R.id.register_passwordText2);
            mBtnRegisterRegister = findViewById(R.id.register_register);
            mTvRegisterLogin = findViewById(R.id.register_login);
            mTvRegisterLogin.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
            mCbregister = findViewById(R.id.register_choice);

        mCbregister.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked){
                                count = 1;
                            }else{
                                count = 0;
                            }
            }
        });

            mIvleft.setOnClickListener(this);
            mBtnRegisterRegister.setOnClickListener(this);
            mTvRegisterLogin.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_left:
                Intent intent1 = new Intent(this,showActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.register_register:
                if(count==1) {
                    getEditString();
                    if(TextUtils.isEmpty(userName)){
                        Toast.makeText(this,"请输入用户名",Toast.LENGTH_SHORT).show();
                        return;
                    } else if(TextUtils.isEmpty(psw)){
                        Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
                        return;
                    } else if(TextUtils.isEmpty(pswEnsure)){
                        Toast.makeText(this,"请确认密码",Toast.LENGTH_SHORT).show();
                        return;
                    } else if(!psw.equals(pswEnsure)){
                        Toast.makeText(this,"输入的密码不一致",Toast.LENGTH_SHORT).show();
                        return;
                    } else if(isExistUserName(userName)){
                        Toast.makeText(this,"用户名已存在",Toast.LENGTH_SHORT).show();
                        return;
                    } else{
                        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                        saveRegisterdata(userName,psw);
                        Intent intent2 = new Intent(this, loginActivity.class);
                        intent2.putExtra("userName",userName);
                        setResult(RESULT_OK,intent2);
                        startActivity(intent2);
                        finish();
                    }
                } else{
                    Toast.makeText(this, "请勾选协议", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_login:
                Intent intent3 = new Intent(this,loginActivity.class);
                startActivity(intent3);
                finish();
                break;
        }
    }
    private void getEditString(){
        userName = mEtRegisteractivityUsername.getText().toString().trim();
        psw = mEtRegisteractivityPassword1.getText().toString().trim();
        pswEnsure = mEtRegisteractivityPassword2.getText().toString().trim();
    }
    private boolean isExistUserName(String userName){
        boolean isExist = false;
        SharedPreferences sp = getSharedPreferences("logininfo",MODE_PRIVATE);
        String spPassword = sp.getString(userName,"");
        if(!TextUtils.isEmpty(spPassword)){
            isExist = true;
        }
        return isExist;
    }
    private void saveRegisterdata(String userName,String psw){
        String md5Psw = MD5Utils.md5(psw);
        SharedPreferences sp = getSharedPreferences("logininfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(userName,md5Psw);
        editor.commit();
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