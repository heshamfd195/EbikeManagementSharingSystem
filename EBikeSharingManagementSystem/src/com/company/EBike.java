package com.company;

public class EBike {
    public int bikeNumber;
    protected int batteryCharge;
    protected int health;

    public EBike(int bikeNum,int charge,int healthIndex){
        this.bikeNumber=bikeNum;
        this.batteryCharge=charge;
        this.health=healthIndex;


    }

    @Override
    public String toString() {
        return "E"+bikeNumber+"(" +
                "N:" + bikeNumber +
                ",C:" + batteryCharge +
                ",H:" + health +
                ')';
    }
}
