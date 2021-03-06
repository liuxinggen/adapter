package com.lxg.base.adapter.utils.single;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lxg.base.adapter.SingleAdapter;
import com.lxg.base.adapter.ViewHolder;
import com.lxg.base.adapter.utils.utils.MyImageLoader;
import com.lxg.base.adapter.utils.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： SingleActivity
 * 时间：2017/12/25 10:04
 * 描述：单一类型
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */
public class SingleActivity extends AppCompatActivity {
    private RecyclerView rvSingle;
    private SingleAdapter<SingleBean> adapter;
    private List<SingleBean> singleBeanList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        rvSingle = findViewById(R.id.rv_single);


        singleBeanList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SingleBean singleBean = new SingleBean("单一布局" + i,
                    "http://p1.so.qhimgs1.com/t012b7a52b1060ecb51.jpg");
            singleBeanList.add(singleBean);
        }
        SingleAdapter<SingleBean> adapter = new SingleAdapter<SingleBean>
                (SingleActivity.this, R.layout.adapter_single_type_layout,
                        singleBeanList) {
            @Override
            public void convert(ViewHolder holder, SingleBean singleBean, int position) {
                holder.setText(R.id.tv_single_title, singleBean.getTitleStr());
                MyImageLoader
                        .displayImage(SingleActivity.this,
                                singleBean.getIconPath(),
                                (ImageView) holder.getView(R.id.iv_icon));
                holder.setOnClickListener(R.id.tv_single_title, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO:单击事件
                    }
                });
                holder.setOnLongClickListener(R.id.tv_single_title, new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        //TODO:长按事件
                        return false;
                    }
                });
            }
        };
        rvSingle.setLayoutManager(new LinearLayoutManager(SingleActivity.this));
        rvSingle.setAdapter(adapter);

    }
}
