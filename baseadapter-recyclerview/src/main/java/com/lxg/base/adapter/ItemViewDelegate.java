package com.lxg.base.adapter;

/**
 * 类名：com.agri.expert.base
 * 时间：2017/12/22 11:21
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public interface ItemViewDelegate<T>
{
    //获取Item类型
    int getItemType();
    //是否绑定数据
    boolean isForViewType(T item, int position);
    //类型的Item
    int getItemViewLayoutId();
    //绑定数据
    void convert(ViewHolder holder, T t, int position);

}

