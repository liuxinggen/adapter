package com.lxg.base.adapter.utils.multitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lxg.base.adapter.utils.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： MultitemTyleActivity
 * 时间：2017/12/25 10:04
 * 描述：多类型
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */
public class MultitemTyleActivity extends AppCompatActivity {

    private RecyclerView rvMultitem;
    private MultitemTypeAdapter adapter;
    private List<MultitemBean> multitemBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multitem_tyle);
        rvMultitem = findViewById(R.id.rv_multitem);
        initData();
        adapter = new MultitemTypeAdapter(MultitemTyleActivity.this,
                multitemBeans);
        rvMultitem.setLayoutManager(new LinearLayoutManager(
                MultitemTyleActivity.this));
        rvMultitem.setAdapter(adapter);

    }

    private void initData() {
        multitemBeans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MultitemBean multitemBean =
                    new MultitemBean("我是Type" + i,
                            "http://p1.so.qhmsg.com/t01d783b4458c98cb46.jpg");
            multitemBeans.add(multitemBean);
        }
    }
}
