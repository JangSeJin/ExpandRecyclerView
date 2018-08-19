package com.hour24.expandrecyclerview;

import java.util.ArrayList;

public class ModelItem {

    // main
    public String category;
    public boolean isExpand = false;
    public ArrayList<ModelItem> items;

    // item
    public boolean isChecked = false;
    public String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ModelItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ModelItem> items) {
        this.items = items;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }
}
