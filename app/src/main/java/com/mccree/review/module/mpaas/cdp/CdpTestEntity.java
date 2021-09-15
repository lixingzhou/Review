package com.mccree.review.module.mpaas.cdp;

/**
 * Created by: lixingzhou
 * Created Date: 2021/9/15 10:08
 * Description:列表广告
 */
public class CdpTestEntity {
    private int id;
    private String content;
    private boolean isCdp;
    private String cdpCode;

    public CdpTestEntity(int id, String content, boolean isCdp) {
        this.id = id;
        this.content = content;
        this.isCdp = isCdp;
    }

    public CdpTestEntity(int id, String content, boolean isCdp, String cdpCode) {
        this.id = id;
        this.content = content;
        this.isCdp = isCdp;
        this.cdpCode = cdpCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCdp() {
        return isCdp;
    }

    public void setCdp(boolean cdp) {
        isCdp = cdp;
    }

    public String getCdpCode() {
        return cdpCode;
    }

    public void setCdpCode(String cdpCode) {
        this.cdpCode = cdpCode;
    }
}
