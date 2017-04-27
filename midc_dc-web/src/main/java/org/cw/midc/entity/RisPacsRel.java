package org.cw.midc.entity;

import org.cw.midc.BaseEntity;

public class RisPacsRel extends BaseEntity{
    private String studyInfoId;

    private String studyUid;
    
    public RisPacsRel(String studyInfoId, String studyUid)
    {
    	this.studyInfoId = studyInfoId;
    	this.studyUid = studyUid;
    }

    public String getStudyInfoId() {
        return studyInfoId;
    }

    public void setStudyInfoId(String studyInfoId) {
        this.studyInfoId = studyInfoId == null ? null : studyInfoId.trim();
    }

    public String getStudyUid() {
        return studyUid;
    }

    public void setStudyUid(String studyUid) {
        this.studyUid = studyUid == null ? null : studyUid.trim();
    }
}