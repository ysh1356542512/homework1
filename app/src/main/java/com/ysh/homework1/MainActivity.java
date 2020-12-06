package com.ysh.homework1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import information.ContactFragment;
import information.DynamicFragment;
import information.ImFragment;
import information.WatchFragment;

public class MainActivity extends AppCompatActivity  {

    private BottomNavigationView navigationView;

    private Fragment Im;
    private Fragment Ct;
    private Fragment Wh;
    private Fragment Dy;
    public Fragment[] fragmentlist;

    private int lastFragment;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }
    private void initView() {
        Button mBtMainLogout = findViewById(R.id.main_logout);

    }
    private void initFragment(){
        navigationView = findViewById(R.id.bnv_main);

        navigationView.setItemIconTintList(null);

        Im = new ImFragment();
        Ct = new ContactFragment();
        Wh = new WatchFragment();
        Dy = new DynamicFragment();
        fragmentlist = new Fragment[]{Im,Ct,Wh,Dy};

        lastFragment = 0;

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, Im).show(Im).commit();
        navigationView.setSelectedItemId(R.id.newsunchoose);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            resetToDefaultIcon();

            switch (item.getItemId()){
                case R.id.newsunchoose:
                    if(lastFragment!=0){
                        switchFragment(lastFragment,0);
                        lastFragment = 0;
                    }
                    item.setIcon(R.drawable.newschoose);
                    return true;
                case R.id.contactunchoose:
                    if(lastFragment!=1){
                        switchFragment(lastFragment,1);
                        lastFragment = 1;
                    }
                    item.setIcon(R.drawable.contactchoose);
                    return true;
                case R.id.watchunchoose:
                    if(lastFragment!=2){
                        switchFragment(lastFragment,2);
                        lastFragment = 2;
                    }
                    item.setIcon(R.drawable.watchchoose);
                    return true;
                case R.id.dynaticunchoose:
                    if(lastFragment!=3){
                        switchFragment(lastFragment,3);
                        lastFragment = 3;
                    }
                    item.setIcon(R.drawable.dynaticchoose);
                    return true;
            }
            return false;
        }
    };
    private void switchFragment(int lastFragment,int index){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.hide(fragmentlist[lastFragment]);

        if(fragmentlist[index].isAdded()==false){
            transaction.add(R.id.fl_main,fragmentlist[index]);
        }
        transaction.show(fragmentlist[index]).commitAllowingStateLoss();
    }

    private void resetToDefaultIcon(){
        navigationView.getMenu().findItem(R.id.newsunchoose).setIcon(R.drawable.newsunchoose);
        navigationView.getMenu().findItem(R.id.contactunchoose).setIcon(R.drawable.contactunchoose);
        navigationView.getMenu().findItem(R.id.watchunchoose).setIcon(R.drawable.watchunchoose);
        navigationView.getMenu().findItem(R.id.dynaticunchoose).setIcon(R.drawable.dynaticunchoose);
    }

//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.main_logout:
//                if (view.getId() == R.id.main_logout) {
//                    Intent intent = new Intent(this, loginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//                break;
//        }
//    }
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if(hasFocus&&Build.VERSION.SDK_INT>=19){
//            View decorView  = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            |View.SYSTEM_UI_FLAG_FULLSCREEN
//                            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            |View.SYSTEM_UI_FLAG_FULLSCREEN
//                            |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//            );
//        }
//    }
}