package org.cw.midc.entity;

import org.cw.midc.BaseEntity;

public class StudyCheckPos extends BaseEntity{
    private Integer studyCpId;

    private String checkItem;

    private String position;

    private String subPosition;

    private String studyinfoId;

    public Integer getStudyCpId() {
        return studyCpId;
    }

    public void setStudyCpId(Integer studyCpId) {
        this.studyCpId = studyCpId;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem == null ? null : checkItem.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getSubPosition() {
        return subPosition;
    }

    public void setSubPosition(String subPosition) {
        this.subPosition = subPosition == null ? null : subPosition.trim();
    }

    public String getStudyinfoId() {
        return studyinfoId;
    }

    public void setStudyinfoId(String studyinfoId) {
        this.studyinfoId = studyinfoId == null ? null : studyinfoId.trim();
    }
}