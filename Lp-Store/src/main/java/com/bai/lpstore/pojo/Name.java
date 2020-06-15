package com.bai.lpstore.pojo;

/**
 * <h3>EVE-DEV</h3>
 * <p></p>
 *
 * @author : 白恒
 * @date : 2020-06-11 14:23
 **/
public class Name {
    private String name;
    private int typeID;
    private double volume;

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", typeID=" + typeID +
                ", volume=" + volume +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return typeID;
    }

    public void setID(int ID) {
        this.typeID = ID;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
