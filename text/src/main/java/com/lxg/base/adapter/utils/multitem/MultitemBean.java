package com.lxg.base.adapter.utils.multitem;

import java.util.List;

/**
 * 类名：com.lxg.base.adapter.utils.multitem
 * 时间：2017/12/25 14:57
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class MultitemBean {

    private String title;
    private String IconPath;

    public MultitemBean(String title, String iconPath) {
        this.title = title;
        IconPath = iconPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconPath() {
        return IconPath;
    }

    public void setIconPath(String iconPath) {
        IconPath = iconPath;
    }
}
