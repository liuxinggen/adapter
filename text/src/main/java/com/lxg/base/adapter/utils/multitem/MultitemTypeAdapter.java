package com.lxg.base.adapter.utils.multitem;

import android.content.Context;

import com.lxg.base.adapter.MultiItemTypeAdapter;

import java.util.List;

/**
 * 类名：com.lxg.base.adapter.utils.multitem
 * 时间：2017/12/25 14:56
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class MultitemTypeAdapter extends MultiItemTypeAdapter<MultitemBean> {

    public MultitemTypeAdapter(Context context, List<MultitemBean> datas) {
        super(context, datas);
        addItemViewDelegate(new TypeAdapter1(context));
        addItemViewDelegate(new TypeAdapter2(context));
    }
}
