package com.hibernatesandbox.attributePojo;

import java.io.Serializable;

public class LocalizationJsonType implements Serializable {

    private String ru;
    private String en;

    public void setRu(String ru) {
        this.ru = ru;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getRu() {
        return ru;
    }

    public String getEn() {
        return en;
    }

    public LocalizationJsonType() {

    }

    public LocalizationJsonType(String ru, String en) {
        this.ru = ru;
        this.en = en;
    }

}
