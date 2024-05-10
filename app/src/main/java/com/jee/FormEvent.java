package com.jee;

import java.util.EventObject;

public class FormEvent extends EventObject {

private String name;
private String occupation;
private int ageId;
private String empCat;

    public FormEvent(Object source, String name, String occupation, int ageId, String empCat) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageId = ageId;
        this.empCat = empCat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setAgeId(int id) {
        this.ageId = id;
    }

    public int getAgeId() {
        return this.ageId;
    }

    public String getEmpCat() {
        return this.empCat;
    }
}
