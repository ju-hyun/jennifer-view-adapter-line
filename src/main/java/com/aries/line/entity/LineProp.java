package com.aries.line.entity;

public class LineProp {

    private String lineToken;
    private String stickerPackageId;
    private String stickerId;
    private String notificationDisabled;

    public String getLineToken() {
        return this.lineToken;
    }

    public void setLineToken(String lineToken) {
        this.lineToken = lineToken;
    }

    public String getStickerPackageId() {
        return this.stickerPackageId;
    }

    public void setStickerPackageId(String stickerPackageId) {
        this.stickerPackageId = stickerPackageId;
    }

    public String getStickerId() {
        return this.stickerId;
    }

    public void setStickerId(String stickerId) {
        this.stickerId = stickerId;
    }

    public String isNotificationDisabled() {
        return this.notificationDisabled;
    }

    public void setNotificationDisabled(String notificationDisabled) {
        this.notificationDisabled = notificationDisabled;
    }
      
}
