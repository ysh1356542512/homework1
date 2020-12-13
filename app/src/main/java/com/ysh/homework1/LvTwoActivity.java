package com.ysh.homework1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LvTwoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnBack;
    private TextView mTvText;
    private RecyclerView mRvData;
    private ArrayList<Data> dataArrayList = new ArrayList<Data>();
    private LvTwoAdapter lvTwoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leveltwo);
        sendGetNetRequest("https://www.wanandroid.com/article/list/0/json");
    }

    private void initView(){
        mBtnBack = findViewById(R.id.one_back);
        mBtnBack.setOnClickListener(this);
        mRvData = findViewById(R.id.Rv_url);
        mRvData.setLayoutManager(new LinearLayoutManager(LvTwoActivity.this));
        LvTwoAdapter lvTwoAdapter = new LvTwoAdapter(LvTwoActivity.this,dataArrayList);
        mRvData.setAdapter(lvTwoAdapter);
        lvTwoAdapter.setOnItemClickListener(new LvTwoAdapter.OnItemClickListener(){
            @Override
            public void OnItemClick(View view, int postion) {
                Intent intent = new Intent(LvTwoActivity.this,WebActivity.class);
                startActivity(intent);
            }
        });
    }

    private void parseJson(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("datas");
            for(int i = 0;i<jsonArray.length();i++){
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                Data data1 = new Data(1,jsonObject2.getString("title"));
                Data data2 = new Data(1,jsonObject2.getString("shareUser"));
                Data data3 = new Data(2,jsonObject2.getString("link"));
                dataArrayList.add(data1);
                dataArrayList.add(data2);
                dataArrayList.add(data3);
            }
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    private void sendGetNetRequest(String murl){
        MHandler mHandler = new MHandler();
        new Thread(
                () -> {
                    try {
                        URL url = new URL(murl);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(20000);
                        connection.setReadTimeout(20000);
                        connection.connect();
                        InputStream in = connection.getInputStream();
                        String response = StreamToString(in);
                        Message message = new Message();
                        message.obj = response;
                        mHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
    private String StreamToString(InputStream in){
        StringBuilder sb = new StringBuilder();
        String oneLine;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            while((oneLine = reader.readLine())!=null){
                sb.append(oneLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                in.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @SuppressLint("HandlerLeak")
    private class MHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String responseData = msg.obj.toString();
            parseJson(responseData);
            initView();
        }
    }
    private LvTwoAdapter.OnItemClickListener urlItemClickListener = new LvTwoAdapter.OnItemClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void OnItemClick(View view, int postion) {
            switch ((view.getId())) {
                case R.id.item_one_url:
                    Intent intent = new Intent(LvTwoActivity.this,WebActivity.class);
                    startActivity(intent);
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.two_back:
                startActivity(new Intent(LvTwoActivity.this,jumpActivity.class));
                finish();
                break;
        }
    }
}