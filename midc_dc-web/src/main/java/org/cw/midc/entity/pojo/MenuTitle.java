package org.cw.midc.entity.pojo;

import org.cw.midc.BaseEntity;
import org.cw.midc.entity.Menu;

import java.util.List;

public class MenuTitle extends BaseEntity {
    private String name;

    private String titleId;

    private Integer seq;

    private String icon;

    private List<Menu> menuList;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
}
