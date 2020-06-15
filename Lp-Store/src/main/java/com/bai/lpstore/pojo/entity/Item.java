package com.bai.lpstore.pojo.entity;

/**
 * <h3>EVE-DEV</h3>
 * <p>物价信息实体类</p>
 *
 * @author : 白恒
 * @date : 2020-06-12 17:41
 **/
public class Item {
    private int typeID;

    private boolean isBlueprint;

    private long buyMax;
    private long sellMin;

    private long volumeWeek;
    private long volumeLastDay;

    private long avgPriceWeek;
    private long avgPriceLstDay;

    @Override
    public String toString() {
        return "Item{" +
                "typeID=" + typeID +
                ", isBlueprint=" + isBlueprint +
                ", buyMax=" + buyMax +
                ", sellMin=" + sellMin +
                ", volumeWeek=" + volumeWeek +
                ", volumeLastDay=" + volumeLastDay +
                ", avgPriceWeek=" + avgPriceWeek +
                ", avgPriceDay=" + avgPriceLstDay +
                '}';
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public boolean isBlueprint() {
        return isBlueprint;
    }

    public void setBlueprint(boolean blueprint) {
        isBlueprint = blueprint;
    }

    public long getBuyMax() {
        return buyMax;
    }

    public void setBuyMax(long buyMax) {
        this.buyMax = buyMax;
    }

    public long getSellMin() {
        return sellMin;
    }

    public void setSellMin(long sellMin) {
        this.sellMin = sellMin;
    }

    public long getVolumeWeek() {
        return volumeWeek;
    }

    public void setVolumeWeek(long volumeWeek) {
        this.volumeWeek = volumeWeek;
    }

    public long getVolumeLastDay() {
        return volumeLastDay;
    }

    public void setVolumeLastDay(long volumeLastDay) {
        this.volumeLastDay = volumeLastDay;
    }

    public long getAvgPriceWeek() {
        return avgPriceWeek;
    }

    public void setAvgPriceWeek(long avgPriceWeek) {
        this.avgPriceWeek = avgPriceWeek;
    }

    public long getAvgPriceLstDay() {
        return avgPriceLstDay;
    }

    public void setAvgPriceLstDay(long avgPriceLstDay) {
        this.avgPriceLstDay = avgPriceLstDay;
    }
}
