package com.Destura.notesapp;

public class  oopModalclass {
    String oQuestion;
    String poA;
    String poB;
    String poC;
    String poD;
    String pans;

    public oopModalclass(){}
    public oopModalclass(String oQuestion, String poA, String poB, String poC, String poD, String pans) {
        this.oQuestion = oQuestion;
        this.poA = poA;
        this.poB = poB;
        this.poC = poC;
        this.poD = poD;
        this.pans = pans;
    }

    public String getoQuestion() {
        return oQuestion;
    }

    public void setoQuestion(String oQuestion) {
        this.oQuestion = oQuestion;
    }

    public String getPoA() {
        return poA;
    }

    public void setPoA(String poA) {
        this.poA = poA;
    }

    public String getPoB() {
        return poB;
    }

    public void setPoB(String poB) {
        this.poB = poB;
    }

    public String getPoC() {
        return poC;
    }

    public void setPoC(String poC) {
        this.poC = poC;
    }

    public String getPoD() {
        return poD;
    }

    public void setPoD(String poD) {
        this.poD = poD;
    }

    public String getPans() {
        return pans;
    }

    public void setPans(String pans) {
        this.pans = pans;
    }
}

