package com.bai.lpstore.pojo;

import java.util.List;
import java.util.Map;

/**
 * <h3>EVE-DEV</h3>
 * <p>忠诚点物品</p>
 *
 * @author : 白恒
 * @date : 2020-06-09 11:01
 **/
public class LpItem {
    private int type_id;
    private int quantity;

    private int offer_id;

    private int ak_cost;
    private long isk_cost;
    private int lp_cost;

    private Map<Integer, Integer> required_items;



    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getAk_cost() {
        return ak_cost;
    }

    public void setAk_cost(int ak_cost) {
        this.ak_cost = ak_cost;
    }

    public long getIsk_cost() {
        return isk_cost;
    }

    public void setIsk_cost(long isk_cost) {
        this.isk_cost = isk_cost;
    }

    public int getLp_cost() {
        return lp_cost;
    }

    public void setLp_cost(int lp_cost) {
        this.lp_cost = lp_cost;
    }

    public Map<Integer, Integer> getRequired_items() {
        return required_items;
    }

    public void setRequired_items(Map<Integer, Integer> required_items) {
        this.required_items = required_items;
    }
}
