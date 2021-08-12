package com.mccree.review.main;

/**
 * Created by: lixingzhou
 * Created Date: 2021/7/7 10:08
 * Description:
 */
public class Module {

    private int index;
    private String moduleName;

    public Module(int index, String moduleName) {
        this.index = index;
        this.moduleName = moduleName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public String toString() {
        return "Module{" +
                "index=" + index +
                ", moduleName='" + moduleName + '\'' +
                '}';
    }
}
