package com.bai.lpstore.pojo.entity;

import com.bai.lpstore.pojo.LpItem;

/**
 * <h3>EVE-DEV</h3>
 * <p>数据库lp表实体类</p>
 *
 * @author : 白恒
 * @date : 2020-06-12 15:05
 **/
public class LpInformation {

    private int offerID;

    private int typeID;
    private long quantity;

    private int corporationID;

    private int akCost;
    private long iskCost;
    private int lpCost;

    @Override
    public String toString() {
        return "LpInformation{" +
                "offerID=" + offerID +
                ", typeID=" + typeID +
                ", quantity=" + quantity +
                ", corporationID=" + corporationID +
                ", akCost=" + akCost +
                ", iskCost=" + iskCost +
                ", lpCost=" + lpCost +
                '}';
    }

    public LpInformation(){}
    public LpInformation(LpItem lpItem){
        this.typeID = lpItem.getType_id();
        this.quantity = lpItem.getQuantity();
        this.corporationID = lpItem.getOffer_id();
        this.iskCost = lpItem.getIsk_cost();
        this.lpCost = lpItem.getLp_cost();
        this.akCost = lpItem.getAk_cost();
    }

    public int getOfferID() {
        return offerID;
    }

    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public int getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(int corporationID) {
        this.corporationID = corporationID;
    }

    public int getAkCost() {
        return akCost;
    }

    public void setAkCost(int akCost) {
        this.akCost = akCost;
    }

    public long getIskCost() {
        return iskCost;
    }

    public void setIskCost(long iskCost) {
        this.iskCost = iskCost;
    }

    public int getLpCost() {
        return lpCost;
    }

    public void setLpCost(int lpCost) {
        this.lpCost = lpCost;
    }
}
