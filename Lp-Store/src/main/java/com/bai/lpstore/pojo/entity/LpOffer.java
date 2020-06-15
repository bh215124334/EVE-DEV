package com.bai.lpstore.pojo.entity;

/**
 * <h3>EVE-DEV</h3>
 * <p>忠诚点商店物品需求实体类</p>
 *
 * @author : 白恒
 * @date : 2020-06-12 15:10
 **/
public class LpOffer {
    private int offerID;
    private int typeID;
    private long quantity;

    @Override
    public String toString() {
        return "LpOffer{" +
                "offerID=" + offerID +
                ", typeID=" + typeID +
                ", quantity=" + quantity +
                '}';
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
}
