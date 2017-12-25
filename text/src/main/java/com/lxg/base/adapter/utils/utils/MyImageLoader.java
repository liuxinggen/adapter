package com.lxg.base.adapter.utils.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.lxg.base.adapter.utils.GlideApp;

import static android.content.ContentValues.TAG;


/**
 * 类名：com.lxg.utils.baseadapter.utils
 * 时间：2017/12/22 15:50
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class MyImageLoader {

    /**
     * 构造函数私有化
     **/
    private MyImageLoader() {
    }

    /**
     * 加载图片
     *
     * @param context
     * @param path      加载图片地址
     * @param imageView
     * @param errorId   错误图片
     * @param placeId   占位符
     */
    public static void displayImage(Context context,
                                    Object path,
                                    ImageView imageView,
                                    int errorId,
                                    int placeId) {
        //Glide 加载图片用法
        GlideApp.with(context)
                .load(path)
                .centerCrop()
                .error(errorId)
                .placeholder(placeId)
                .into(imageView);
    }

    /**
     * @param context
     * @param path
     * @param imageView
     */
    public static void displayImage(Context context,
                                    Object path,
                                    ImageView imageView) {
        //Glide 加载图片用法
        GlideApp.with(context)
                .load(path)
                .listener(mRequestListenter)
                .into(imageView);
    }

    private static RequestListener<Drawable> mRequestListenter = new RequestListener<Drawable>() {
        @Override
        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
            Log.d(TAG, "onException: " + e.toString() + "  model:" + model + " isFirstResource: " + isFirstResource);
            return false;
        }

        @Override
        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
            Log.e(TAG, "model:" + model + " isFirstResource: " + isFirstResource);
            return false;
        }
    };


}
