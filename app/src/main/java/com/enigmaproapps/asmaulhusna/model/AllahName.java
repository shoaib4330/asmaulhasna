package com.enigmaproapps.asmaulhusna.model;

/**
 * Created by shoaibanwar on 3/10/17.
 */

public final class AllahName {

    private String nameOfAllah;
    private String translation;
    private int nameIndex;

    public String getNameOfAllah() {
        return nameOfAllah;
    }

    public void setNameOfAllah(String nameOfAllah) {
        this.nameOfAllah = nameOfAllah;
    }

    public void setNameIndex(int nameIndex){
        this.nameIndex = nameIndex;
    }

    public int getNameIndex(){
        return this.nameIndex;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

}
