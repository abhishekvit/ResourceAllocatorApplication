package com.example.abhishek.assigmentproject;

import java.io.Serializable;

/**
 * Created by ABHISHEK on 9/23/2017.
 */

public class AssetBean implements Serializable {

    private int assetid;
    private String assetMake;
    private String yearOfMaking;
    private String allocatedTo;
    private String allocatedTill;

    public int getAssetid() {
        return assetid;
    }

    public void setAssetid(int assetid) {
        this.assetid = assetid;
    }

    public String getAssetMake() {
        return assetMake;
    }

    public void setAssetMake(String assetMake) {
        this.assetMake = assetMake;
    }

    public String getYearOfMaking() {
        return yearOfMaking;
    }

    public void setYearOfMaking(String yearOfMaking) {
        this.yearOfMaking = yearOfMaking;
    }

    public String getAllocatedTo() {
        return allocatedTo;
    }

    public void setAllocatedTo(String allocatedTo) {
        this.allocatedTo = allocatedTo;
    }

    public String getAllocatedTill() {
        return allocatedTill;
    }

    public void setAllocatedTill(String allocatedTill) {
        this.allocatedTill = allocatedTill;
    }
}
