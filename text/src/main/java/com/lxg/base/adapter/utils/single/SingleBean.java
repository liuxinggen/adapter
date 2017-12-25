package com.lxg.base.adapter.utils.single;

/**
 * 类名：com.lxg.base.adapter.myapplication
 * 时间：2017/12/25 10:30
 * 描述：
 * 修改人：
 * 修改时间：
 * 修改备注：
 *
 * @author Liu_xg
 */

public class SingleBean {

    private String titleStr;
    private String iconPath;

    public SingleBean(String titleStr, String iconPath) {
        this.titleStr = titleStr;
        this.iconPath = iconPath;
    }

    public String getTitleStr() {
        return titleStr;
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
