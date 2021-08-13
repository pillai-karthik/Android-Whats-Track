package com.kbrosapp.whatstrack;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Target")
public class Target {

    @PrimaryKey(autoGenerate = true)
    private int Target_Id;

    private String Target_Name;

    private String Target_Phone;

    public Target(String Target_Name, String Target_Phone) {
        this.Target_Name = Target_Name;
        this.Target_Phone = Target_Phone;
    }

    public int getTarget_Id() {
        return Target_Id;
    }

    public void setTarget_Id(int target_Id) {
        Target_Id = target_Id;
    }

    public String getTarget_Name() {
        return Target_Name;
    }

    public void setTarget_Name(String target_Name) {
        Target_Name = target_Name;
    }

    public String getTarget_Phone() {
        return Target_Phone;
    }

    public void setTarget_Phone(String target_Phone) {
        Target_Phone = target_Phone;
    }
}
