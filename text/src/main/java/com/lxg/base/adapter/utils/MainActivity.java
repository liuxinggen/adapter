package com.lxg.base.adapter.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
        list.add("单类型item布局");
        list.add("多类型item布局");

        //单一布局
        SingleAdapter<String> adapter =
                new SingleAdapter<String>(MainActivity.this, R.layout.adapter_main_fragment_layout, list) {
                    @Override
                    public void convert(ViewHolder holder, String s, final int position) {
                        holder.setText(R.id.tv_title, s);
                        holder.setOnClickListener(R.id.tv_title, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                switch (position) {
                                    case 0:
                                        Intent mIntentSingle = new Intent(MainActivity.this,
                                                SingleActivity.class);
                                        startActivity(mIntentSingle);
                                        break;
                                    case 1:
                                        Intent mIntentMult = new Intent(MainActivity.this,
                                                MultitemTyleActivity.class);
                                        startActivity(mIntentMult);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        });
                    }
                };
        mainRv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainRv.setAdapter(adapter);


    }
}
