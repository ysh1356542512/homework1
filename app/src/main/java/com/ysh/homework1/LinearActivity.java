package com.ysh.homework1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class LinearActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRvLir;
    private Button mBtnreturn;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        mBtnreturn = findViewById(R.id.return_main);
        mBtnreturn.setOnClickListener(this);
        mRvLir = findViewById(R.id.main_lir);
        mRvLir.setLayoutManager(new LinearLayoutManager(LinearActivity.this));
        mRvLir.setAdapter(new LinearAdapter(LinearActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(LinearActivity.this, "click" + position, Toast.LENGTH_SHORT).show();
            }
        }, new LinearAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(int position) {
                Toast.makeText(LinearActivity.this,"Longclick"+position,Toast.LENGTH_SHORT).show();
            }
        }));
        mRvLir.addItemDecoration(new MyDecoration());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.return_main:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
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