package com.lxg.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * 类名：com.agri.expert.base
 * 时间：2017/12/22 10:56
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public abstract class SingleAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;

    public SingleAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        //创建ViewHolder对象
        return ViewHolder.createViewHolder(mContext, parent, mLayoutId);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //绑定数据交由子类来完成
        convert(holder, mDatas.get(position), position);
    }

    public abstract void convert(ViewHolder holder, T t, int position);

    //以下是一些公共方法的封装

    public void clearData() {
        mDatas.clear();
        notifyItemRangeRemoved(0, mDatas.size());
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
        if (position != mDatas.size())
            notifyItemRangeChanged(position, mDatas.size() - position);
    }

    public void addData(List<T> list) {
        addData(0, list);
    }

    public void addData(int position, List<T> data) {
        if (data != null && data.size() > 0) {
            mDatas.addAll(position, data);
            notifyItemRangeInserted(position, data.size());
        }
    }

    public void setData(List<T> data) {
        if (data != null) {
            mDatas = data;
            notifyDataSetChanged();
        }
    }

}
