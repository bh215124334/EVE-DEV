package com.bai.lpstore.pojo.entity;

import java.util.Map;

/**
 * <h3>EVE-DEV</h3>
 * <p>蓝图</p>
 *
 * @author : 白恒
 * @date : 2020-06-12 09:59
 **/
public class Blueprint {
    private int blueprintID;
    private int productID;
    private long productQuantity;
    private int materialID;
    private long materialQuantity;


    public int getBlueprintID() {
        return blueprintID;
    }

    public void setBlueprintID(int blueprintID) {
        this.blueprintID = blueprintID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public long getMaterialQuantity() {
        return materialQuantity;
    }

    public void setMaterialQuantity(long materialQuantity) {
        this.materialQuantity = materialQuantity;
    }
}
