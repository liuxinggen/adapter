package com.lxg.base.adapter.utils.multitem;

import android.content.Context;
import android.view.View;

import com.lxg.base.adapter.ItemViewDelegate;
import com.lxg.base.adapter.ViewHolder;
import com.lxg.base.adapter.utils.R;

/**
 * 类名：com.lxg.base.adapter.utils.multitem
 * 时间：2017/12/25 15:06
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class TypeAdapter1 implements ItemViewDelegate<MultitemBean> {

    private Context context;

    public TypeAdapter1(Context context) {
        this.context = context;
    }

    @Override
    public int getItemType() {
        return 0;
    }

    @Override
    public boolean isForViewType(MultitemBean item, int position) {
        if (position <= 3) {
            return true;
        }
        return false;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.adapter_main_fragment_layout;
    }

    @Override
    public void convert(ViewHolder holder, MultitemBean multitemBean, int position) {
        holder.setText(R.id.tv_title, multitemBean.getTitle());
        holder.setOnClickListener(R.id.tv_title, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO:单击事件
            }
        });
        holder.setOnLongClickListener(R.id.tv_title, new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //TODO:长按事件
                return false;
            }
        });
    }
}
