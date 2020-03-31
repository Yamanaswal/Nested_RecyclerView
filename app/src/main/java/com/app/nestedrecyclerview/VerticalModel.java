package com.app.nestedrecyclerview;

import java.util.ArrayList;

public class VerticalModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<HorizontalModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<HorizontalModel> arrayList) {
        this.arrayList = arrayList;
    }

    String name;
    ArrayList<HorizontalModel> arrayList;
}
