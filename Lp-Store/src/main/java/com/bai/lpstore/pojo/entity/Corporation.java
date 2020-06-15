package com.bai.lpstore.pojo.entity;

/**
 * <h3>EVE-DEV</h3>
 * <p></p>
 *
 * @author : 白恒
 * @date : 2020-06-09 11:33
 **/
public class Corporation {
    private int factionID;
    private int corporationID;
    private String factionName;
    private String corporationName;

    @Override
    public String toString() {
        return "Corporation{" +
                "factionID=" + factionID +
                ", corporationID=" + corporationID +
                ", factionName='" + factionName + '\'' +
                ", corporationName='" + corporationName + '\'' +
                '}';
    }

    public int getFactionID() {
        return factionID;
    }

    public void setFactionID(int factionID) {
        this.factionID = factionID;
    }

    public int getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(int corporationID) {
        this.corporationID = corporationID;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }
}
