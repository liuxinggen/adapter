package com.lxg.base.adapter.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lxg.base.adapter.SingleAdapter;
import com.lxg.base.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainRv;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRv = findViewById(R.id.main_rv);

        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("测试数据" + i);
        }

        //单一布局
        SingleAdapter<String> adapter =
                new SingleAdapter<String>(MainActivity.this, R.layout.adapter_main_fragment_layout, list) {
                    @Override
                    public void convert(ViewHolder holder, String s) {
                        holder.setText(R.id.tv_title, s);


                    }
                };
        mainRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainRv.setAdapter(adapter);
    }
}
